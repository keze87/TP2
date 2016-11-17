package src.fiuba.algo3.vista;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.fiuba.algo3.modelo.Juego;

public class IntroduccionParte2 extends EscenaJuegoAlgoMon {

	public IntroduccionParte2(Stage stage, Juego juego) {

		super(stage, "", juego);

	}

	@Override
	protected void agregarElementos() {

		StackPane layoutConImagenNegra = new StackPane();
		BorderPane layout = new BorderPane();

		this.setFill(Color.web("e5a001"));
		this.setRoot(layoutConImagenNegra);

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

						desvanecer.play();

					}
				}
				);

		desvanecer.setDelay(Duration.seconds(4));
		desvanecer.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						stage.setScene(new MenuPrincipal(stage, new Juego()));

					}

				}
				);

		aparecer.play();

		layoutConImagenNegra.getChildren().addAll(layout, negro);

	}

}
