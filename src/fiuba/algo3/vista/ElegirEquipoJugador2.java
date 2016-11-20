package src.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.Juego;

public class ElegirEquipoJugador2 extends ElegirEquipo {

	public ElegirEquipoJugador2(Stage stage, Juego juego) {
		super(stage, juego);
		Consola.mostrarMensaje("Jugador 2: elije 3 algoMon.");
	}

	@Override
	protected void agregarElementos() {
		this.jugador = this.juego.getJugador2();
		super.agregarElementos();
	}

	@Override
	protected void setAccionFinalizarSeleccion() {
		this.finalizarSeleccion.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Sonido.getSeek("click.mp3").play();
				if(!jugador.equipoEstaCompleto()) {
					Consola.mostrarMensaje("El equipo no está completo!");
				}

				else {
					jugador.listoParaPelear();
					Sonido.getSeek("Pokemon_Battle.mp3").play();;
					stage.setScene(new EscenaBatalla(stage, juego));
				}
			}

		});
	}

}
