package daos;

import java.util.ArrayList;
import java.util.List;
import models.Curso;


public class CursoDAO {
    
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
            stmt.setInt(1, enturmacaoAtualizado.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Aluno: " + ex.getMessage());
        }
    }

    public Profissional buscarProfissionalPorId(int id) {
        String sql = "SELECT * FROM Profissional WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String especialidade = rs.getString("especialidade");
                return new Profissional(id, nome, especialidade);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar profissional: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public List<Profissional> listarTodosProfissionais() {
        List<Profissional> profissionais = new ArrayList<>();
        String sql = "SELECT * FROM Profissional";
        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String especialidade = rs.getString("especialidade");
                profissionais.add(new Profissional(id, nome, especialidade));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar profissionais: " + ex.getMessage());
            ex.printStackTrace();
        }
        return profissionais;
    }
}
