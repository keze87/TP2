package src.fiuba.algo3.vista;

import java.io.File;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.fiuba.algo3.modelo.Juego;

public class IntroduccionParte2 extends EscenaJuegoAlgoMon {

	public IntroduccionParte2(Stage stage, Juego juego) {

		super(stage, juego);

	}

	@Override
	protected void agregarElementos() {

		StackPane layoutConImagenColor = new StackPane();
		BorderPane layout = new BorderPane();
		String rutaSonido = "src/fiuba/algo3/vista/Sonidos/";

		Pane color = new Pane();
		color.getStyleClass().add("intro2");

		this.setFill(Color.BLACK);
		this.setRoot(layoutConImagenColor);

		ImageView rattata = new ImageView(ruta + "RattataMR.png");
		HBox rattataBox = new HBox(rattata);
		rattataBox.setPadding(new Insets(20));
		rattataBox.setAlignment(Pos.CENTER);
		rattata.setFitHeight(400);
		rattata.setFitWidth(400);
		rattata.setPreserveRatio(true);

		FadeTransition desvanecer = Animaciones.animacionDesvanecer(layoutConImagenColor);
		FadeTransition aparecer = Animaciones.animacionAparecer(layoutConImagenColor);

		Media archivo = new Media(new File(rutaSonido + "RattataMR.mp3").toURI().toString());
		MediaPlayer rattataSound = new MediaPlayer(archivo);

		aparecer.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						rattataSound.setOnEndOfMedia(
								new Runnable() {

									@Override
									public void run() {

										desvanecer.play();

									}
								}
								);

						rattataSound.play();

					}
				}
				);

		desvanecer.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						stage.setScene(new MenuPrincipal(stage, new Juego()));

					}

				}
				);

		aparecer.play();
		layout.setCenter(rattataBox);

		Timeline timeline = new Timeline(new KeyFrame(
				Duration.millis(250),
				ae -> layoutConImagenColor.getChildren().addAll(color, layout)));

		timeline.play();

	}

}
