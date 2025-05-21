package daos;

import BD.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Curso;


public class CursoDAO {

     private final Connection conexao;

    public CursoDAO() {
        this.conexao = Conexao.conectar();
    }
    
    public void salvar(Curso c) {
        String sql = "INSERT INTO Curso (codigo, nome, superior) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, c.getCodigo());
            stmt.setString(2, c.getNome());
            stmt.setBoolean(3, c.isSuperior());
            stmt.executeUpdate();
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1);
                c.setCodigo(idGerado);  
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar Curso: " + ex.getMessage());
        }
    }

    public void editar(Curso cursoAtualizado) {
        String sql = "UPDATE Curso SET nome = ?, superior = ? WHERE codigo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cursoAtualizado.getNome());
            stmt.setBoolean(2, cursoAtualizado.isSuperior());
            stmt.setInt(3, cursoAtualizado.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Curso: " + ex.getMessage());
        }
    }

}
