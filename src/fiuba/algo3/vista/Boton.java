package src.fiuba.algo3.vista;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Boton extends Button {

	private String cssFormat = "-fx-background-image: url('/src/fiuba/algo3/vista/Imagenes/boton1.png');"
			+ "-fx-background-size: 200px;"
			+ "-fx-background-repeat: no-repeat;"
			+ "-fx-background-position: 90%;";

	public Boton(String texto/*, un Handler*/) {

		super(texto);

		this.setMinSize(200, 58);
		this.setFont(Font.font(20));
		this.setTextFill(Color.WHITE);
		this.setStyle(cssFormat);

	}

}
