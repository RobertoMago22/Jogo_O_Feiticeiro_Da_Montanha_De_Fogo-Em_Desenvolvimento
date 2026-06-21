package teste;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.AmbientLight;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Dado3D extends Application {



    private Rotate rotateX = new Rotate(0, Rotate.X_AXIS);

    private Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);

    private Button btn = new Button("Rolar Dado");

    private Group dado;



    @Override

    public void start(Stage stage) {



        dado = criarDado();

        

        dado.setDepthTest(DepthTest.ENABLE);

        

        dado.setTranslateX(-200);

        dado.setTranslateY(900);



        dado.getTransforms().addAll(rotateX, rotateY);



        Group root = new Group(dado);

        

        root.setDepthTest(DepthTest.ENABLE);

        

        AmbientLight ambient = new AmbientLight(Color.WHITE);



        PointLight light = new PointLight(Color.WHITE);

        light.setTranslateX(-200);

        light.setTranslateY(-200);

        light.setTranslateZ(-200);

        

        btn.setLayoutX(20);

        btn.setLayoutY(20);

        

        btn.setOnAction(e -> {

        	

        	btn.setDisable(true);

        	

        	rolarDado();

        });



        root.getChildren().addAll(ambient, light, btn);



        PerspectiveCamera camera = new PerspectiveCamera(false);

        camera.setTranslateZ(-500);



        Scene scene = new Scene(root, 900, 700, true);

        scene.setFill(Color.DARKGREEN);

        scene.setCamera(camera);



        stage.setScene(scene);

        stage.setTitle("Dado 3D");

        stage.show();



        rolarDado();

    }

    

    private Group criarDado() {

    	
    	Group dado = new Group();

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

    	    new Image(getClass().getResourceAsStream("/Imagens/DadoVermelho1.png"))

    	);



    	PhongMaterial m2 = new PhongMaterial();

    	m2.setDiffuseMap(

    	    new Image(getClass().getResourceAsStream("/Imagens/DadoVermelho2.png"))

    	);



    	PhongMaterial m3 = new PhongMaterial();

    	m3.setDiffuseMap(

    	    new Image(getClass().getResourceAsStream("/Imagens/DadoVermelho3.png"))

    	);



    	PhongMaterial m4 = new PhongMaterial();

    	m4.setDiffuseMap(

    	    new Image(getClass().getResourceAsStream("/Imagens/DadoVermelho4.png"))

    	);



    	PhongMaterial m5 = new PhongMaterial();

    	m5.setDiffuseMap(

    	    new Image(getClass().getResourceAsStream("/Imagens/DadoVermelho5.png"))

    	);



    	PhongMaterial m6 = new PhongMaterial();

    	m6.setDiffuseMap(

    	    new Image(getClass().getResourceAsStream("/Imagens/DadoVermelho6.png"))

    	);

    	

    	

    	frente.setMaterial(m1);   // Face 1

    	tras.setMaterial(m6);     // Face 6



    	esquerda.setMaterial(m2); // Face 2

    	direita.setMaterial(m5);  // Face 5



    	topo.setMaterial(m3);     // Face 3

    	baixo.setMaterial(m4);    // Face 4

    	

    	dado.getChildren().addAll(

    		    frente,

    		    tras,

    		    esquerda,

    		    direita,

    		    topo,

    		    baixo

    		);

    	

    	return dado;

    }



    private void rolarDado() {



        int resultado = new Random().nextInt(1 , 7);



        int finalX = 0;

        int finalY = 0;



        switch (resultado) {



            case 1:

                finalX = 0;

                finalY = 0;

                break;



            case 2:

                finalX = 0;

                finalY = -90;

                break;



            case 3:

                finalX = -90;

                finalY = 0;

                break;



            case 4:

                finalX = 90;

                finalY = 0;

                break;



            case 5:

                finalX = 0;

                finalY = 90;

                break;



            case 6:

                finalX = 180;

                finalY = 0;

                break;

        }



        Timeline animacao = new Timeline(



            new KeyFrame(

                Duration.ZERO,

                new KeyValue(rotateX.angleProperty(), 0),

                new KeyValue(rotateY.angleProperty(), 0),

                new KeyValue(dado.translateXProperty(), -200),

                new KeyValue(dado.translateYProperty(), 900)

            ),



            new KeyFrame(

                Duration.seconds(3),



                new KeyValue(rotateX.angleProperty(),1080 + finalX),

                new KeyValue(rotateY.angleProperty(),720 + finalY),

                new KeyValue(dado.translateXProperty(), 450),

                new KeyValue(dado.translateYProperty(), 350)

            )

        );

        



        animacao.setOnFinished(e -> {

        	

        System.out.println("Resultado: " + resultado);

            

            btn.setDisable(false);

           

        });



        animacao.play();

        

    }



    public static void main(String[] args) {

        launch(args);

    }

}