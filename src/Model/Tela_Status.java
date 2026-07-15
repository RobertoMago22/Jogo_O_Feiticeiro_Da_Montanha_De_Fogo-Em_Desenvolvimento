package Model;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Tela_Status extends VBox {
	
	private Label nome;
	private ProgressBar barra;
	private Label vida;
	private Label moeda;
	
	
	public Tela_Status(Heroi heroi) {
		
		this.nome = new Label();
		this.barra = new ProgressBar();
		this.vida = new Label();
		this.moeda = new Label();
		
		StackPane barraVida = new StackPane();
		barraVida.getChildren().addAll(barra, vida);
		
		setSpacing(10);
		setPadding(new Insets(30));
		setAlignment(Pos.CENTER);
		getChildren().addAll(nome, barraVida, moeda);
		
		nome.textProperty().bind(heroi.nomeProperty());
		
		barra.progressProperty().bind(heroi.vidaAtualProperty().divide(heroi.vidaMaxProperty()));
		
		vida.textProperty().bind(Bindings.createStringBinding(() -> {
			return String.format("%.0f / %.0f", heroi.getVidaAtual(), 
					heroi.getVidaMax());
		}, heroi.vidaAtualProperty(), heroi.vidaMaxProperty()));
		
		moeda.textProperty().bind(Bindings.createStringBinding(() -> {
			return String.format("Moeda: %d", heroi.getMoeda());
		}, heroi.moedaProperty()));
		
		
		nome.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
		barra.setStyle("-fx-accent: green;");
		vida.setStyle("-fx-font-weight: bold; -fx-text-fill: black;");
		moeda.setStyle("-fx-text-fill: gold; -fx-font-weight: bold;");
		
	}
	
	public void vida60() {
		
		barra.setStyle("-fx-accent: green;");
	}
	
	public void vida30() {
		
		barra.setStyle("-fx-accent: yellow;");
	}
	
	public void vida() {
		
		barra.setStyle("-fx-accent: red;");
	}
	
	
	

}
