package Model;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class DadoAzul extends Group {
	
	private Rotate rotateX;
	private Rotate rotateY;
	private final SimpleDoubleProperty offSetX;
	private final SimpleDoubleProperty offSetY;
	private Scene scene;
	
	
	public DadoAzul(Scene scene) {
		
		Box frente   = new Box(100, 100, 1);
    	Box tras     = new Box(100, 100, 1);

    	Box esquerda = new Box(1, 100, 100);
    	Box direita  = new Box(1, 100, 100);

    	Box topo     = new Box(100, 1, 100);
    	Box baixo    = new Box(100, 1, 100);
    	
    	frente.setTranslateZ(-50);
    	tras.setTranslateZ(50);
    	
    	esquerda.setTranslateX(-50);
    	direita.setTranslateX(50);
    	
    	topo.setTranslateY(50);
    	baixo.setTranslateY(-50);
    	
    	PhongMaterial m1 = new PhongMaterial();
    	m1.setDiffuseMap(
    	    new Image(getClass().getResourceAsStream("/Imagens/DadoAzul1.png"))
    	);


    	PhongMaterial m2 = new PhongMaterial();
    	m2.setDiffuseMap(
    	    new Image(getClass().getResourceAsStream("/Imagens/DadoAzul2.png"))
    	);


    	PhongMaterial m3 = new PhongMaterial();
    	m3.setDiffuseMap(
    	    new Image(getClass().getResourceAsStream("/Imagens/DadoAzul3.png"))
    	);


    	PhongMaterial m4 = new PhongMaterial();
    	m4.setDiffuseMap(
    	    new Image(getClass().getResourceAsStream("/Imagens/DadoAzul4.png"))
    	);


    	PhongMaterial m5 = new PhongMaterial();
    	m5.setDiffuseMap(
    	    new Image(getClass().getResourceAsStream("/Imagens/DadoAzul5.png"))
    	);


    	PhongMaterial m6 = new PhongMaterial();
    	m6.setDiffuseMap(
    	    new Image(getClass().getResourceAsStream("/Imagens/DadoAzul6.png"))
    	);
    	
    	
    	frente.setMaterial(m1);   // Face 1
    	tras.setMaterial(m6);     // Face 6

    	esquerda.setMaterial(m2); // Face 2
    	direita.setMaterial(m5);  // Face 5

    	topo.setMaterial(m3);     // Face 3
    	baixo.setMaterial(m4);    // Face 4

    	
    	getChildren().addAll(

    		    frente,

    		    tras,

    		    esquerda,

    		    direita,

    		    topo,

    		    baixo

    		);
    	
    	this.rotateX = new Rotate(0, Rotate.X_AXIS);
    	this.rotateY = new Rotate(0, Rotate.Y_AXIS);
    	
    	getTransforms().addAll(rotateX, rotateY);
    	
    	esconderDado();
    	
    	this.offSetX = new SimpleDoubleProperty();
    	this.offSetY = new SimpleDoubleProperty();
    	
    	this.scene = scene;
		
	}
	
	public SimpleDoubleProperty offSetXProperty() {
		return offSetX;
	}
	
	public SimpleDoubleProperty offSetYProperty() {
		return offSetY;
	}
	
	private double comecoDadoX() {
		offSetX.set(0);
		return offSetX.get();
	}
	
	private double comecoDadoY() {
		offSetY.set(0);
		return offSetY.get();
	}
	
	private double finalDadoX() {
		offSetX.set(scene.getWidth());
		return offSetX.get();
	}
	
	private double finalDadoY() {
		offSetY.set(scene.getHeight());
		return offSetY.get();
	}
	
	
	public int rolarDado() {
		
		int resultado = new Random().nextInt(1, 7);
		
		int finalX = 0;
		
		int finalY = 0;
		
		
		switch(resultado) {
		
			case 1:

				finalX = 0;

				finalY = 0;
				
				animacao(finalX, finalY, resultado);

				break;

			case 2:
				
				finalX = 0;

				finalY = -90;
				
				animacao(finalX, finalY, resultado);

				break;

			case 3:

				finalX = -90;

				finalY = 0;
				
				animacao(finalX, finalY, resultado);

				break;

			case 4:

				finalX = 90;
            
				finalY = 0;
				
				animacao(finalX, finalY, resultado);

				break;

			case 5:

				finalX = 0;

				finalY = 90;
				
				animacao(finalX, finalY, resultado);

				break;

			case 6:

				finalX = 180;

				finalY = 0;
				
				animacao(finalX, finalY, resultado);

				break;
		}
		
		
		return resultado;
		
		
	}
	
	private void animacao(int finalX, int finalY, int resultado) {
		
		mostraDado();
		
		Timeline animacao = new Timeline(

				new KeyFrame(

	                Duration.ZERO,

	                new KeyValue(rotateX.angleProperty(), 0),

	                new KeyValue(rotateY.angleProperty(), 0),
	                
	                new KeyValue(offSetX, comecoDadoX()),
	                
	                new KeyValue(offSetY, comecoDadoY())

	                //new KeyValue(translateXProperty(), -200),

	               // new KeyValue(translateYProperty(), 900)
	                
	            ),

	            new KeyFrame(

	                Duration.seconds(3),

	                new KeyValue(rotateX.angleProperty(),1080 + finalX),

	                new KeyValue(rotateY.angleProperty(),720 + finalY),
	                
	                new KeyValue(offSetX, finalDadoX()),
	                
	                new KeyValue(offSetY, finalDadoY())

	               // new KeyValue(translateXProperty(), 450),

	               // new KeyValue(translateYProperty(), 350)

	            )

	        );

	        
	        animacao.setOnFinished(e -> {

	        	

	        });

	        animacao.play();
	}
	
	public void mostraDado() {
		
		setVisible(true);
		System.out.println(scene.getWidth());
	}
	
	public void esconderDado() {
		
		setVisible(false);
	}

}
