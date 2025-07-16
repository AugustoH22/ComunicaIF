package daos;

import BD.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.NecessidadeEspecial;

public class NecessidadeEspecialDAO {

    private final Connection conexao;

    public NecessidadeEspecialDAO() {
        this.conexao = Conexao.conectar();
    }

    public void salvar(NecessidadeEspecial e) {
        String sql = "INSERT INTO NecessidadeEspecial (codigoNecessidade, descricao ) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, e.getCodigoNecessidade());
            stmt.setString(2, e.getDescricao());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1);
                e.setCodigo(idGerado);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar Necessidade Especial: " + ex.getMessage());
        }
    }

    public void atualizar(NecessidadeEspecial necessidadeespecialAtualizado) {
        String sql = "UPDATE NecessidadeEspecial SET codigo = ?, codigoNecessidade = ?, descricao = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, necessidadeespecialAtualizado.getCodigo());
            stmt.setString(2, necessidadeespecialAtualizado.getCodigoNecessidade());
            stmt.setString(3, necessidadeespecialAtualizado.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Necessidade Especial: " + ex.getMessage());
        }
    }

    public List<NecessidadeEspecial> listar() {
        List<NecessidadeEspecial> lista = new ArrayList<>();
        String sql = "SELECT * FROM NecessidadeEspecial";

        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                NecessidadeEspecial necessidade = new NecessidadeEspecial();
                necessidade.setCodigo(rs.getInt("codigo"));
                necessidade.setCodigoNecessidade(rs.getString("codigoNecessidade"));
                necessidade.setDescricao(rs.getString("descricao"));
                lista.add(necessidade);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar Necessidades Especiais: " + ex.getMessage());
        }

        return lista;
    }

    public NecessidadeEspecial buscarPorId(int id) {
        String sql = "SELECT * FROM NecessidadeEspecial WHERE codigo = ?";
        NecessidadeEspecial necessidade = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    necessidade = new NecessidadeEspecial();
                    necessidade.setCodigo(rs.getInt("codigo"));
                    necessidade.setCodigoNecessidade(rs.getString("codigoNecessidade"));
                    necessidade.setDescricao(rs.getString("descricao"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Necessidade Especial por ID: " + ex.getMessage());
        }

        return necessidade;
    }

    public void excluir(int id) {
        String sqlDeletarVinculos = "DELETE FROM aluno_necessidades WHERE necessidade_id = ?";
        String sqlDeletarNecessidade = "DELETE FROM NecessidadeEspecial WHERE codigo = ?";

        try (
                PreparedStatement stmt1 = conexao.prepareStatement(sqlDeletarVinculos); PreparedStatement stmt2 = conexao.prepareStatement(sqlDeletarNecessidade)) {
            // Primeiro remove as ligações com os alunos
            stmt1.setInt(1, id);
            stmt1.executeUpdate();

            // Depois remove a necessidade especial
            stmt2.setInt(1, id);
            stmt2.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir Necessidade Especial: " + ex.getMessage());
        }
    }

}
