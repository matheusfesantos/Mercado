import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Entrega extends Application {
    private String nomeUsuario;

    public Entrega(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MERCADO");
        primaryStage.getIcons().add(new Image("file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Logos/JanelaLogo.png"));

        BorderPane root = new BorderPane();

        HBox rodapeSuperior = new HBox();
        rodapeSuperior.setAlignment(Pos.CENTER);
        rodapeSuperior.setPadding(new Insets(10));
        rodapeSuperior.setStyle("-fx-background-color: #2F4F4F; -fx-padding: 8;");

        Label mensagemLabel = new Label("Seu produto está sendo preparado, " + nomeUsuario + "!");
        mensagemLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");
        rodapeSuperior.getChildren().add(mensagemLabel);

        ImageView imagemEntrega = new ImageView(new Image(
                "file:C:/Users/matheus.fgs/Desktop/Tela de Login com Interface/Imagens/Entregador/MotoEntregador.png"));
        imagemEntrega.setFitWidth(300);
        imagemEntrega.setFitHeight(300);
        imagemEntrega.setPreserveRatio(true);
        imagemEntrega.setSmooth(true);
        imagemEntrega.setCache(true);

        Button voltarButton = new Button("VOLTAR");
        voltarButton.setStyle("-fx-background-color: white; -fx-text-fill: #2F4F4F; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 5, 0, 2, 2); " +
                "-fx-font-size: 16px; " +
                "-fx-padding: 10 20;");

        // Ação do botão VOLTAR
        voltarButton.setOnAction(e -> {
            TelaPrincipal telaPrincipal = new TelaPrincipal(nomeUsuario);
            try {
                telaPrincipal.start(new Stage());
                primaryStage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // HBox para o rodapé inferior
        HBox rodapeInferior = new HBox(10);
        rodapeInferior.setAlignment(Pos.CENTER);
        rodapeInferior.setPadding(new Insets(10));
        rodapeInferior.setStyle("-fx-background-color: #2F4F4F; -fx-padding: 8;");
        rodapeInferior.getChildren().add(voltarButton);

        root.setTop(rodapeSuperior); // Define o rodapé superior
        root.setCenter(imagemEntrega); // Define a imagem no centro
        root.setBottom(rodapeInferior); // Define o rodapé inferior

        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}