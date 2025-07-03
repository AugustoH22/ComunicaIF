package daos;

import BD.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.HistoricoRestrito;

public class HistoricoRestritoDAO {

    private final Connection conexao;

    public HistoricoRestritoDAO() {
        this.conexao = Conexao.conectar(); // substitua conforme sua estrutura
    }

    // Salvar novo histórico
    public void salvar(HistoricoRestrito h) {
        String sql = "INSERT INTO HistoricoRestrito (dataHora, ocorrencia, anotacao, codAluno, codServidor) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, h.getDataHora());
            stmt.setString(2, h.getOcorrencia());
            stmt.setString(3, h.getAnotacao());
            stmt.setInt(4, h.getCodAluno());
            stmt.setInt(5, h.getCodServidor());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                h.setCodigo(generatedKeys.getInt(1));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao salvar histórico restrito: " + ex.getMessage());
        }
    }

    // Atualizar histórico existente
    public void atualizar(HistoricoRestrito h) {
        String sql = "UPDATE HistoricoRestrito SET dataHora = ?, ocorrencia = ?, anotacao = ?, codAluno = ?, codServidor = ? WHERE codigo = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, h.getDataHora());
            stmt.setString(2, h.getOcorrencia());
            stmt.setString(3, h.getAnotacao());
            stmt.setInt(4, h.getCodAluno());
            stmt.setInt(5, h.getCodServidor());
            stmt.setInt(6, h.getCodigo());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar histórico restrito: " + ex.getMessage());
        }
    }

    // Listar todos os históricos
    public List<HistoricoRestrito> listar() {
        List<HistoricoRestrito> lista = new ArrayList<>();
        String sql = "SELECT * FROM HistoricoRestrito";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                HistoricoRestrito h = new HistoricoRestrito(
                    rs.getInt("codigo"),
                    rs.getString("dataHora"),
                    rs.getString("ocorrencia"),
                    rs.getString("anotacao"),
                    rs.getInt("codAluno"),
                    rs.getInt("codServidor")
                );
                lista.add(h);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar históricos restritos: " + ex.getMessage());
        }

        return lista;
    }

    // Buscar histórico por ID
    public HistoricoRestrito buscarPorId(int id) {
        String sql = "SELECT * FROM HistoricoRestrito WHERE codigo = ?";
        HistoricoRestrito h = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    h = new HistoricoRestrito(
                        rs.getInt("codigo"),
                        rs.getString("dataHora"),
                        rs.getString("ocorrencia"),
                        rs.getString("anotacao"),
                        rs.getInt("codAluno"),
                        rs.getInt("codServidor")
                    );
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar histórico restrito por ID: " + ex.getMessage());
        }

        return h;
    }
}

