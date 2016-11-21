package src.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.Jugador;
import src.fiuba.algo3.modelo.excepciones.EquipoCompleto;

public class BotonElegirAlgoMon extends BotonAlgoMon {

	private Jugador jugador;
	private DisplayEquipo display;

	public BotonElegirAlgoMon(AlgoMon algoMon, Jugador jugador, DisplayEquipo display) {
		super(algoMon);
		this.algoMon = algoMon;
		this.jugador = jugador;
		this.display = display;
		this.agregarContenido();
		this.establecerAccion();
	}

	@Override
	protected void agregarContenido() {
		super.agregarContenido();
		this.setMinWidth(180f);
		this.setMinHeight(100f);
	}

	@Override
	protected void agregarTexto() {
		this.setText(this.algoMon.getNombre() + "\n" + (int) this.algoMon.getVidaMaxima() + " HP");
	}

	/* Establece la acción a realizar cuando se hace click sobre el botón. */
	private void establecerAccion() {
		this.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Sonido.play("BotonPresionado");

				if(jugador.tieneAlgoMonEnEquipo(algoMon)) {
					jugador.sacarAlgoMonDelEquipo(algoMon);
					Consola.mostrarMensaje(algoMon.getNombre() + " fue removido del equipo.");
				}

				else {
					try {
						jugador.agregarAlgoMonAlEquipo(algoMon);
						Consola.mostrarMensaje(algoMon.getNombre() + " fue agregado al equipo.");
					} catch (EquipoCompleto e) {
						Consola.mostrarMensaje("No se puede agregar a " + algoMon.getNombre() + ". " + e.getMessage());
					}
				}

				display.actualizar();
			}

		});
	}
}
