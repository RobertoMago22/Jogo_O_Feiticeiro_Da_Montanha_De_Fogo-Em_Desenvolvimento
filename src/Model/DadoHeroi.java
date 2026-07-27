package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;

public class DadoHeroi extends SubScene {
	
	
	public DadoHeroi(DadoAzul dado, Scene scene) {
		
		super(dado, scene.getWidth(), scene.getHeight(), true, SceneAntialiasing.BALANCED);
		setFill(Color.TRANSPARENT);
        setMouseTransparent(true);
        
        this.widthProperty().bind(scene.widthProperty());
		this.heightProperty().bind(scene.heightProperty());
        
        SimpleDoubleProperty telaX = new SimpleDoubleProperty();
        SimpleDoubleProperty telaY = new SimpleDoubleProperty();
        
        telaX.bind(scene.widthProperty());
        telaY.bind(scene.heightProperty());
        
        dado.translateXProperty().bind(telaX.add(dado.offSetXProperty()));
        dado.translateYProperty().bind(telaY.add(dado.offSetYProperty()));
       
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.translateXProperty().bind(telaX.multiply(2));
        camera.translateYProperty().bind(telaY.multiply(2));
        camera.setTranslateZ(-800);
        camera.setFieldOfView(70);
        camera.setNearClip(0.1);
        camera.setFarClip(2000);

        setCamera(camera);
	}
	
	
}
