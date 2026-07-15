package View;

import Controller.Controller_Heroi;
import Controller.Controller_Tela;
import Model.Item;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tela_Jogo extends Application {
	
	private Controller_Heroi controllerHeroi;
	private Controller_Tela controllerTela;
	
	@Override

	public void start(Stage stage) {
		
		controllerHeroi = new Controller_Heroi();
		controllerHeroi.criarHeroi("Henry", 100, 25);
		
		controllerTela = new Controller_Tela(controllerHeroi.getHeroi());

		StackPane janela = new StackPane();
		janela.setStyle("-fx-background-color: black;");

		GridPane telaC = new GridPane();
		// Começo Tela Esquerda GridPane(0, 0)
		
		
		telaC.add(controllerTela.getStatus(), 0, 0);
		
		// Fim da Tela Esquerda GridPane(0, 0)
		
		// Começo da Tela Esquerda GridPane(0, 1)
		
		VBox telaEsquerdaBaixo = new VBox(10);
		
		telaEsquerdaBaixo.setAlignment(Pos.CENTER);
		
		TableView<Item> inventario = new TableView<>();
		//Continuar
		Button usar = new Button("Usar");
		
		
		
		
		telaEsquerdaBaixo.getChildren().addAll(usar, inventario);
		
		TableColumn<Item, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		
		TableColumn<Item, Integer> colUnidade = new TableColumn<>("Quant.");
		colUnidade.setCellValueFactory(cellData -> cellData.getValue().unidadeProperty().asObject());
		
		inventario.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
		
		inventario.getColumns().addAll(colNome, colUnidade);
		
		inventario.setItems(controllerHeroi.getInventario());
		
		
		telaC.add(telaEsquerdaBaixo, 0, 1);
		
		janela.getChildren().add(telaC);

		Scene scene = new Scene(janela, 600, 600);

		stage.setScene(scene);

		stage.setTitle("Teste");

		stage.show();

	}

	public static void main(String[] args) {

		launch(args);

	}

}
