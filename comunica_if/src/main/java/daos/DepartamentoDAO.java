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
        String sql = "INSERT INTO Departamento (nome) VALUES (?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, e.getNome());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1);
                e.setCodigo(idGerado);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar Departamento: " + ex.getMessage());
        }
    }

    public void atualizar(Departamento departamentoAtualizado) {
        String sql = "UPDATE Departamento SET nome = ? WHERE codigo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, departamentoAtualizado.getNome());
            stmt.setInt(2, departamentoAtualizado.getCodigo());
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
                d.setCodigo(rs.getInt("codigo"));
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
                    d.setCodigo(rs.getInt("codigo"));
                    d.setNome(rs.getString("nome"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Departamento por ID: " + ex.getMessage());
        }

        return d;
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Departamento WHERE codigo = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir Departamento: " + ex.getMessage());
        }
    }

    public boolean possuiServidoresVinculados(int departamentoId) {
        String sql = "SELECT 1 FROM Servidor WHERE departamento_id = ? LIMIT 1";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, departamentoId);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Retorna true se houver ao menos um servidor vinculado
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao verificar servidores vinculados: " + ex.getMessage());
            return false;
        }
    }

}
