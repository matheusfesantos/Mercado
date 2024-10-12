import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Objects;

public class TelaPrincipal extends Application {
    private String nomeUsuario;
    private String nomeUsuarioCdastro;
    private String cpf;
    private String endereco;


    public TelaPrincipal(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public TelaPrincipal(String nomeUsuarioCdastro, String cpf, String endereco) {
        this.nomeUsuario = nomeUsuarioCdastro;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MERCADO");
        primaryStage.getIcons().add(new Image("file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Logos/JanelaLogo.png"));

        BorderPane TelaPrincipal = new BorderPane();
        Image backgroundImage = new Image("file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/PlanosDeFundo/Wallpaper_TelaLogin.jpg");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(800);
        backgroundView.setFitHeight(500);
        TelaPrincipal.getChildren().add(backgroundView);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle(
                "-fx-background-color: transparent;" +
        "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.5), 10, 0, 2, 2);"
);


        VBox botoesContainer = new VBox(15);
        botoesContainer.setAlignment(Pos.CENTER);
        botoesContainer.setPadding(new Insets(10));

        botoesContainer.getChildren().addAll(comprasBox);
        vbox.getChildren().addAll(botoesContainer);
        TelaPrincipal.setCenter(vbox);

        HBox rodapeSuperior = new HBox(10);
        rodapeSuperior.setAlignment(Pos.CENTER_LEFT);
        rodapeSuperior.setPadding(new Insets(10));
        rodapeSuperior.setStyle("-fx-background-color: #2F4F4F; -fx-padding: 8;");

        Label titleLabel = new Label("Bem vindo, " + nomeUsuario + "!");
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px; -fx-font-weight: bold; -fx-text-transform: uppercase;");

        Button perfilButton = new Button("PERFIL");
        perfilButton.setAlignment(Pos.CENTER_RIGHT);
        perfilButton.setStyle("-fx-background-color: white; -fx-text-fill: #2F4F4F; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 2, 2); " +
                "-fx-font-size: 16px; " +
                "-fx-padding: 10 20;");
        perfilButton.setOnAction(e -> {
            Stage perfilStage = new Stage();
            Perfil perfil = new Perfil(nomeUsuario, cpf, endereco);
            perfil.start(perfilStage);
            ((Stage) perfilButton.getScene().getWindow()).close();
        });

        Button sairButton = new Button("SAIR");
        sairButton.setAlignment(Pos.TOP_LEFT);
        sairButton.setStyle("-fx-background-color: white; -fx-text-fill: #2F4F4F; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 2, 2); " +
                "-fx-font-size: 16px; " +
                "-fx-padding: 10 20;");
        sairButton.setOnAction(e -> {
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.start(new Stage());
                ((Stage) sairButton.getScene().getWindow()).close();
        });

        rodapeSuperior.getChildren().addAll(titleLabel, perfilButton, sairButton);
        rodapeSuperior.setAlignment(Pos.CENTER_LEFT);
        TelaPrincipal.setTop(rodapeSuperior);

        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(10));
        footer.setStyle("-fx-background-color: #2F4F4F; -fx-text-fill: white;");

        Label footerLabel = new Label("By Matheus Ferreira");
        footerLabel.setStyle("-fx-text-fill: white; -fx-background-color: #2F4F4F; -fx-padding: 10; -fx-font-weight: bold;");
        footer.getChildren().add(footerLabel);
        TelaPrincipal.setBottom(footer);

        Scene scene = new Scene(TelaPrincipal, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    HBox comprasBox = criarBotaoComDescricao("PRODUTOS", "Navegue pelos produtos disponíveis.");

    private HBox criarBotaoComDescricao(String botaoTexto, String descricaoTexto) {
        Button button = new Button(botaoTexto);
        button.setStyle("-fx-background-color: #2F4F4F; -fx-text-fill: white; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 2, 2); " +
                "-fx-font-size: 16px; " +
                "-fx-padding: 10 20;");

        button.setOnAction(e -> {
            if(Objects.equals(nomeUsuario, "Visitante")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mercado Food Erro");
                alert.setHeaderText(null);
                alert.setContentText("FAÇA LOGIN OU SE CADASTRE");
                alert.showAndWait();
                return;
            } else if (botaoTexto.equals("PRODUTOS")){
                Produtos produtos = new Produtos(nomeUsuario);
                produtos.start(new Stage());
                ((Stage) button.getScene().getWindow()).close();
            }
            else {
                javax.swing.JOptionPane.showMessageDialog(null, "Essa área está em manutenção", "Mercadionsons Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        });

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(button);

        return hbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}