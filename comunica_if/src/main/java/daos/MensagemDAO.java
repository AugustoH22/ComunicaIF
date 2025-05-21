package daos;

import BD.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Mensagem;

public class MensagemDAO {

    private final Connection conexao;

    public MensagemDAO() {
        this.conexao = Conexao.conectar();
    }

    // Salvar nova mensagem
    public void salvar(Mensagem m) {
        String sql = "INSERT INTO Mensagem (codigo, titulo, texto, codServidorRemetente, codServidorDestinatario, dataHoraCriacao) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, m.getCodigo());
            stmt.setString(2, m.getTitulo());
            stmt.setString(3, m.getTexto());
            stmt.setInt(4, m.getCodServidorRemetente());
            stmt.setInt(5, m.getCodServidorDestinatario());
            stmt.setString(6, m.getDataHoraCriacao());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                m.setCodigo(generatedKeys.getInt(1));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao salvar mensagem: " + ex.getMessage());
        }
    }

    // Atualizar mensagem existente
    public void atualizar(Mensagem m) {
        String sql = "UPDATE Mensagem SET titulo = ?, texto = ?, codServidorRemetente = ?, codServidorDestinatario = ?, dataHoraCriacao = ? " +
                     "WHERE codigo = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, m.getTitulo());
            stmt.setString(2, m.getTexto());
            stmt.setInt(3, m.getCodServidorRemetente());
            stmt.setInt(4, m.getCodServidorDestinatario());
            stmt.setString(5, m.getDataHoraCriacao());
            stmt.setInt(6, m.getCodigo());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar mensagem: " + ex.getMessage());
        }
    }

    // Listar todas as mensagens
    public List<Mensagem> listar() {
        List<Mensagem> mensagens = new ArrayList<>();
        String sql = "SELECT * FROM Mensagem";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Mensagem m = new Mensagem(
                    rs.getInt("codigo"),
                    rs.getString("titulo"),
                    rs.getString("texto"),
                    rs.getInt("codServidorRemetente"),
                    rs.getInt("codServidorDestinatario"),
                    rs.getString("dataHoraCriacao")
                );
                mensagens.add(m);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar mensagens: " + ex.getMessage());
        }

        return mensagens;
    }

    // Buscar mensagem por ID
    public Mensagem buscarPorId(int id) {
        String sql = "SELECT * FROM Mensagem WHERE codigo = ?";
        Mensagem m = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    m = new Mensagem(
                        rs.getInt("codigo"),
                        rs.getString("titulo"),
                        rs.getString("texto"),
                        rs.getInt("codServidorRemetente"),
                        rs.getInt("codServidorDestinatario"),
                        rs.getString("dataHoraCriacao")
                    );
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar mensagem por ID: " + ex.getMessage());
        }

        return m;
    }
}

