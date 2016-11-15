package src.fiuba.algo3.vista;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.Jugador;

public class DisplayEquipo extends HBox {

	private Jugador jugador;
	private List<Button> botones;

	public DisplayEquipo(Jugador jugador) {
		super(20);
		this.jugador = jugador;
		this.botones = new ArrayList<Button>();
		this.agregarBotonesVacios();
	}

	public void actualizar() {
		for(Button boton : this.botones) {
			boton.setGraphic(null);
		}

		List<AlgoMon> equipo = this.jugador.getEquipo();

		for(int i = 0; i < equipo.size(); i++) {
			Image imagenAlgoMon = new Image(EscenaJuegoAlgoMon.ruta + equipo.get(i).getNombre() + ".gif");

			this.botones.get(i).setGraphic(new ImageView(imagenAlgoMon));
		}

	}

	private void agregarBotonesVacios() {
		for(int i = 0; i < 3; i++) {
			Button boton = new Button();

			boton.setMinSize(100f, 80f);
			boton.getStyleClass().add("boton-equipo");
			this.botones.add(boton);
			this.getChildren().add(boton);
		}
	}

}
