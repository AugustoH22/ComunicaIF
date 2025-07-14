package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import BD.Conexao;

public class GerenciaLogin {

    private static final int DESLOCAMENTO = 4; // Valor de deslocamento para criptografia

    public static String criptografarSenha(String senha) {
        StringBuilder criptografada = new StringBuilder();

        for (char c : senha.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char deslocado = (char) ((c - base + DESLOCAMENTO) % 26 + base);
                criptografada.append(deslocado);
            } else if (Character.isDigit(c)) {
                char deslocado = (char) ((c - '0' + DESLOCAMENTO) % 10 + '0');
                criptografada.append(deslocado);
            } else {
                criptografada.append(c); // Mantém caracteres não alfabéticos inalterados
            }
        }

        return criptografada.toString();
    }

    // Função para salvar senhas criptografadas
    public static boolean alterarSenha(String usuario, String novaSenha) {
        Connection conn = Conexao.conectar();
        String sql = "UPDATE servidor SET senha = ? WHERE usuario = ?";

        String senhaCriptografada = criptografarSenha(novaSenha);

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, senhaCriptografada);
            ps.setString(2, usuario);

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0; // true se atualizou, false se o usuário não foi encontrado
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Função para verificar o login
    public static boolean verificarLogin(String usuario, String senha) {
        Connection conn = Conexao.conectar();
        String sql = "SELECT senha FROM servidor WHERE usuario = ?";
        String senhaCriptografada = criptografarSenha(senha);

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String senhaArmazenada = rs.getString("senha");
                    return senhaCriptografada.equals(senhaArmazenada);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Conexão será fechada externamente
        return false;
    }

}
