import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Produtos extends Application {
    private String nomeUsuario;
    private List<String> produtosSelecionados;
    private List<VBox> produtoBoxes;
    private List<Spinner<Integer>> quantidadeSpinners;

    public Produtos(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.produtosSelecionados = new ArrayList<>();
        this.produtoBoxes = new ArrayList<>();
        this.quantidadeSpinners = new ArrayList<>();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Área de Compras");
        primaryStage.getIcons().add(new Image("file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Logos/JanelaLogo.png"));

        BorderPane root = new BorderPane();
        Image backgroundImage = new Image("file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/PlanosDeFundo/Wallpaper_TelaLogin.jpg");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(800);
        backgroundView.setFitHeight(500);
        root.getChildren().add(backgroundView);

        HBox cabecalho = new HBox(10);
        cabecalho.setAlignment(Pos.CENTER_LEFT);
        cabecalho.setPadding(new Insets(10));
        cabecalho.setStyle("-fx-background-color: #2F4F4F; -fx-padding: 8;");

        Button voltarButton = new Button("VOLTAR");
        voltarButton.setStyle("-fx-background-color: white; -fx-text-fill: #2F4F4F; " +
                "-fx-font-size: 16px; -fx-padding: 10 20;");

        voltarButton.setOnAction(e -> {
            Stage telaprincipalStage = new Stage();
            TelaPrincipal telaPrincipal = new TelaPrincipal(nomeUsuario);
            telaPrincipal.start(telaprincipalStage);
            primaryStage.close();
        });

        cabecalho.getChildren().addAll(voltarButton);
        root.setTop(cabecalho);

        VBox searchBox = new VBox(10);
        TextField searchField = new TextField();
        searchField.setPromptText("Pesquise um produto...");
        searchField.setStyle("-fx-padding: 5; -fx-font-size: 14px;");

        Button searchButton = new Button("Pesquisar");
        searchButton.setOnAction(e -> filtrarProdutos(searchField.getText()));
        searchButton.setStyle("-fx-background-color: white; -fx-text-fill: #2F4F4F; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 2, 2); " +
                "-fx-font-size: 16px; " +
                "-fx-padding: 10 20;");

        searchBox.getChildren().addAll(searchField, searchButton);
        searchBox.setPadding(new Insets(10));
        root.setTop(new VBox(cabecalho, searchBox));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(10));

        CheckBox bananaCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Banana", "R$ 2,00", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Bananas.png", bananaCheckBox, 0, 0);

        CheckBox macaCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Maçã", "R$ 2,50", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Maças.png", macaCheckBox, 1, 0);

        CheckBox leiteCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Leite", "R$ 6,50", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Leite.png", leiteCheckBox, 2, 0);

        CheckBox arrozCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Arroz", "R$ 5,00", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Arroz.png", arrozCheckBox, 3, 0);

        CheckBox carneCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Carne", "R$ 20,00", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Carne.png", carneCheckBox, 0, 1);

        CheckBox feijaoCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Feijão", "R$ 8,00", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Feijao.png", feijaoCheckBox, 1, 1);

        CheckBox batataCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Batata", "R$ 3,00", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Batata.png", batataCheckBox, 2, 1);

        CheckBox cenouraCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Cenoura", "R$ 4,00", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Cenoura.png", cenouraCheckBox, 3, 1);

        CheckBox tomateCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Tomate", "R$ 3,50", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Tomate.png", tomateCheckBox, 0, 2);

        CheckBox queijoCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Queijo", "R$ 15,00", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Queijo.png", queijoCheckBox, 1, 2);

        CheckBox ovosCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Ovos", "R$ 10,00", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Ovos.png", ovosCheckBox, 2, 2);

        CheckBox paoCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Pão", "R$ 4,50", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Pao.png", paoCheckBox, 3, 2);

        CheckBox macarraoCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Macarrão", "R$ 7,00", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Macarrao.png", macarraoCheckBox, 0, 3);

        CheckBox saladaCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Salada", "R$ 9,00", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Salada.png", saladaCheckBox, 1, 3);

        CheckBox sucoCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Suco", "R$ 5,00", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Suco.png", sucoCheckBox, 2, 3);

        CheckBox boloCheckBox = new CheckBox();
        adicionarProduto(gridPane, "Bolo", "R$ 12,00", "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Produtos/Bolo.png", boloCheckBox, 3, 3);


        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: transparent; -fx-border-color: transparent;");

        Button finalizarButton = new Button("COMPRAR");
        finalizarButton.setStyle("-fx-background-color: #2F4F4F; -fx-text-fill: white; " +
                "-fx-font-size: 16px; -fx-padding: 10 20;");

        finalizarButton.setOnAction(e -> {
            produtosSelecionados.clear();

            if (bananaCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(0).getValue();
                produtosSelecionados.add("Banana - R$ 2,00 - Quantidade: " + quantidade);
            }
            if (macaCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(1).getValue();
                produtosSelecionados.add("Maçã - R$ 2,50 - Quantidade: " + quantidade);
            }
            if (leiteCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(2).getValue();
                produtosSelecionados.add("Leite - R$ 6,50 - Quantidade: " + quantidade);
            }
            if (arrozCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(3).getValue();
                produtosSelecionados.add("Arroz - R$ 5,00 - Quantidade: " + quantidade);
            }
            if (carneCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(4).getValue();
                produtosSelecionados.add("Carne - R$ 20,00 - Quantidade: " + quantidade);
            }
            if (feijaoCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(5).getValue();
                produtosSelecionados.add("Feijão - R$ 8,00 - Quantidade: " + quantidade);
            }
            if (batataCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(6).getValue();
                produtosSelecionados.add("Batata - R$ 3,00 - Quantidade: " + quantidade);
            }
            if (cenouraCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(7).getValue();
                produtosSelecionados.add("Cenoura - R$ 4,00 - Quantidade: " + quantidade);
            }
            if (tomateCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(8).getValue();
                produtosSelecionados.add("Tomate - R$ 3,50 - Quantidade: " + quantidade);
            }
            if (queijoCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(9).getValue();
                produtosSelecionados.add("Queijo - R$ 15,00 - Quantidade: " + quantidade);
            }
            if (ovosCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(10).getValue();
                produtosSelecionados.add("Ovos - R$ 10,00 - Quantidade: " + quantidade);
            }
            if (paoCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(11).getValue();
                produtosSelecionados.add("Pão - R$ 4,50 - Quantidade: " + quantidade);
            }
            if (macarraoCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(12).getValue();
                produtosSelecionados.add("Macarrão - R$ 7,00 - Quantidade: " + quantidade);
            }
            if (saladaCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(13).getValue();
                produtosSelecionados.add("Salada - R$ 9,00 - Quantidade: " + quantidade);
            }
            if (sucoCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(14).getValue();
                produtosSelecionados.add("Suco - R$ 5,00 - Quantidade: " + quantidade);
            }
            if (boloCheckBox.isSelected()) {
                int quantidade = quantidadeSpinners.get(15).getValue();
                produtosSelecionados.add("Bolo - R$ 12,00 - Quantidade: " + quantidade);
            }
            if (produtosSelecionados.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mercado Food Erro");
                alert.setHeaderText(null);
                alert.setContentText("Nenhum produto selecionado");
                alert.showAndWait();
                return;
            }

            Stage carrinhoStage = new Stage();
            Carrinho carrinho = new Carrinho(nomeUsuario, produtosSelecionados);
            carrinho.start(carrinhoStage);
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(scrollPane, finalizarButton);
        root.setCenter(vbox);

        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void adicionarProduto(GridPane gridPane, String nome, String preco, String imagemPath, CheckBox checkBox, int coluna, int linha) {
        VBox produtoBox = new VBox();
        produtoBox.setAlignment(Pos.CENTER);
        produtoBox.setSpacing(10);
        produtoBox.setStyle("-fx-background-color: #2F4F4F; -fx-padding: 5; -fx-border-color: white; -fx-border-width: 2;");

        ImageView imagem = new ImageView(new Image(imagemPath));
        imagem.setFitHeight(80);
        imagem.setFitWidth(60);

        Label nomeLabel = new Label(nome);
        nomeLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #FFFFFF; -fx-font-weight: bold;");

        Label precoLabel = new Label("R$ " + preco);
        precoLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #FFFFFF;");

        Spinner<Integer> quantidadeSpinner = new Spinner<>(1, 10, 1);
        quantidadeSpinner.setEditable(true);
        quantidadeSpinner.setStyle("-fx-font-size: 14px; -fx-padding: 5;");

        produtoBox.getChildren().addAll(checkBox, imagem, nomeLabel, precoLabel, quantidadeSpinner);
        gridPane.add(produtoBox, coluna, linha);
        produtoBoxes.add(produtoBox);
        quantidadeSpinners.add(quantidadeSpinner);
    }

    private void filtrarProdutos(String query) {
        boolean encontrouProduto = false;
        for (VBox produtoBox : produtoBoxes) {
            if (produtoBox.getChildren().get(2) instanceof Label) {
                Label nomeLabel = (Label) produtoBox.getChildren().get(2);
                boolean visivel = nomeLabel.getText().toLowerCase().contains(query.toLowerCase());
                produtoBox.setVisible(visivel);
                if (visivel) {
                    encontrouProduto = true;
                }
            }
        }
        if (!encontrouProduto) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pesquisa Sem Resultados");
            alert.setHeaderText(null);
            alert.setContentText("Nenhum produto encontrado para '" + query + "'.");
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}