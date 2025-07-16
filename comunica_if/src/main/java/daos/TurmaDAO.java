package daos;

import BD.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Aluno;
import models.Curso;
import models.Servidor;
import models.Turma;

public class TurmaDAO {

    private final Connection conexao;

    public TurmaDAO() {
        this.conexao = Conexao.conectar();// ajuste conforme seu método de conexão
    }

    // Salvar nova turma
    public void salvar(Turma t) {
        String sql = "INSERT INTO Turma (nome, curso_id, ano) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, t.getNome());
            stmt.setInt(2, t.getCurso().getCodigo());
            stmt.setString(3, t.getAno());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                t.setCodigo(generatedKeys.getInt(1));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao salvar Turma: " + ex.getMessage());
        }
    }

    // Atualizar turma existente
    public void atualizar(Turma t) {
        String sql = "UPDATE Turma SET nome = ?, curso_id = ?, ano = ? WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, t.getNome());
            stmt.setInt(2, t.getCurso().getCodigo());
            stmt.setString(3, t.getAno());
            stmt.setInt(4, t.getCodigo());
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
                t.setCodigo(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setAno(rs.getString("ano"));

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
                    t.setCodigo(rs.getInt("id"));
                    t.setNome(rs.getString("nome"));
                    t.setAno(rs.getString("ano"));

                    Curso curso = new CursoDAO().buscarPorId(rs.getInt("curso_id"));
                    t.setCurso(curso);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Turma por ID: " + ex.getMessage());
        }

        return t;
    }

    // ----------------------------
    // GERENCIAMENTO TURMA_ALUNO
    // ----------------------------
    // Adicionar uma lista de alunos na turma
    public void adicionarAlunosNaTurma(int codTurma, List<Aluno> alunos) {
        String sql = "INSERT INTO turma_aluno (codTurma, codAluno) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            for (Aluno aluno : alunos) {
                stmt.setInt(1, codTurma);
                stmt.setInt(2, aluno.getCodigo());
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar alunos na turma: " + ex.getMessage());
        }
    }

    public void removerAlunosDaTurma(int codTurma, List<Aluno> alunos) {
        String sql = "DELETE FROM turma_aluno WHERE codTurma = ? AND codAluno = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            for (Aluno aluno : alunos) {
                stmt.setInt(1, codTurma);
                stmt.setInt(2, aluno.getCodigo());
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (SQLException ex) {
            System.out.println("Erro ao remover alunos da turma: " + ex.getMessage());
        }
    }

// Remover todos os alunos da turma
    public void removerTodosAlunosDaTurma(int codTurma) {
        String sql = "DELETE FROM turma_aluno WHERE codTurma = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codTurma);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao remover todos os alunos da turma: " + ex.getMessage());
        }
    }

// Listar alunos da turma
    public List<Aluno> listarAlunosDaTurma(int codTurma) {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT a.* FROM aluno a INNER JOIN turma_aluno ta ON a.codigo = ta.codAluno WHERE ta.codTurma = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codTurma);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setCodigo(rs.getInt("codigo"));
                a.setNome(rs.getString("nome"));
                alunos.add(a);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar alunos da turma: " + ex.getMessage());
        }

        return alunos;
    }

    // ----------------------------
    // GERENCIAMENTO TURMA_SERVIDOR
    // ----------------------------
    // Adicionar uma lista de servidores na turma
    public void adicionarServidoresNaTurma(int codTurma, List<Servidor> servidores) {
        String sql = "INSERT INTO turma_servidor (codTurma, codServidor) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            for (Servidor servidor : servidores) {
                stmt.setInt(1, codTurma);
                stmt.setInt(2, servidor.getCodigo());
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar servidores na turma: " + ex.getMessage());
        }
    }

    public void removerServidoresDaTurma(int codTurma, List<Servidor> servidores) {
        String sql = "DELETE FROM turma_servidor WHERE codTurma = ? AND codServidor = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            for (Servidor servidor : servidores) {
                stmt.setInt(1, codTurma);
                stmt.setInt(2, servidor.getCodigo());
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (SQLException ex) {
            System.out.println("Erro ao remover servidores da turma: " + ex.getMessage());
        }
    }

// Remover todos os servidores da turma
    public void removerTodosServidoresDaTurma(int codTurma) {
        String sql = "DELETE FROM turma_servidor WHERE codTurma = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codTurma);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao remover todos os servidores da turma: " + ex.getMessage());
        }
    }

// Listar servidores da turma
    public List<Servidor> listarServidoresDaTurma(int codTurma) {
        List<Servidor> servidores = new ArrayList<>();
        String sql = "SELECT s.* FROM servidor s INNER JOIN turma_servidor ts ON s.id = ts.codServidor WHERE ts.codTurma = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codTurma);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Servidor s = new Servidor();
                s.setCodigo(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                servidores.add(s);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar servidores da turma: " + ex.getMessage());
        }

        return servidores;
    }

    public void excluir(int codTurma) {
        String sql = "DELETE FROM Turma WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codTurma);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir Turma: " + ex.getMessage());
        }
    }

    public boolean possuiVinculoComAlunoOuServidor(int codTurma) {
        String sqlAlunos = "SELECT 1 FROM turma_aluno WHERE codTurma = ? LIMIT 1";
        String sqlServidores = "SELECT 1 FROM turma_servidor WHERE codTurma = ? LIMIT 1";

        try (
                PreparedStatement stmtAluno = conexao.prepareStatement(sqlAlunos); PreparedStatement stmtServidor = conexao.prepareStatement(sqlServidores)) {
            stmtAluno.setInt(1, codTurma);
            ResultSet rsAluno = stmtAluno.executeQuery();
            if (rsAluno.next()) {
                return true; // Existe aluno vinculado
            }

            stmtServidor.setInt(1, codTurma);
            ResultSet rsServidor = stmtServidor.executeQuery();
            if (rsServidor.next()) {
                return true; // Existe servidor vinculado
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao verificar vínculos da turma: " + ex.getMessage());
        }

        return false;
    }

}
