package daos;

import BD.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Curso;

public class CursoDAO {

    private final Connection conexao;

    public CursoDAO() {
        this.conexao = Conexao.conectar();
    }

    public void salvar(Curso c) {
        String sql = "INSERT INTO Curso (nome) VALUES (?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, c.getNome());
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

    public void atualizar(Curso cursoAtualizado) {
        String sql = "UPDATE Curso SET nome = ? WHERE codigo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cursoAtualizado.getNome());
            stmt.setInt(2, cursoAtualizado.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Curso: " + ex.getMessage());
        }
    }

    public List<Curso> listar() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM Curso";

        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curso c = new Curso();
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                cursos.add(c);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar Cursos: " + ex.getMessage());
        }

        return cursos;
    }

    public Curso buscarPorId(int id) {
        String sql = "SELECT * FROM Curso WHERE codigo = ?";
        Curso c = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    c = new Curso();
                    c.setCodigo(rs.getInt("codigo"));
                    c.setNome(rs.getString("nome"));
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Curso por ID: " + ex.getMessage());
        }

        return c;
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Curso WHERE codigo = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir Curso: " + ex.getMessage());
        }
    }

    public boolean existeTurmaVinculada(int idCurso) {
        String sql = "SELECT 1 FROM Turma WHERE curso_id = ? LIMIT 1";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idCurso);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // se retornar algo, há vínculo
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao verificar se existe turma vinculada: " + ex.getMessage());
            return false;
        }
    }

}
