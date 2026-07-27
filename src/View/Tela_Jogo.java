package View;

import Controller.Controller_Heroi;
import Controller.Controller_Tela;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Tela_Jogo extends Application {
	
	private Controller_Heroi controllerHeroi;
	private Controller_Tela controllerTela;
	
	@Override

	public void start(Stage stage) {
		
		controllerHeroi = new Controller_Heroi();
		controllerHeroi.criarHeroi("Henry", 100, 25);
		
		//controllerTela = new Controller_Tela(controllerHeroi.getHeroi(), controllerHeroi);

		StackPane janela = new StackPane();
		janela.setStyle("-fx-background-color: black;");
		
		Scene scene = new Scene(janela, 800, 600);
		
		controllerTela = new Controller_Tela(controllerHeroi.getHeroi(), controllerHeroi, scene);
		
		GridPane telaC = new GridPane();
		// Começo Tela Esquerda GridPane(0, 0)
		
		ColumnConstraints c1 = new ColumnConstraints();
		c1.setPercentWidth(25);

		ColumnConstraints c2 = new ColumnConstraints();
		c2.setPercentWidth(50);

		ColumnConstraints c3 = new ColumnConstraints();
		c3.setPercentWidth(25);

		telaC.getColumnConstraints().addAll(c1, c2, c3);
		
		
		
		telaC.add(controllerTela.getStatus(), 0, 0);
		//telaC.setTop(controllerTela.getStatus());
		// Fim da Tela Esquerda GridPane(0, 0)
		
		// Começo da Tela Esquerda GridPane(0, 1)
		
		telaC.add(controllerTela.getInventario(), 0, 1);
		//telaC.setLeft(controllerTela.getInventario());
		// Fim da Tela Esquerda GridPane(0, 1)
		
		telaC.add(controllerTela.getButton(), 2, 1);
		//telaC.setBottom(controllerTela.getButton());
		telaC.add(controllerTela.getTexto(), 2, 0);
		
		//telaC.setRight(controllerTela.getTexto());
		
		telaC.add(controllerTela.getImagem(), 1, 0, 1, 2);
		
		/*ImageView imagem = new ImageView(getClass().getResource("/Imagens/Pagina_1.png").toExternalForm());
		
		//imagem.setFitHeight(400);
		//imagem.setFitWidth(200);
		
		//imagem.setPreserveRatio(true);
		 
		Pane teste = new Pane(imagem);
		
		imagem.fitHeightProperty().bind(teste.heightProperty());
		imagem.fitWidthProperty().bind(teste.widthProperty());
		
		telaC.add(teste, 1, 0, 1, 2);*/
		//telaC.setCenter(imagem);
		
		//telaC.setAlignment(Pos.CENTER);
		
		
		janela.getChildren().addAll(telaC, controllerTela.getDadoHeroi());
		
		//controllerTela.aumentarTela(janela);

		//Scene scene = new Scene(janela, 800, 600);

		stage.setScene(scene);

		stage.setTitle("Teste");

		stage.show();
		

	}

	public static void main(String[] args) {

		launch(args);

	}

}
