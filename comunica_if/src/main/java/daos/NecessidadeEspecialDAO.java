
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
        String sql = "INSERT INTO Enturmacao (codigo, codigoNecessidade, descricao ) VALUES (?, ?, ?)";
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

    public void atualizarEnturmacao(NecessidadeEspecial necessidadeespecialAtualizado) {
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
}