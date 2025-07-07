package daos;

import BD.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Mensagem;
import models.Servidor;
import models.Aluno;

public class MensagemDAO {

    private final Connection conexao;

    public MensagemDAO() {
        this.conexao = Conexao.conectar();
    }

    public void salvar(Mensagem m) {
        String sql = "INSERT INTO Mensagem (assunto, texto, codServidorRemetente, dataHoraCriacao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, m.getAssunto());
            stmt.setString(2, m.getTexto());
            stmt.setInt(3, m.getRemetente().getCodigo());
            stmt.setTimestamp(4, Timestamp.valueOf(m.getDataHoraCriacao()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                m.setCodigo(codigo);

                salvarDestinatarios(m);
                salvarAlunos(m);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao salvar mensagem: " + ex.getMessage());
        }
    }

    private void salvarDestinatarios(Mensagem m) throws SQLException {
        String sql = "INSERT INTO Mensagem_Destinatario (codMensagem, codServidorDestinatario) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            for (Servidor s : m.getDestinatarios()) {
                stmt.setInt(1, m.getCodigo());
                stmt.setInt(2, s.getCodigo());
                stmt.addBatch();
            }
            stmt.executeBatch();
        }
    }

    private void salvarAlunos(Mensagem m) throws SQLException {
        String sql = "INSERT INTO Mensagem_Aluno (codMensagem, codAluno) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            for (Aluno a : m.getAlunos()) {
                stmt.setInt(1, m.getCodigo());
                stmt.setInt(2, a.getCodigo());
                stmt.addBatch();
            }
            stmt.executeBatch();
        }
    }

    public List<Mensagem> listar() {
        List<Mensagem> mensagens = new ArrayList<>();
        String sql = "SELECT * FROM Mensagem";

        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Mensagem m = new Mensagem();
                m.setCodigo(rs.getInt("codigo"));
                m.setAssunto(rs.getString("assunto"));
                m.setTexto(rs.getString("texto"));
                m.setDataHoraCriacao(rs.getTimestamp("dataHoraCriacao").toLocalDateTime());

                // Buscar remetente
                ServidorDAO servidorDAO = new ServidorDAO();
                m.setRemetente(servidorDAO.buscarPorId(rs.getInt("codServidorRemetente")));

                // Buscar destinatários e alunos
                m.setDestinatarios(buscarDestinatarios(m.getCodigo()));
                m.setAlunos(buscarAlunos(m.getCodigo()));

                mensagens.add(m);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar mensagens: " + ex.getMessage());
        }

        return mensagens;
    }

    private List<Servidor> buscarDestinatarios(int codMensagem) {
        List<Servidor> lista = new ArrayList<>();
        String sql = "SELECT codServidorDestinatario FROM Mensagem_Destinatario WHERE codMensagem = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codMensagem);
            try (ResultSet rs = stmt.executeQuery()) {
                ServidorDAO dao = new ServidorDAO();
                while (rs.next()) {
                    lista.add(dao.buscarPorId(rs.getInt("codServidorDestinatario")));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar destinatários: " + ex.getMessage());
        }

        return lista;
    }

    private List<Aluno> buscarAlunos(int codMensagem) {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT codAluno FROM Mensagem_Aluno WHERE codMensagem = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codMensagem);
            try (ResultSet rs = stmt.executeQuery()) {
                AlunoDAO dao = new AlunoDAO();
                while (rs.next()) {
                    lista.add(dao.buscarPorId(rs.getInt("codAluno")));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar alunos: " + ex.getMessage());
        }

        return lista;
    }

    public Mensagem buscarPorId(int id) {
        Mensagem m = null;
        String sql = "SELECT * FROM Mensagem WHERE codigo = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    m = new Mensagem();
                    m.setCodigo(rs.getInt("codigo"));
                    m.setAssunto(rs.getString("assunto"));
                    m.setTexto(rs.getString("texto"));
                    m.setDataHoraCriacao(rs.getTimestamp("dataHoraCriacao").toLocalDateTime());

                    ServidorDAO servidorDAO = new ServidorDAO();
                    m.setRemetente(servidorDAO.buscarPorId(rs.getInt("codServidorRemetente")));

                    m.setDestinatarios(buscarDestinatarios(id));
                    m.setAlunos(buscarAlunos(id));
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar mensagem por ID: " + ex.getMessage());
        }

        return m;
    }

    public List<Mensagem> procurarPorDestinatario(Servidor destinatario) {
        List<Mensagem> mensagens = new ArrayList<>();
        String sql = """
        SELECT m.* FROM Mensagem m
        INNER JOIN Mensagem_Destinatario md ON m.codigo = md.codMensagem
        WHERE md.codServidorDestinatario = ?
        """;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, destinatario.getCodigo());

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Mensagem m = new Mensagem();
                    m.setCodigo(rs.getInt("codigo"));
                    m.setAssunto(rs.getString("assunto"));
                    m.setTexto(rs.getString("texto"));
                    m.setDataHoraCriacao(rs.getTimestamp("dataHoraCriacao").toLocalDateTime());


                    ServidorDAO servidorDAO = new ServidorDAO();
                    m.setRemetente(servidorDAO.buscarPorId(rs.getInt("codServidorRemetente")));

                    m.setDestinatarios(buscarDestinatarios(m.getCodigo()));
                    m.setAlunos(buscarAlunos(m.getCodigo()));

                    mensagens.add(m);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao procurar mensagens por destinatário: " + ex.getMessage());
        }

        return mensagens;
    }

}
