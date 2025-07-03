package daos;

import BD.Conexao;
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
        String sql = "INSERT INTO Servidor (nome, usuario, senha, departamento_id, permissao_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, s.getNome());
            stmt.setString(2, s.getUsuario());
            stmt.setString(3, s.getSenha());
            stmt.setInt(4, s.getDepartamento().getCodigo());
            stmt.setInt(5, s.getPermissao().getCodigo());
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
        String sql = "UPDATE Servidor SET nome = ?, usario = ?, senha = ?, departamento_id = ?, permissao_id = ? WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, s.getNome());
            stmt.setString(2, s.getUsuario());
            stmt.setString(3, s.getSenha());
            stmt.setInt(4, s.getDepartamento().getCodigo());
            stmt.setInt(5, s.getPermissao().getCodigo());
            stmt.setInt(6, s.getCodigo());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Servidor: " + ex.getMessage());
        }
    }

    // Listar todos os servidores
    public List<Servidor> listar() {
        List<Servidor> lista = new ArrayList<>();
        String sql = "SELECT * FROM Servidor";

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

                lista.add(s);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar Servidores: " + ex.getMessage());
        }

        return lista;
    }

    // Buscar servidor por ID
    public Servidor buscarPorId(int id) {
        String sql = "SELECT * FROM Servidor WHERE id = ?";
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

                    s.setUsuario(rs.getString("usuario"));
                    s.setSenha(rs.getString("senha"));
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Servidor por ID: " + ex.getMessage());
        }

        return s;
    }
}
