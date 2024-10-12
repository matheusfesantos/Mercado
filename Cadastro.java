import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Cadastro extends Application {

    private String nomeUsuario;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MERCADO");
        primaryStage.getIcons().add(new Image("file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Logos/JanelaLogo.png"));

        BorderPane root = new BorderPane();

        HBox rodapeSuperior = new HBox(10);
        rodapeSuperior.setAlignment(Pos.CENTER_LEFT);
        rodapeSuperior.setPadding(new Insets(10));
        rodapeSuperior.setStyle("-fx-background-color: #2F4F4F; -fx-padding: 8;");

        Button voltarlButton = new Button("VOLTAR");
        voltarlButton.setStyle("-fx-background-color: white; -fx-text-fill: #2F4F4F; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 2, 2); " +
                "-fx-font-size: 16px; " +
                "-fx-padding: 10 20;");

        voltarlButton.setOnAction(e -> {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.start(new Stage());
            primaryStage.close();
        });

        Label titleLabel = new Label("ÁREA DE CADASTRO");
        titleLabel.setStyle("-fx-background-color: #2F4F4F; -fx-text-fill: white; " +
                "-fx-font-size: 18px;-fx-font-weight: bold; " +
                "-fx-text-transform: uppercase; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 2, 2);" +
                "-fx-padding: 10 20;");

        rodapeSuperior.getChildren().addAll(voltarlButton);
        root.setTop(rodapeSuperior);

        ImageView fotoPerfil = new ImageView(new Image("file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Profile.png"));
        fotoPerfil.setFitHeight(150);
        fotoPerfil.setFitWidth(150);
        fotoPerfil.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 2, 2);");

        TextField nomeField = new TextField(nomeUsuario);
        nomeField.setPromptText("Digite seu nome");

        TextField enderecoField = new TextField();
        enderecoField.setPromptText("Digite seu endereço");

        TextField cpfField = new TextField();
        cpfField.setPromptText("Digite seu CPF");

        TextField telefoneField = new TextField();
        telefoneField.setPromptText("Digite seu telefone (opcional)");

        String textFieldStyle = "-fx-background-color: white; -fx-text-fill: #2F4F4F; " +
                "-fx-font-size: 14px; -fx-padding: 10; -fx-background-radius: 10; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 4, 0, 2, 2); " +
                "-fx-font-weight: bold;";
        nomeField.setStyle(textFieldStyle);
        enderecoField.setStyle(textFieldStyle);
        cpfField.setStyle(textFieldStyle);
        telefoneField.setStyle(textFieldStyle);

        Button salvarButton = new Button("CADASTRAR");
        salvarButton.setStyle("-fx-background-color: white; -fx-text-fill: #2F4F4F; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 2, 2); " +
                "-fx-font-size: 16px; " +
                "-fx-padding: 10 20;");

        salvarButton.setOnAction(e -> {
            String nome = nomeField.getText().trim();
            String endereco = enderecoField.getText().trim();
            String cpf = cpfField.getText().trim();
            String telefone = telefoneField.getText().trim();

            if (nome.isEmpty() || endereco.isEmpty() || cpf.isEmpty()) {
                showAlert("Erro", "Preencha todos os campos obrigatórios: Nome, Endereço e CPF.");
                return;
            }
            if (!cpf.matches("\\d{11}")) {
                showAlert("Erro", "CPF inválido. Deve conter 11 dígitos numéricos.");
                return;
            }
            if (!telefone.isEmpty() && !telefone.matches("\\d{10,11}")) {
                showAlert("Erro", "Telefone inválido. Deve conter 10 ou 11 dígitos numéricos.");
                return;
            }
            System.out.println("Nome: " + nome);
            System.out.println("Endereço: " + endereco);
            System.out.println("CPF: " + cpf);

            if (!telefone.isEmpty()) {
                System.out.println("Telefone: " + telefone);
            }

            Stage telaPrincipalStage = new Stage();
            TelaPrincipal telaPrincipal = new TelaPrincipal(nome, cpf, endereco);
            telaPrincipal.start(telaPrincipalStage);
            primaryStage.close();
        });

        VBox perfilContainer = new VBox(15, titleLabel, fotoPerfil, nomeField, enderecoField, cpfField, telefoneField, salvarButton);
        perfilContainer.setAlignment(Pos.CENTER);
        perfilContainer.setPadding(new Insets(20));
        perfilContainer.setStyle("-fx-background-color: transparent;");

        ScrollPane scrollPane = new ScrollPane(perfilContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent;");

        root.setCenter(scrollPane);

        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}