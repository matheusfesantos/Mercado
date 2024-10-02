import java.util.Scanner;

public class Compras {
    public void comprasMercado() {

        Sessoes sessoes = new Sessoes();
        Carrinho carrinho = new Carrinho();
        DadosMercado mercado = new DadosMercado();
        Scanner scanner = new Scanner(System.in);
        LimparTela limparTela = new LimparTela();
        String produto;

        double valorTotal = 0;
        double quantidadeFeijao = 0.0, valorfeijao = 0.0;
        double quantidadeArroz = 0.0, valorarroz = 0.0;
        double quantidadeManteiga = 0.0, valormanteiga = 0.0;
        double quantidadeLeite = 0.0, valorleite = 0.0;
        double quantidadeDanone = 0.0, valordanone = 0.0;
        double quantidadeSabao = 0.0, valorsabao = 0.0;

        while (true) {
            System.out.println("Informe o produto que deseja (ou escreva 'Finalizar' para encerrar):");
            System.out.println("Insira 'produtos' para saber os produtos disponiveis");
            produto = scanner.nextLine();

            switch (produto.toLowerCase()) {
                case "produtos":
                    System.out.println("Feijão: R$ " + mercado.getFeijao());
                    System.out.println("Arroz: R$ " + mercado.getArroz());
                    System.out.println("Manteiga: R$ " + mercado.getManteiga());
                    System.out.println("Leite: R$ " + mercado.getLeite());
                    System.out.println("Danone: R$ " + mercado.getDanone());
                    comprasMercado();
                    break;

                case "feijao":
                    System.out.println("Preço do feijão: R$ " + mercado.getFeijao());
                    System.out.println("Informe a quantidade:");
                    quantidadeFeijao = scanner.nextDouble();
                    valorfeijao = quantidadeFeijao * mercado.getFeijao();
                    scanner.nextLine();
                    break;

                case "arroz":
                    System.out.println("Preço do arroz: R$ " + mercado.getArroz());
                    System.out.println("Informe a quantidade:");
                    quantidadeArroz = scanner.nextDouble();
                    valorarroz = quantidadeArroz * mercado.getArroz();
                    scanner.nextLine();
                    break;

                case "manteiga":
                    System.out.println("Preço da manteiga: R$ " + mercado.getManteiga());
                    System.out.println("Informe a quantidade:");
                    quantidadeManteiga = scanner.nextDouble();
                    valormanteiga = quantidadeManteiga * mercado.getManteiga();
                    scanner.nextLine();
                    break;

                case "leite":
                    System.out.println("Preço do Leite: R$ " + mercado.getLeite());
                    System.out.println("Informe a quantidade:");
                    quantidadeLeite = scanner.nextDouble();
                    valorleite = quantidadeLeite * mercado.getLeite();
                    scanner.nextLine();
                    break;

                case "danone":
                    System.out.println("Preço do Danone: R$ " + mercado.getDanone());
                    System.out.println("Informe a quantidade:");
                    quantidadeDanone = scanner.nextDouble();
                    valordanone = quantidadeDanone * mercado.getDanone();
                    scanner.nextLine();
                    break;

                default:
                    System.out.println("Produto não reconhecido. Tente novamente.");
                    break;
            }

            System.out.println("Deseja continuar comprando? (Sim/Nao)");
            String continuarCompra = scanner.nextLine();
            if (continuarCompra.equalsIgnoreCase("Nao")) {
                break;
            }
        }

        limparTela.TelaLimpa();

        valorTotal = valorarroz + valorfeijao + valormanteiga + valorleite + valordanone + valorsabao;

        System.out.println("Você comprou");
        if (valorarroz > 0){
            System.out.println(quantidadeArroz +"KG de Arroz: "+ valorarroz);
        }
        if (valorfeijao > 0){
            System.out.println(quantidadeFeijao +"KG de Feijão: "+ valorfeijao);
        }
        if (valormanteiga > 0){
            System.out.println(quantidadeManteiga +" Manteigas: "+ valormanteiga);
        }
        if(valordanone > 0){
            System.out.println(quantidadeDanone +" Danones: "+ valordanone);
        }
        if (valorleite > 0){
            System.out.println(quantidadeLeite +"L de Leite:"+ valorleite);
        }
        System.out.println("Total da compra: R$ " + valorTotal);
        carrinho.NotaFiscal();
    }
}