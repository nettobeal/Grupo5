import entidade.DAO;
import entidade.Usuario;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Object usuario;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DAO dao = new DAO();
        int opcao;

        do {
            System.out.println("\n===== Menu de Cadastro de Usuários =====");
            System.out.println("1. Cadastrar novo usuário");
            System.out.println("2. Listar usuários");
            System.out.println("3. Deletar usuários");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {


                case 1:
                    // Cadastro de novo usuário
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o email do usuário: ");
                    String email = scanner.nextLine();

                    System.out.print("Digite a senha do usuário: ");
                    String senha = scanner.nextLine();

                    System.out.println("Nome: " + nome);
                    System.out.println("Email: " + email);
                    System.out.println("Senha: " + senha);

                    // Cria um objeto Usuario e tenta cadastrar
                    Usuario usuario = new Usuario(nome, email, senha);
                    System.out.println(usuario.getNome());
                    System.out.println(usuario.getEmail());
                    System.out.println(usuario.getSenha());
                    try {
                        dao.cadastroUsuario(usuario);
                        System.out.println("Usuário cadastrado com sucesso!");
                    } catch (Exception e) {
                        System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
                    }
                    break;
                case 2:
                    List<Usuario> usuarios = dao.listarUsuarios();
                    System.out.println("\n===== Lista de Usuários =====");
                    for (Usuario u : usuarios) {
                        System.out.println("Nome: " + u.getNome());
                        System.out.println("Email: " + u.getEmail());
                        System.out.println("Senha: " + u.getSenha());
                        System.out.println("id: " + u.getId());
                        System.out.println("-----------------------------");
                    }
                    break;
                case 3:
                    // Excluir usuário
                    System.out.print("Digite o ID do usuário a ser excluído: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    try {
                        dao.excluirUsuario(id);
                    } catch (Exception e) {
                        System.err.println("Erro ao excluir usuário: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
