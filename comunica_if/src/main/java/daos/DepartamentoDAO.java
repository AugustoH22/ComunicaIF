package daos;

import BD.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Departamento;

public class DepartamentoDAO {

        private final Connection conexao;

    public DepartamentoDAO() {
        this.conexao = Conexao.conectar();
    }
    
    public void salvar(Departamento e) {
        String sql = "INSERT INTO Enturmacao (codigo, nome) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, e.getId());
            stmt.setString(2, e.getNome());
            stmt.executeUpdate();
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1);
                e.setId(idGerado);  
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar Aluno: " + ex.getMessage());
        }
    }

    public void atualizarEnturmacao(Departamento departamentoAtualizado) {
        String sql = "UPDATE Enturmacao SET codTurma = ?, codAluno = ?, ano = ?, semestre = ? WHERE codigo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, departamentoAtualizado.getId());
            stmt.setString(2, departamentoAtualizado.getNome());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Aluno: " + ex.getMessage());
        }
    }
}
