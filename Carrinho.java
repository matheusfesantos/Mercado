import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Carrinho extends Application {
    private String nomeUsuario;
    private List<String> produtosSelecionados;

    public Carrinho(String nomeUsuario, List<String> produtosSelecionados) {
        this.nomeUsuario = nomeUsuario;
        this.produtosSelecionados = produtosSelecionados;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("NOTA FISCAL");
        primaryStage.getIcons().add(new Image("file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Logos/JanelaLogo.png"));


        BorderPane root = new BorderPane();
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        HBox rodapeSuperior = new HBox(10);
        rodapeSuperior.setAlignment(Pos.CENTER_LEFT);
        rodapeSuperior.setPadding(new Insets(10));
        rodapeSuperior.setStyle("-fx-background-color: #2F4F4F; -fx-padding: 8;");

        Label tituloLabel = new Label("Obrigado por comprar conosco " + nomeUsuario);
        tituloLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;");
        rodapeSuperior.getChildren().addAll(tituloLabel);
        root.setTop(rodapeSuperior);

        Label notaFiscalLabel = new Label("NOTA FISCAL");
        notaFiscalLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2F4F4F; -fx-padding: 10;");
        vbox.getChildren().add(notaFiscalLabel);

        VBox produtosVBox = new VBox(10);
        produtosVBox.setPadding(new Insets(10));
        produtosVBox.setAlignment(Pos.TOP_LEFT);

        double total = 0.0;

        if (produtosSelecionados.isEmpty()) {
            Label vazioLabel = new Label("Seu carrinho está vazio.");
            vazioLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #555;");
            produtosVBox.getChildren().add(vazioLabel);
        } else {
            for (String produto : produtosSelecionados) {
                Label produtoLabel = new Label(produto);
                produtoLabel.setStyle("-fx-font-size: 16px;");
                produtosVBox.getChildren().add(produtoLabel);

                // Extrai o preço do produto e soma ao total
                total += calcularPreco(produto);
            }
        }

        ScrollPane scrollPane = new ScrollPane(produtosVBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPadding(new Insets(10));
        scrollPane.setMaxHeight(300); // Limite de altura para o scroll

        vbox.getChildren().add(scrollPane);

        Label totalLabel = new Label("Total: R$ " + String.format("%.2f", total));
        totalLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        vbox.getChildren().add(totalLabel);

        Button finalizarButton = new Button("FAZER PEDIDO");
        finalizarButton.setStyle("-fx-background-color: #2F4F4F; -fx-text-fill: white; " +
                "-fx-font-size: 16px; -fx-padding: 10 20;");
        finalizarButton.setOnAction(e -> {
            Stage entregaStage = new Stage();
            Entrega entrega = new Entrega(nomeUsuario);
            entrega.start(entregaStage);
            primaryStage.close();
        });

        vbox.getChildren().add(finalizarButton);
        root.setCenter(vbox);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private double calcularPreco(String produto) {
        double preco = 0.0;
        try {
            String[] parts = produto.split(" - ");
            String precoString = parts[1].replace("R$", "").replace(",", ".").trim();
            preco = Double.parseDouble(precoString);
        } catch (Exception e) {
            System.err.println("Erro ao processar o preço do produto: " + produto);
        }
        return preco;
    }

    public static void main(String[] args) {
        launch(args);
    }
}