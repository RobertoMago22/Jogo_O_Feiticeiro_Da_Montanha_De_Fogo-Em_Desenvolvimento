package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Tela_Imagem extends Pane{
	
	private ImageView imagem;
	
	public Tela_Imagem() {
		
		this.imagem = new ImageView();
		
		this.getChildren().add(imagem);
		
		imagem.fitHeightProperty().bind(this.heightProperty());
		imagem.fitWidthProperty().bind(this.widthProperty());
		
	}
	
	public ImageView getImagem() {
		
		return imagem;
	}
	
	public void mudarImagem(String texto) {
		
		imagem.setImage(new Image(getClass().getResource(texto).toExternalForm()));
		
	}
	
	

}
