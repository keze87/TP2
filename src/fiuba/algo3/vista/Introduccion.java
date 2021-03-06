package src.fiuba.algo3.vista;

import java.io.File;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.fiuba.algo3.modelo.Juego;

public class Introduccion extends EscenaJuegoAlgoMon {

	public Introduccion(Stage stage, Juego juego) {

		super(stage, juego);

	}

	@Override
	protected void agregarElementos() {

		StackPane layout = new StackPane();
		HBox fila = new HBox();
		Image algomonImagen;
		ImageView algomon;
		ImageView question = new ImageView(ruta + "Question.png");
		ImageView yup = new ImageView(ruta + "Yup.png");
		ImageView nope = new ImageView(ruta + "Nope.png");
		Media archivo;

		fila.setAlignment(Pos.CENTER);

		algomonImagen = new Image(ruta + "Pikachu.gif");

		algomon = new ImageView(algomonImagen);
		algomon.setFitHeight(algomonImagen.getHeight() * 1.5);
		algomon.setFitWidth(algomonImagen.getWidth() * 1.5);
		algomon.setPreserveRatio(true);

		yup.setFitHeight(algomonImagen.getHeight());
		yup.setFitWidth(algomonImagen.getWidth());
		yup.setPreserveRatio(true);
		yup.setOpacity(0);

		question.setFitHeight(algomon.getFitHeight());
		question.setFitWidth(algomon.getFitWidth());
		question.setPreserveRatio(true);

		FadeTransition aparecerPikachuYAlFinalAgregarCruz = Animaciones.animacionAparecer(layout);
		FadeTransition desvanecerYAgregarGengar = Animaciones.animacionDesvanecer(layout);

		FadeTransition aparecerYAlFinalAgregarCruzYCambiarARattata = Animaciones.animacionAparecer(layout);
		FadeTransition desvanecerYAgregarRattata = Animaciones.animacionDesvanecer(layout);

		FadeTransition aparecerYAlFinalAgregarTick = Animaciones.animacionAparecer(layout);
		FadeTransition desvanecerYCambiarAParte2 = Animaciones.animacionDesvanecer(layout);

		MediaPlayer wrong = Sonido.get("Wrong.mp3");

		archivo = new Media(new File(Sonido.rutaSonido + "Pikachu.mp3").toURI().toString());
		MediaPlayer pikachu = new MediaPlayer(archivo);

		aparecerPikachuYAlFinalAgregarCruz.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						pikachu.setOnEndOfMedia(
								new Runnable() {

									@Override
									public void run() {

										layout.getChildren().add(nope);

										wrong.play();

										desvanecerYAgregarGengar.play();

									}
								}
								);

						pikachu.play();

					}
				}
				);

		desvanecerYAgregarGengar.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						algomon.setImage(new Image(ruta + "Gengar.gif"));
						fila.getChildren().clear();
						fila.getChildren().addAll(algomon, question);
						layout.getChildren().clear();
						layout.getChildren().add(fila);

						aparecerYAlFinalAgregarCruzYCambiarARattata.play();

					}

				}
				);

		archivo = new Media(new File(Sonido.rutaSonido + "Gengar.mp3").toURI().toString());
		MediaPlayer gengar = new MediaPlayer(archivo);

		aparecerYAlFinalAgregarCruzYCambiarARattata.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						gengar.setOnEndOfMedia(
								new Runnable() {

									@Override
									public void run() {

										layout.getChildren().add(nope);

										wrong.seek(Duration.ZERO);
										wrong.play();

										desvanecerYAgregarRattata.play();

									}
								}
								);

						gengar.play();

					}
				}
				);

		desvanecerYAgregarRattata.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						algomon.setImage(new Image(ruta + "Rattata.gif"));
						fila.getChildren().clear();
						fila.getChildren().addAll(algomon, question, yup);
						layout.getChildren().clear();
						layout.getChildren().add(fila);

						aparecerYAlFinalAgregarTick.play();

					}

				}
				);

		archivo = new Media(new File(Sonido.rutaSonido + "Rattata.mp3").toURI().toString());
		MediaPlayer rattata = new MediaPlayer(archivo);

		MediaPlayer tick = new MediaPlayer(new Media(new File(Sonido.rutaSonido + "Tick.mp3").toURI().toString()));

		aparecerYAlFinalAgregarTick.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						rattata.setOnEndOfMedia(
								new Runnable() {

									@Override
									public void run() {

										yup.setOpacity(100);

										tick.play();

										desvanecerYCambiarAParte2.play();

									}
								}
								);

						rattata.play();

					}
				}
				);

		desvanecerYCambiarAParte2.setDelay(Duration.millis(1000));
		desvanecerYCambiarAParte2.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						stage.setScene(new IntroduccionParte2(stage, new Juego()));

					}

				}
				);

		fila.getChildren().addAll(algomon, question);

		layout.getChildren().add(fila);

		this.setFill(Color.BLACK);
		this.setRoot(layout);

		this.setOnKeyPressed(
				new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent event) {

						aparecerPikachuYAlFinalAgregarCruz.stop();
						desvanecerYAgregarGengar.stop();
						aparecerYAlFinalAgregarCruzYCambiarARattata.stop();
						desvanecerYAgregarRattata.stop();
						aparecerYAlFinalAgregarTick.stop();
						desvanecerYCambiarAParte2.stop();

						pikachu.stop();
						gengar.stop();
						rattata.stop();

						stage.setScene(new MenuPrincipal(stage, new Juego())); // Al presionar tecla, avanza

					}
				}
				);

		aparecerPikachuYAlFinalAgregarCruz.play();

	}

}
