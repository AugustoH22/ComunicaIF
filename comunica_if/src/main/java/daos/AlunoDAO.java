package daos;

import BD.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Aluno;


public class AlunoDAO {


    private final Connection conexao;

    public AlunoDAO() {
        this.conexao = Conexao.conectar();
    }
    
    public void salvar(Aluno a) {
        String sql = "INSERT INTO Aluno (codigo, nome) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, a.getCodigo());
            stmt.setString(2, a.getNome());
            stmt.executeUpdate();
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1);
                a.setCodigo(idGerado);  
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar Aluno: " + ex.getMessage());
        }
    }

    public void atualizarEnturmacao(Aluno alunoAtualizado) {
        String sql = "UPDATE Aluno SET nome = ? WHERE codigo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, alunoAtualizado.getNome());
            stmt.setInt(2, alunoAtualizado.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Aluno: " + ex.getMessage());
        }
    }

}
