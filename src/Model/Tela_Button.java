package Model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Tela_Button extends VBox {
	
	private Button botao1;
	private Button botao2;
	private Button botao3;
	private Button botao4;
	
	public Tela_Button() {
		
		this.botao1 = new Button();
		this.botao2 = new Button();
		this.botao3 = new Button();
		this.botao4 = new Button();
		
		setSpacing(10);
		setPadding(new Insets(10));
		setAlignment(Pos.CENTER);
		
		botao1.setStyle(
			    "-fx-background-color: #8B0000;" +     //#8B0000
			    "-fx-text-fill: white;" +   // #FFD700
			    "-fx-font-size: 16px;" +
			    "-fx-font-weight: bold;");
		
		botao2.setStyle(
			    "-fx-background-color: maroon;" +
			    "-fx-text-fill: white;" +
			    "-fx-font-size: 16px;" +
			    "-fx-font-weight: bold;");
		
		botao3.setStyle(
			    "-fx-background-color: #2ecc71;" +
			    "-fx-text-fill: white;" +
			    "-fx-font-size: 16px;" +
			    "-fx-font-weight: bold;");
		
		botao4.setStyle(
			    "-fx-background-color: #2ecc71;" +
			    "-fx-text-fill: white;" +
			    "-fx-font-size: 16px;" +
			    "-fx-font-weight: bold;");
		
		
		
	}
	
	public Button getBotao1() {
		return botao1;
	}
	
	public Button getBotao2() {
		return botao2;
	}
	
	public Button getBotao3() {
		return botao3;
	}
	
	public Button getBotao4() {
		return botao4;
	}
	
	public void adicionarButton(int numero) {
		
		switch(numero) {
		
			case 1:
				getChildren().addAll(botao1, botao2);
				/*add(botao1, 0, 0);
				add(botao2, 0, 1);*/
				break;
		}
		
	}
	
	public void excluirButton() {
		
		getChildren().clear();
		
	}
	
	public void adicionarTexto(String ... nome) {
		
		for(int i = 1; i <= nome.length; i++) {
			
			switch(i) {
			
				case 1:
					botao1.setText(nome[0]);
					break;
					
				case 2:
					botao2.setText(nome[1]);
					break;
					
				case 3:
					botao3.setText(nome[2]);
					break;
					
				case 4:
					botao4.setText(nome[3]);
					break;
			}
			
		}
		
	}
	
	
	

}
