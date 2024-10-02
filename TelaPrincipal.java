import java.util.Scanner;

public class TelaPrincipal {
    public void Tela() {

        LimparTela limparTela = new LimparTela();
        Scanner teclado = new Scanner(System.in);
        Sessoes sessoes = new Sessoes();
        Login login = new Login();

            System.out.println("Bem vindo ao Açucar da Casa");
            System.out.println("Informe seu nome");
            String nome = teclado.nextLine();

           limparTela.TelaLimpa();
        System.out.println("O que deseja ?" + nome);
            sessoes.Areas();

            System.out.println("Ola" + nome);
            System.out.println("Deseja sair(1) ou compar novamente(2) ?");

            while(true){
                int respostafinal = teclado.nextInt();

                switch (respostafinal){
                    case 1:
                        System.out.println("Obrigado por comprar conosco");
                        System.exit(0);
                        break;

                    case 2:
                        LimparTela.TelaLimpa();
                        sessoes.Areas();
                        break;

                    default:
                        System.out.println("Desculpa, não entendi");
                }
            }
        }
    }
