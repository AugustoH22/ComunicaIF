package daos;

import BD.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Aluno;
import models.NecessidadeEspecial;

public class AlunoDAO {

    private final Connection conexao;

    public AlunoDAO() {
        this.conexao = Conexao.conectar();
    }

    public void salvar(Aluno a) {
        String sql = "INSERT INTO Aluno (nome, isativo) VALUES (?, ?)"; // Removido 'codigo', assumindo auto_increment
        String sqlNecessidades = "INSERT INTO aluno_necessidades (aluno_id, necessidade_id) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); PreparedStatement stmtNecessidades = conexao.prepareStatement(sqlNecessidades)) {

            stmt.setString(1, a.getNome());
            stmt.setBoolean(2, true);
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1);
                a.setCodigo(idGerado);

                for (NecessidadeEspecial n : a.getNecessidades()) {
                    stmtNecessidades.setInt(1, idGerado);
                    stmtNecessidades.setInt(2, n.getCodigo());
                    stmtNecessidades.addBatch();
                }

                stmtNecessidades.executeBatch();
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar Aluno: " + ex.getMessage());
        }

    }

    public void atualizar(Aluno alunoAtualizado) {
        String sql = "UPDATE Aluno SET nome = ? WHERE codigo = ?";
        String deletarNecessidades = "DELETE FROM aluno_necessidades WHERE aluno_id = ?";
        String inserirNecessidades = "INSERT INTO aluno_necessidades (aluno_id, necessidade_id) VALUES (?, ?)";

        try (
                PreparedStatement stmt = conexao.prepareStatement(sql); PreparedStatement stmtDel = conexao.prepareStatement(deletarNecessidades); PreparedStatement stmtIns = conexao.prepareStatement(inserirNecessidades)) {
            // Atualiza o nome
            stmt.setString(1, alunoAtualizado.getNome());
            stmt.setInt(2, alunoAtualizado.getCodigo());
            stmt.executeUpdate();

            // Remove necessidades antigas
            stmtDel.setInt(1, alunoAtualizado.getCodigo());
            stmtDel.executeUpdate();

            // Insere novas necessidades
            for (NecessidadeEspecial n : alunoAtualizado.getNecessidades()) {
                stmtIns.setInt(1, alunoAtualizado.getCodigo());
                stmtIns.setInt(2, n.getCodigo());
                stmtIns.addBatch();
            }
            stmtIns.executeBatch();

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Aluno: " + ex.getMessage());
        }
    }

    public List<Aluno> listar() {
        Map<Integer, Aluno> alunoMap = new HashMap<>();

        String sql = """
        SELECT a.codigo AS aluno_id, a.nome AS aluno_nome,
               ne.codigo AS necessidade_id, ne.codigoNecessidade, ne.descricao
        FROM Aluno a
        LEFT JOIN aluno_necessidades an ON a.codigo = an.aluno_id
        LEFT JOIN NecessidadeEspecial ne ON an.necessidade_id = ne.codigo
        WHERE a.isativo = true
        ORDER BY a.codigo
    """;

        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idAluno = rs.getInt("aluno_id");

                Aluno aluno = alunoMap.get(idAluno);
                if (aluno == null) {
                    aluno = new Aluno();
                    aluno.setCodigo(idAluno);
                    aluno.setNome(rs.getString("aluno_nome"));
                    aluno.setNecessidades(new ArrayList<>());
                    alunoMap.put(idAluno, aluno);
                }

                int necessidadeId = rs.getInt("necessidade_id");
                if (necessidadeId != 0) {
                    NecessidadeEspecial n = new NecessidadeEspecial();
                    n.setCodigo(necessidadeId);
                    n.setCodigoNecessidade(rs.getString("codigoNecessidade"));
                    n.setDescricao(rs.getString("descricao"));
                    aluno.getNecessidades().add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar Alunos com necessidades: " + ex.getMessage());
        }

        return new ArrayList<>(alunoMap.values());
    }

    public Aluno buscarPorId(int id) {
        String sql = "SELECT * FROM Aluno WHERE codigo = ? AND isativo = true";
        Aluno a = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a = new Aluno();
                    a.setCodigo(rs.getInt("codigo"));
                    a.setNome(rs.getString("nome"));
                    a.setAtivo(rs.getBoolean("isAtivo"));
                    a.setNecessidades(buscarNecessidadesDoAluno(a.getCodigo()));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Aluno por ID: " + ex.getMessage());
        }

        return a;
    }

    public List<NecessidadeEspecial> buscarNecessidadesDoAluno(int alunoId) {
        List<NecessidadeEspecial> lista = new ArrayList<>();
        String sql = "SELECT ne.codigo, ne.codigoNecessidade, ne.descricao "
                + "FROM NecessidadeEspecial ne "
                + "INNER JOIN aluno_necessidades an ON ne.codigo = an.necessidade_id "
                + "WHERE an.aluno_id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, alunoId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    NecessidadeEspecial n = new NecessidadeEspecial();
                    n.setCodigo(rs.getInt("codigo"));
                    n.setCodigoNecessidade(rs.getString("codigoNecessidade"));
                    n.setDescricao(rs.getString("descricao"));
                    lista.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar necessidades do aluno: " + ex.getMessage());
        }

        return lista;
    }

    public List<Aluno> listarAlunosSemTurma() {
        List<Aluno> lista = new ArrayList<>();
        String sql = """
        SELECT * FROM Aluno 
        WHERE codigo NOT IN (SELECT codAluno FROM turma_aluno)
        AND isativo = true
    """;

        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setCodigo(rs.getInt("codigo"));
                a.setNome(rs.getString("nome"));
                a.setAtivo(rs.getBoolean("isAtivo"));
                a.setNecessidades(buscarNecessidadesDoAluno(a.getCodigo())); // inclui necessidades
                lista.add(a);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar alunos sem turma: " + ex.getMessage());
        }

        return lista;
    }

    public void desativar(int alunoId) {
        String sqlDesativar = "UPDATE Aluno SET isativo = false WHERE codigo = ?";
        String sqlRemoverTurma = "DELETE FROM turma_aluno WHERE codAluno = ?";
        String sqlRemoverNecessidades = "DELETE FROM aluno_necessidades WHERE aluno_id = ?";
        String sqlRemoverMensagens = "DELETE FROM mensagem_aluno WHERE codaluno = ?";

        try (
                PreparedStatement stmtDesativar = conexao.prepareStatement(sqlDesativar); PreparedStatement stmtTurma = conexao.prepareStatement(sqlRemoverTurma); PreparedStatement stmtNecessidades = conexao.prepareStatement(sqlRemoverNecessidades); PreparedStatement stmtMensagens = conexao.prepareStatement(sqlRemoverMensagens)) {
            // Desativa o aluno
            stmtDesativar.setInt(1, alunoId);
            stmtDesativar.executeUpdate();

            // Remove vínculos com turmas
            stmtTurma.setInt(1, alunoId);
            stmtTurma.executeUpdate();

            // Remove vínculos com necessidades especiais
            stmtNecessidades.setInt(1, alunoId);
            stmtNecessidades.executeUpdate();

            // Remove vínculos com mensagens
            stmtMensagens.setInt(1, alunoId);
            stmtMensagens.executeUpdate();

            System.out.println("Aluno desativado e todos vínculos removidos com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao desativar aluno e remover vínculos: " + ex.getMessage());
        }
    }

}
