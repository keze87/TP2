package src.fiuba.algo3.vista;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Animaciones {

	public static FadeTransition animacionAparecer(Node layout) {

		FadeTransition aparecer = new FadeTransition(Duration.millis(3000), layout);

		aparecer.setFromValue(0);
		aparecer.setToValue(1);
		aparecer.setCycleCount(1);
		aparecer.setAutoReverse(false);

		return aparecer;

	}

	public static FadeTransition animacionDesvanecer(Node layout) {

		FadeTransition desvanecer = new FadeTransition(Duration.millis(2000), layout);

		desvanecer.setFromValue(1);
		desvanecer.setToValue(0);
		desvanecer.setCycleCount(1);
		desvanecer.setAutoReverse(false);

		return desvanecer;

	}

}
