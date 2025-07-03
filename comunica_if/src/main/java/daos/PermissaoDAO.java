package daos;

import BD.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Permissao;

public class PermissaoDAO {

    private final Connection conexao;

    public PermissaoDAO() {
        this.conexao = Conexao.conectar(); // substitua pelo seu método de conexão real
    }

    // Inserir nova permissão
    public void salvar(Permissao p) {
        String sql = "INSERT INTO Permissao (descricao) VALUES (?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, p.getDescricao());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                p.setCodigo(generatedKeys.getInt(1));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao salvar permissão: " + ex.getMessage());
        }
    }

    // Atualizar permissão existente
    public void atualizar(Permissao p) {
        String sql = "UPDATE Permissao SET descricao = ? WHERE codigo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar permissão: " + ex.getMessage());
        }
    }

    // Listar todas as permissões
    public List<Permissao> listar() {
        List<Permissao> lista = new ArrayList<>();
        String sql = "SELECT * FROM Permissao";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Permissao p = new Permissao(
                    rs.getInt("codigo"),
                    rs.getString("descricao")
                );
                lista.add(p);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar permissões: " + ex.getMessage());
        }

        return lista;
    }

    // Buscar permissão por ID
    public Permissao buscarPorId(int id) {
        String sql = "SELECT * FROM Permissao WHERE codigo = ?";
        Permissao p = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    p = new Permissao(
                        rs.getInt("codigo"),
                        rs.getString("descricao")
                    );
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar permissão por ID: " + ex.getMessage());
        }

        return p;
    }
}

