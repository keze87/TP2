package src.fiuba.algo3.vista;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class Boton extends Button {

	public Boton(String texto/*, un Handler*/) {

		super(texto);

		this.setMinSize(200, 10);
		this.setFont(Font.font(20));

		//this.setStyle("-fx-background-image: url('/algunaImagenDeUnBoton')");

	}

}
