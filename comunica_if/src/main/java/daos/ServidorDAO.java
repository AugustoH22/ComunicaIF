package daos;

import BD.Conexao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Departamento;
import models.Permissao;
import models.Servidor;

public class ServidorDAO {

    private final Connection conexao;

    public ServidorDAO() {
        this.conexao = Conexao.conectar(); // Ajuste conforme sua classe de conexão
    }

    // Salvar novo servidor
    public void salvar(Servidor s) {
        String sql = "INSERT INTO Servidor (nome, usuario, senha, departamento_id, permissao_id, isFirstLogin, isAtivo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, s.getNome());
            stmt.setString(2, s.getUsuario());
            String senhaCriptografada = criptografarSenha(s.getSenha());
            stmt.setString(3, senhaCriptografada);
            stmt.setInt(4, s.getDepartamento().getCodigo());
            stmt.setInt(5, s.getPermissao().getCodigo());
            stmt.setBoolean(6, true);
            stmt.setBoolean(7, true);
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                s.setCodigo(generatedKeys.getInt(1));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao salvar Servidor: " + ex.getMessage());
        }
    }

    // Atualizar servidor existente
    public void atualizar(Servidor s) {
        String sql = "UPDATE Servidor SET nome = ?, departamento_id = ?, permissao_id = ? WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, s.getNome());
            stmt.setInt(2, s.getDepartamento().getCodigo());
            stmt.setInt(3, s.getPermissao().getCodigo());
            stmt.setInt(4, s.getCodigo());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Servidor: " + ex.getMessage());
        }
    }

    // Listar todos os servidores
    public List<Servidor> listar() {
        List<Servidor> lista = new ArrayList<>();
        String sql = "SELECT * FROM Servidor WHERE isAtivo = true";

        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Servidor s = new Servidor();
                s.setCodigo(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                Departamento departamento = new DepartamentoDAO().buscarPorId(rs.getInt("departamento_id"));
                Permissao permissao = new PermissaoDAO().buscarPorId(rs.getInt("permissao_id"));
                s.setDepartamento(departamento);
                s.setPermissao(permissao);
                s.setUsuario(rs.getString("usuario"));
                s.setSenha(rs.getString("senha"));
                s.setPrimeiroLogin(rs.getBoolean("isFirstLogin"));
                s.setAtivo(rs.getBoolean("isAtivo"));
                lista.add(s);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar Servidores: " + ex.getMessage());
        }

        return lista;
    }

    // Buscar servidor por ID
    public Servidor buscarPorId(int id) {
        String sql = "SELECT * FROM Servidor WHERE id = ? AND isAtivo = true";
        Servidor s = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    s = new Servidor();
                    s.setCodigo(rs.getInt("id"));
                    s.setNome(rs.getString("nome"));
                    s.setUsuario(rs.getString("usuario"));
                    s.setSenha(rs.getString("senha"));
                    Departamento departamento = new DepartamentoDAO().buscarPorId(rs.getInt("departamento_id"));
                    Permissao permissao = new PermissaoDAO().buscarPorId(rs.getInt("permissao_id"));
                    s.setDepartamento(departamento);
                    s.setPermissao(permissao);
                    s.setPrimeiroLogin(rs.getBoolean("isFirstLogin"));
                    s.setAtivo(true);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Servidor por ID: " + ex.getMessage());
        }

        return s;
    }

    public static String criptografarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar senha", e);
        }
    }

    // Função para salvar senhas criptografadas
    public void alterarSenha(String usuario, String novaSenha) {
        String sql = "UPDATE servidor SET senha = ?, isFirstLogin = FALSE WHERE usuario = ?";

        String senhaCriptografada = criptografarSenha(novaSenha);

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, senhaCriptografada);
            ps.setString(2, usuario);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Função para verificar o login
    public boolean verificarLogin(String usuario, String senha) {
        String sql = "SELECT senha FROM servidor WHERE usuario = ? AND isAtivo = true";
        String senhaCriptografada = criptografarSenha(senha);

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, usuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String senhaArmazenada = rs.getString("senha");
                    return senhaCriptografada.equals(senhaArmazenada);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Servidor buscarPorUsuario(String usuario) {
        String sql = "SELECT * FROM servidor WHERE usuario = ? AND isAtivo = true";
        Servidor s = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    s = new Servidor();
                    s.setCodigo(rs.getInt("id"));
                    s.setNome(rs.getString("nome"));
                    s.setUsuario(rs.getString("usuario"));
                    s.setSenha(rs.getString("senha"));

                    Departamento departamento = new DepartamentoDAO().buscarPorId(rs.getInt("departamento_id"));
                    Permissao permissao = new PermissaoDAO().buscarPorId(rs.getInt("permissao_id"));

                    s.setDepartamento(departamento);
                    s.setPermissao(permissao);

                    s.setPrimeiroLogin(rs.getBoolean("isFirstLogin"));
                    s.setAtivo(rs.getBoolean("isAtivo"));
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Servidor por usuário: " + ex.getMessage());
        }

        return s;
    }

    public boolean existeUsuario(String usuario) {
        String sql = "SELECT 1 FROM servidor WHERE usuario = ? LIMIT 1";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Se existe, retorna true
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar existência de usuário: " + e.getMessage());
            return false;
        }
    }

    public List<Servidor> listarServidoresNaoVinculadosNaTurma(int codTurma) {
        List<Servidor> lista = new ArrayList<>();
        String sql = """
        SELECT * FROM servidor 
        WHERE id NOT IN (
            SELECT codServidor FROM turma_servidor WHERE codTurma = ?
        )
    """;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codTurma);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Servidor s = new Servidor();
                    s.setCodigo(rs.getInt("id"));
                    s.setNome(rs.getString("nome"));
                    s.setUsuario(rs.getString("usuario"));
                    s.setSenha(rs.getString("senha"));
                    s.setPrimeiroLogin(rs.getBoolean("isFirstLogin"));
                    s.setAtivo(rs.getBoolean("isAtivo"));

                    Departamento departamento = new DepartamentoDAO().buscarPorId(rs.getInt("departamento_id"));
                    Permissao permissao = new PermissaoDAO().buscarPorId(rs.getInt("permissao_id"));
                    s.setDepartamento(departamento);
                    s.setPermissao(permissao);

                    lista.add(s);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar servidores não vinculados à turma: " + e.getMessage());
        }

        return lista;
    }

    public void inativarServidor(int servidorId) {
        String sqlInativar = "UPDATE Servidor SET isAtivo = false WHERE id = ?";
        String sqlRemoverTurmas = "DELETE FROM turma_servidor WHERE codServidor = ?";

        try (
                PreparedStatement stmtInativar = conexao.prepareStatement(sqlInativar); PreparedStatement stmtRemoverTurmas = conexao.prepareStatement(sqlRemoverTurmas)) {
            // Inativa o servidor
            stmtInativar.setInt(1, servidorId);
            stmtInativar.executeUpdate();

            // Remove vínculos com turmas
            stmtRemoverTurmas.setInt(1, servidorId);
            stmtRemoverTurmas.executeUpdate();

            System.out.println("Servidor inativado e vínculos removidos (exceto mensagens).");

        } catch (SQLException ex) {
            System.out.println("Erro ao inativar servidor e remover vínculos: " + ex.getMessage());
        }
    }

}
