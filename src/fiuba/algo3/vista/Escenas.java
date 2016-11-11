package src.fiuba.algo3.vista;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Escenas {

	private static String ruta = "file:src/fiuba/algo3/vista/Imagenes/";

	public static void Introduccion(Stage primaryStage) {

		StackPane layout = new StackPane();
		HBox fila = new HBox();
		Image algomonImagen;
		ImageView algomon;
		ImageView question = new ImageView(ruta + "Question.png");
		ImageView yup = new ImageView(ruta + "Yup.png");
		ImageView nope = new ImageView(ruta + "Nope.png");
		FadeTransition aparecer = new FadeTransition(Duration.millis(3000), layout);
		FadeTransition desvanecer = new FadeTransition(Duration.millis(2000), layout);

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

		aparecer.setFromValue(0); aparecer.setToValue(1); aparecer.setCycleCount(1); aparecer.setAutoReverse(false);
		aparecer.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						layout.getChildren().add(nope);

						desvanecer.play();

					}
				}
				);

		aparecer.play();

		desvanecer.setFromValue(1);
		desvanecer.setToValue(0);
		desvanecer.setCycleCount(1);
		desvanecer.setAutoReverse(false);
		desvanecer.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						algomon.setImage(new Image(ruta + "Gengar.gif"));
						fila.getChildren().clear();
						fila.getChildren().addAll(algomon, question);
						layout.getChildren().clear();
						layout.getChildren().add(fila);

						aparecer.setOnFinished(
								new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent event) {

										layout.getChildren().add(nope);

										desvanecer.setOnFinished(
												new EventHandler<ActionEvent>() {

													@Override
													public void handle(ActionEvent event) {

														algomon.setImage(new Image(ruta + "Rattata.gif"));
														fila.getChildren().clear();
														fila.getChildren().addAll(algomon, question, yup);
														layout.getChildren().clear();
														layout.getChildren().add(fila);

														aparecer.setOnFinished(
																new EventHandler<ActionEvent>() {

																	@Override
																	public void handle(ActionEvent event) {

																		yup.setOpacity(100);

																		desvanecer.setDelay(Duration.millis(1000));
																		desvanecer.setOnFinished(
																				new EventHandler<ActionEvent>() {

																					@Override
																					public void handle(ActionEvent event) {

																						Escenas.IntroduccionParte2(primaryStage);

																					}
																				}
																				);
																		desvanecer.play();

																	}
																}
																);
														aparecer.play();
													}
												}
												);

										desvanecer.play();

									}
								}
								);

						aparecer.play();

					}
				}
				);

		fila.getChildren().addAll(algomon, question);

		layout.getChildren().add(fila);

		Scene intro = new Scene(layout, 1024, 768, Color.BLACK);

		intro.setOnKeyPressed(
				new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent event) {

						Escenas.MenuPrincipal(primaryStage); // Al presionar tecla, avanza

					}
				}
				);

		primaryStage.setScene(intro);
		primaryStage.show();

	}

	protected static void IntroduccionParte2(Stage primaryStage) {

		StackPane layoutConImagenNegra = new StackPane();
		BorderPane layout = new BorderPane();
		Scene intro2 = new Scene(layoutConImagenNegra, 1024, 768, Color.web("e5a001"));

		ImageView rattata = new ImageView(ruta + "RattataMR.png");
		HBox rattataBox = new HBox(rattata);
		rattataBox.setPadding(new Insets(20));
		rattataBox.setAlignment(Pos.CENTER);
		rattata.setFitHeight(400);
		rattata.setFitWidth(400);
		rattata.setPreserveRatio(true);

		ImageView negro = new ImageView(new Image(ruta + "Negro.png"));
		FadeTransition desvanecer = new FadeTransition(Duration.millis(3000), negro);
		FadeTransition aparecer = new FadeTransition(Duration.millis(2000), negro);

		negro.setFitWidth(4000);
		negro.setFitHeight(4000);

		desvanecer.setFromValue(0); desvanecer.setToValue(1); desvanecer.setCycleCount(1); desvanecer.setAutoReverse(false);
		aparecer.setFromValue(1); aparecer.setToValue(0); aparecer.setCycleCount(1); aparecer.setAutoReverse(false);

		aparecer.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						layout.setCenter(rattataBox);

						desvanecer.setDelay(Duration.seconds(4));
						desvanecer.setOnFinished(
								new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent event) {

										Escenas.MenuPrincipal(primaryStage);

									}

								}
								);
						desvanecer.play();

					}
				}
				);

		aparecer.play();

		layoutConImagenNegra.getChildren().addAll(layout, negro);

		primaryStage.setScene(intro2);
		primaryStage.show();

	}

	public static void MenuPrincipal(Stage primaryStage) {

		BorderPane layout = new BorderPane();
		BorderPane listaCentral = new BorderPane();
		BarraMenu barraMenu = new BarraMenu();

		// Imagen de fondo
		Image imagenFondo = new Image(ruta + "Fondo.png");
		BackgroundImage fondo = new BackgroundImage(imagenFondo,
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);

		// Lista de botones
		HBox botones = new HBox(20);
		Button unJugador = new Boton("Un jugador");
		Button dosJugadores = new Boton("Dos jugadores");
		Button cheat = new Boton("Cheat Code");
		Button salir = new Boton("Salir");
		botones.setPadding(new Insets(40));
		botones.setAlignment(Pos.CENTER);

		//al pulsar en salir sale del juego
		salirDelJuego(salir);

		//Logo
		Image imagenLogo = new Image(ruta +"Logo.png");
		ImageView logoView = new ImageView(imagenLogo);
		HBox logo = new HBox(logoView);
		logo.setPadding(new Insets(20));
		logo.setAlignment(Pos.CENTER);

		FadeTransition ft = new FadeTransition(Duration.millis(3000), logo);
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		ft.play();
		ft.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						botones.getChildren().addAll(unJugador, dosJugadores, cheat, salir);
						primaryStage.show();
					}
				}
				);

		listaCentral.setTop(logo);
		listaCentral.setBottom(botones);
		layout.setCenter(listaCentral);
		layout.setTop(barraMenu);
		layout.setBackground(new Background(fondo));

		primaryStage.setScene(new Scene(layout, 1024, 768));
		primaryStage.show();

	}

	private static void salirDelJuego(Button salir) {
		salir.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.exit(0);
			}

		});

	}

}
