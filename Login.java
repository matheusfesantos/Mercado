import java.util.Scanner;

public class Login{
    public static void main() {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        LimparTela limparTela = new LimparTela();

        final String USUARIO = "login";
        final String SENHA = "senha";
        Scanner scanner = new Scanner(System.in);

            System.out.print("Login:");
            String login = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            if (login.equals(USUARIO) && senha.equals(SENHA)) {
                System.out.println("Login bem-sucedido!");
                limparTela.TelaLimpa();
                telaPrincipal.Tela();
            } else {
                System.out.println("Login ou senha incorretos. Tente novamente.");
                Login.main();
            }
        }
    }
