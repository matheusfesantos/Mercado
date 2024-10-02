import java.util.Scanner;

    public class Carrinho{

        public void NotaFiscal() {
        Compras compras = new Compras();
        Scanner scanner = new Scanner(System.in);

            System.out.println("Deseja algo mais ?");

        while (true){
            String algomais = scanner.nextLine();
            if(algomais.equalsIgnoreCase("Sim")){
                compras.comprasMercado();
                break;
            }
            else if(algomais.equalsIgnoreCase("Nao")){
                System.out.println("Erro ao ir para Area de Pagamentos");
                System.out.println("Fale novamente:");
            }
            else {
                System.out.println("Desculpa, não entendi");
                System.out.println("Fale novamente:");
            }
        }
        }
}
