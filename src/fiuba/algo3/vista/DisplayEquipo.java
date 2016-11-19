package src.fiuba.algo3.vista;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.Jugador;

public class DisplayEquipo extends HBox {

	private Jugador jugador;
	private List<Button> botones;
	private static int cantidadBotones = 3;

	public DisplayEquipo(Jugador jugador) {
		super(20);
		this.jugador = jugador;
		this.botones = new ArrayList<Button>();
		this.agregarBotonesVacios();
	}

	/* Actualiza el display con las imágenes de los algoMon que
	 * componene el equipo del jugador.
	 */
	public void actualizar() {
		this.borrarImagenes();

		List<AlgoMon> equipo = this.jugador.getEquipo();

		for(int i = 0; i < equipo.size(); i++) {
			this.botones.get(i).setGraphic(ContenedorImagenes.getImageView(equipo.get(i).getNombre()));
		}

	}

	/* Agrega los botones al display. */
	private void agregarBotonesVacios() {
		for(int i = 0; i < DisplayEquipo.cantidadBotones; i++) {
			Button boton = new Button();

			boton.setMinSize(100f, 80f);
			boton.getStyleClass().add("boton-equipo");
			this.botones.add(boton);
			this.getChildren().add(boton);
		}
	}

	/* Borra las imágenes de los botones. */
	private void borrarImagenes() {
		for(Button boton : this.botones) {
			boton.setGraphic(null);
		}
	}

}
