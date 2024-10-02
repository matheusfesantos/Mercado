import java.util.Scanner;

public class Sessoes {
    public void Areas(){
        Compras compras = new Compras();
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        LimparTela limparTela = new LimparTela();
        Carrinho carrinho = new Carrinho();

        Scanner teclado = new Scanner(System.in);

        System.out.println("Compras(1)");
        System.out.println("Carrinho(2)");
        System.out.println("Pagamentos(3)");
        System.out.println("Volta a Tela Principal(4)");
        System.out.println("Informe a sessao:");

            int escolhaDeTela = teclado.nextInt();

            switch (escolhaDeTela){
                case 1:
                    LimparTela.TelaLimpa();
                    compras.comprasMercado();
                    break;
                case 2:
                    LimparTela.TelaLimpa();
                    carrinho.NotaFiscal();
                    break;
                case 3:
                    LimparTela.TelaLimpa();
                    System.out.println("Pagamentos esta em manutencao");
                    System.out.println("Compras(1)");
                    System.out.println("Carrinho(2)");
                    System.out.println("Pagamentos(3)");
                    System.out.println("Volta a Tela Principal(4)");
                    System.out.println("Informe outra sessao:");
                    break;
                case 4:
                    telaPrincipal.Tela();

                default:
                    System.out.println("Desculpa não entendi");
                    Areas();
            }
        }
    }
