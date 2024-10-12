import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

public class Perfil extends Application {
    private String nomeUsuario;
    private final String cpf;
    private final String endereco;

    public Perfil(String nomeUsuario, String cpf, String endereco) {
        this.nomeUsuario = nomeUsuario;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MERCADO");
        primaryStage.getIcons().add(new Image("file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Logos/JanelaLogo.png"));

        BorderPane root = new BorderPane();
        Image backgroundImage = new Image("file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/PlanosDeFundo/FundoDeCadastro.png");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(800);
        backgroundView.setFitHeight(500);
        root.getChildren().add(backgroundView);

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
            Stage telaprincipalStage = new Stage();
            TelaPrincipal telaPrincipal = new TelaPrincipal(nomeUsuario);
            telaPrincipal.start(telaprincipalStage);
            ((Stage) voltarlButton.getScene().getWindow()).close();
        });

        Label titleLabel = new Label("ÁREA DE PERFIL");
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
        TextField enderecoField = new TextField(endereco);
        TextField cpfField = new TextField(cpf);
        TextField telefoneField = new TextField()

        String textFieldStyle = "-fx-background-color: white; -fx-text-fill: #2F4F4F; " +
                "-fx-font-size: 14px; -fx-padding: 10; -fx-background-radius: 10; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 4, 0, 2, 2); " +
                "-fx-font-weight: bold;";
        nomeField.setStyle(textFieldStyle);
        enderecoField.setStyle(textFieldStyle);
        cpfField.setStyle(textFieldStyle);
        telefoneField.setStyle(textFieldStyle);
        telefoneField.setPromptText("Digite seu telefone (opcional)");

        Label nomeLabel = new Label("Nome:");
        Label enderecoLabel = new Label("Endereço:");
        Label cpfLabel = new Label("CPF:");
        Label telefoneLabel = new Label("Telefone:");

        Button salvarButton = new Button("SALVAR");
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
                System.out.println("Por favor, preencha todos os campos obrigatórios.");
            } else {
                System.out.println("Nome: " + nome);
                System.out.println("Endereço: " + endereco);
                System.out.println("CPF: " + cpf);
                System.out.println("Telefone: " + (telefone.isEmpty() ? "Não informado" : telefone));
                System.out.println("Alterações salvas com sucesso!");
            }
        });

        VBox perfilContainer = new VBox(15, titleLabel, fotoPerfil,
                nomeLabel, nomeField,
                enderecoLabel, enderecoField,
                cpfLabel, cpfField,
                telefoneLabel, telefoneField,
                salvarButton);
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

    public static void main(String[] args) {
        launch(args);
    }
}