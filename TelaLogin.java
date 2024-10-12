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
import javafx.scene.control.Alert.AlertType;

public class TelaLogin extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MERCADO");
        primaryStage.getIcons().add(new Image("file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Logos/JanelaLogo.png"));

        BorderPane root = new BorderPane();
        Image backgroundImage = new Image("file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/PlanosDeFundo/Wallpaper_TelaLogin.jpg");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(800);
        backgroundView.setFitHeight(500);
        root.getChildren().add(backgroundView);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label titleLabel = new Label("AREA DE LOGIN");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: white; -fx-font-weight: bold; -fx-text-transform: uppercase;");

        Label usuarioLabel = new Label("Nome:");
        usuarioLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-text-transform: uppercase;");
        TextField usuarioField = new TextField();

        Label senhaLabel = new Label("Senha:");
        senhaLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-text-transform: uppercase;");
        PasswordField senhaField = new PasswordField();

        Button botaoLogin = new Button("Login");
        botaoLogin.setStyle("-fx-background-color: #2F4F4F; -fx-text-fill: white; -fx-pref-width: 100px; -fx-font-size: 16px; -fx-font-weight: bold; -fx-text-transform: uppercase;");

        Button botaoVisitante = new Button("CADASTRE-SE");
        botaoVisitante.setStyle("-fx-background-color: #2F4F4F; -fx-text-fill: white; -fx-pref-width: 100px; -fx-font-size: 10px; -fx-font-weight: bold; -fx-text-transform: uppercase;");

        grid.add(titleLabel, 0, 0, 2, 1);
        grid.add(usuarioLabel, 0, 1);
        grid.add(usuarioField, 1, 1);
        grid.add(senhaLabel, 0, 2);
        grid.add(senhaField, 1, 2);
        grid.add(botaoLogin, 1, 3);
        grid.add(botaoVisitante, 1, 4);

        botaoLogin.setOnAction(e -> {
            String usuario = usuarioField.getText();
            String senha = senhaField.getText();

            if (!usuario.isEmpty() && senha.equals("a")) {
                System.out.println("Login bem-sucedido!");
                TelaPrincipal telaPrincipal = new TelaPrincipal(usuario);
                try {
                    telaPrincipal.start(new Stage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                primaryStage.close();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Mercado Food Erro");
                alert.setHeaderText(null);
                alert.setContentText("Usuário ou senha incorretos.");
                alert.showAndWait();
            }
        });

        botaoVisitante.setOnAction(e -> {
           Cadastro cadastro = new Cadastro();
            try {
                cadastro.start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            primaryStage.close();
        });

        VBox loginBox = new VBox(grid);
        loginBox.setAlignment(Pos.CENTER_LEFT);
        loginBox.setPadding(new Insets(20));
        loginBox.setStyle(
                "-fx-background-color: transparent; " +
                        "-fx-background-radius: 30; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 10, 0, 2, 2);" +
                        "-fx-border-color: #2F4F4F; " +
                        "-fx-border-radius: 30;" +
                        "-fx-border-width: 4;"
        );

        loginBox.setMaxWidth(300);
        loginBox.setMaxHeight(300);

        root.setCenter(loginBox);

        //Rodapé
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(10));
        footer.setStyle("-fx-background-color: #2F4F4F; -fx-text-fill: white;");

        Label footerLabel = new Label("By Matheus Ferreira");
        footerLabel.setStyle("-fx-text-fill: white; -fx-background-color: #2F4F4F;-fx-padding: 10;-fx-font-weight: bold; -fx-text-transform: uppercase;");

        Image githubImage = new Image("file:");
        ImageView githubImageView = new ImageView(githubImage);
        githubImageView.setFitWidth(20);
        githubImageView.setFitHeight(20);

        footer.getChildren().addAll(footerLabel, githubImageView);
        root.setBottom(footer);

        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}