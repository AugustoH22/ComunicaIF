package daos;

import BD.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Curso;
import models.Turma;

public class TurmaDAO {

    private final Connection conexao;

    public TurmaDAO() {
        this.conexao = Conexao.conectar();// ajuste conforme seu método de conexão
    }

    // Salvar nova turma
    public void salvar(Turma t) {
        String sql = "INSERT INTO Turma (id, nome, curso_id, ano, semestre) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, t.getId());
            stmt.setString(2, t.getNome());
            stmt.setInt(3, t.getCurso().getCodigo());
            stmt.setString(4, t.getAno());
            stmt.setString(5, t.getSemestre());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                t.setId(generatedKeys.getInt(1));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao salvar Turma: " + ex.getMessage());
        }
    }

    // Atualizar turma existente
    public void atualizar(Turma t) {
        String sql = "UPDATE Turma SET nome = ?, curso_id = ?, ano = ?, semestre = ? WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, t.getNome());
            stmt.setInt(2, t.getCurso().getCodigo());
            stmt.setString(3, t.getAno());
            stmt.setString(4, t.getSemestre());
            stmt.setInt(5, t.getId());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Turma: " + ex.getMessage());
        }
    }

    // Listar todas as turmas
    public List<Turma> listar() {
        List<Turma> turmas = new ArrayList<>();
        String sql = "SELECT * FROM Turma";

        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Turma t = new Turma();
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setAno(rs.getString("ano"));
                t.setSemestre(rs.getString("semestre"));

                // Carregar o curso relacionado
                Curso curso = new CursoDAO().buscarPorId(rs.getInt("curso_id"));
                t.setCurso(curso);

                turmas.add(t);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar Turmas: " + ex.getMessage());
        }

        return turmas;
    }

    // Buscar turma por ID
    public Turma buscarPorId(int id) {
        String sql = "SELECT * FROM Turma WHERE id = ?";
        Turma t = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    t = new Turma();
                    t.setId(rs.getInt("id"));
                    t.setNome(rs.getString("nome"));
                    t.setAno(rs.getString("ano"));
                    t.setSemestre(rs.getString("semestre"));

                    Curso curso = new CursoDAO().buscarPorId(rs.getInt("curso_id"));
                    t.setCurso(curso);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Turma por ID: " + ex.getMessage());
        }

        return t;
    }
}
