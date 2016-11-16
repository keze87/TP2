package src.fiuba.algo3.vista;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.fiuba.algo3.modelo.Juego;

public class Introduccion extends EscenaJuegoAlgoMon {

	public Introduccion(Stage stage, Juego juego) {

		super(stage, "", juego);

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

		desvanecer.setFromValue(1); desvanecer.setToValue(0); desvanecer.setCycleCount(1); desvanecer.setAutoReverse(false);
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

																						stage.setScene(new IntroduccionParte2(stage, new Juego()));

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

		//Scene intro = new Scene(layout, 1024, 768, Color.BLACK);
		this.setFill(Color.BLACK);
		this.setRoot(layout);

		this.setOnKeyPressed(
				new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent event) {

						stage.setScene(new MenuPrincipal(stage, new Juego())); // Al presionar tecla, avanza
						aparecer.stop();
						desvanecer.stop();

					}
				}
				);

	}

}
