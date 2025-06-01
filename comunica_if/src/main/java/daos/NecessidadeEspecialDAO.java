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
        String sql = "INSERT INTO NecessidadeEspecial (codigo, codigoNecessidade, descricao ) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, e.getCodigo());
            stmt.setString(2, e.getCodigoNecessidade());
            stmt.setString(3, e.getDescricao());
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

}
