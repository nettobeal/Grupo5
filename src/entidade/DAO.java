package entidade;

import conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class DAO {
    public void cadastroUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, Senha, email) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getEmail());

            ps.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar usuário: " + e.getMessage());
        }


    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT idusuario, nome, senha, email FROM usuario";

        try (Connection conn = ConexaoBD.getConexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idusuario");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                String email = rs.getString("email");

                Usuario usuario = new Usuario(id, nome, email, senha);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar usuários: " + e.getMessage());
        }

        return usuarios;
    }
    public void excluirUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE idusuario = ?";

        try (Connection conn = ConexaoBD.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário com ID " + id + " excluído com sucesso!");
            } else {
                System.out.println("Usuário com ID " + id + " não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir usuário: " + e.getMessage());
        }

    }


}
