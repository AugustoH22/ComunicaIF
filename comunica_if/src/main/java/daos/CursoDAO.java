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

    public void atualizar(Curso cursoAtualizado) {
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

    public List<Curso> listar() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM Curso";

        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curso c = new Curso();
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                c.setSuperior(rs.getBoolean("superior"));
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
                    c.setSuperior(rs.getBoolean("superior"));
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Curso por ID: " + ex.getMessage());
        }

        return c;
    }

}
