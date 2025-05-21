package daos;

import BD.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Departamento;

public class DepartamentoDAO {

    private final Connection conexao;

    public DepartamentoDAO() {
        this.conexao = Conexao.conectar();
    }

    public void salvar(Departamento e) {
        String sql = "INSERT INTO Departamento (codigo, nome) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, e.getId());
            stmt.setString(2, e.getNome());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1);
                e.setId(idGerado);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar Departamento: " + ex.getMessage());
        }
    }

    public void atualizar(Departamento departamentoAtualizado) {
        String sql = "UPDATE Departamento SET nome = ? WHERE codigo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, departamentoAtualizado.getNome());
            stmt.setInt(2, departamentoAtualizado.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Departamento: " + ex.getMessage());
        }
    }

    public List<Departamento> listar() {
        List<Departamento> departamentos = new ArrayList<>();
        String sql = "SELECT * FROM Departamento";

        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Departamento d = new Departamento();
                d.setId(rs.getInt("codigo"));
                d.setNome(rs.getString("nome"));
                departamentos.add(d);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar Departamentos: " + ex.getMessage());
        }

        return departamentos;
    }

    public Departamento buscarPorId(int id) {
        String sql = "SELECT * FROM Departamento WHERE codigo = ?";
        Departamento d = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    d = new Departamento();
                    d.setId(rs.getInt("codigo"));
                    d.setNome(rs.getString("nome"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Departamento por ID: " + ex.getMessage());
        }

        return d;
    }

}
