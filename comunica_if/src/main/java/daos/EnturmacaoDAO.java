package daos;

import java.util.ArrayList;
import java.util.List;
import models.Enturmacao;

public class EnturmacaoDAO {
    
    private final Connection conexao;

    public EnturmacaoDAO() {
        this.conexao = Conexao.conectar();
    }
    
    public void salvar(Enturmacao e) {
        String sql = "INSERT INTO Enturmacao (codigo, codTurma, codAluno, ano, semestre) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, e.getCodigo());
            stmt.setInt(2, e.getCodTurma());
            stmt.setInt(3, e.getCodAluno());
            stmt.setString(4, e.getAno());
            stmt.setString(5, e.getSemestre());
            stmt.executeUpdate();
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1);
                e.setCodigo(idGerado);  
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar Aluno: " + ex.getMessage());
        }
    }

    public void atualizarEnturmacao(Enturmacao enturmacaoAtualizado) {
        String sql = "UPDATE Enturmacao SET codTurma = ?, codAluno = ?, ano = ?, semestre = ? WHERE codigo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, enturmacaoAtualizado.getCodTurma());
            stmt.setInt(2, enturmacaoAtualizado.getCodAluno());
            stmt.setString(3, enturmacaoAtualizado.getAno());
            stmt.setString(4, enturmacaoAtualizado.getSemestre());
            stmt.setInt(5, enturmacaoAtualizado.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Aluno: " + ex.getMessage());
        }
    }
}
