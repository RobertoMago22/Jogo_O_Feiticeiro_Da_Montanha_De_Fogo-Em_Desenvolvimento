package Model;

import javafx.geometry.Pos;
import javafx.scene.control.TextArea;

public class Tela_Texto extends TextArea{
	
	public Tela_Texto() {
		
		setEditable(false);
		setWrapText(true);
		setFocusTraversable(false);
		setPrefRowCount(10);
		setStyle("-fx-control-inner-background: #2b2b2b;"
				+ "-fx-text-fill: #e0e0e0;"
				+ "-fx-font-family: 'Georgia';"
				+ "-fx-font-size: 14px;"
				+ "-fx-background-insets: 0;"
				+ "-fx-background-radius: 5;");
	}
	
	public void trocarTexto(String texto) {
		
		setText(texto);
		
	}

}
