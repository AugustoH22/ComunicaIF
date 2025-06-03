package daos;

import BD.Conexao;
import controller.AlunoController;
import controller.TurmaController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Aluno;
import models.Enturmacao;
import models.Turma;

public class EnturmacaoDAO {
    
    private final Connection conexao;
    
    public EnturmacaoDAO() {
        this.conexao = Conexao.conectar();
    }
    
    public void salvar(Enturmacao e) {
        String sql = "INSERT INTO Enturmacao (codTurma, codAluno, ano, semestre) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, e.getTurma().getCodigo());
            stmt.setInt(2, e.getAluno().getCodigo());
            stmt.setString(3, e.getAno());
            stmt.setString(4, e.getSemestre());
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
    
    public void atualizar(Enturmacao enturmacaoAtualizado) {
        String sql = "UPDATE Enturmacao SET codTurma = ?, codAluno = ?, ano = ?, semestre = ? WHERE codigo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, enturmacaoAtualizado.getTurma().getCodigo());
            stmt.setInt(2, enturmacaoAtualizado.getAluno().getCodigo());
            stmt.setString(3, enturmacaoAtualizado.getAno());
            stmt.setString(4, enturmacaoAtualizado.getSemestre());
            stmt.setInt(5, enturmacaoAtualizado.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Aluno: " + ex.getMessage());
        }
    }
    
    public List<Enturmacao> listar() {
        List<Enturmacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM Enturmacao";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Enturmacao e = new Enturmacao();
                e.setCodigo(rs.getInt("codigo"));
                e.setTurma(buscarPorTurma(rs.getInt("codTurma")));
                e.setAluno(buscarPorAluno(rs.getInt("codAluno")));
                e.setAno(rs.getString("ano"));
                e.setSemestre(rs.getString("semestre"));
                lista.add(e);
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao listar Enturmações: " + ex.getMessage());
        }
        
        return lista;
    }
    
    public Enturmacao buscarPorId(int id) {
        String sql = "SELECT * FROM Enturmacao WHERE codigo = ?";
        Enturmacao e = null;
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    e = new Enturmacao();
                    e.setCodigo(rs.getInt("codigo"));
                    e.setTurma(buscarPorTurma(rs.getInt("codTurma")));
                    e.setAluno(buscarPorAluno(rs.getInt("codAluno")));
                    e.setAno(rs.getString("ano"));
                    e.setSemestre(rs.getString("semestre"));
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao procurar Enturmação por ID: " + ex.getMessage());
        }
        
        return e;
    }
    
    public Turma buscarPorTurma(int id) {       
        TurmaController tc = new TurmaController();
        return tc.buscarTurmaPorId(id);
    }
    
    public Aluno buscarPorAluno(int id){
        AlunoController ac = new AlunoController();
        return ac.buscarPorId(id);
    }
    
}
