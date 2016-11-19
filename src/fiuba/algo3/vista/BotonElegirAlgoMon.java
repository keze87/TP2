package src.fiuba.algo3.vista;

import java.lang.reflect.Method;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.Jugador;
import src.fiuba.algo3.modelo.excepciones.AlgoMonNoExiste;
import src.fiuba.algo3.modelo.excepciones.EquipoCompleto;

public class BotonElegirAlgoMon extends Button {

	private AlgoMon algoMon;
	private Jugador jugador;
	private DisplayEquipo display;

	public BotonElegirAlgoMon(String nombreAlgoMon, Jugador jugador, DisplayEquipo display) {
		this.algoMon = this.crearAlgoMon(nombreAlgoMon);
		this.jugador = jugador;
		this.display = display;
		this.agregarContenido();
		this.establecerAccion();
		this.getStyleClass().add("boton-elegir-algoMon");
	}

	/* Crea y devuelve un algoMon a partir de su nombre. Si el algoMon no existe lanza una
	 * excepción.
	 */
	private AlgoMon crearAlgoMon(String nombreAlgoMon) {
		try {
			Method metodo = AlgoMonBuilder.class.getMethod("crear" + nombreAlgoMon);

			return (AlgoMon) metodo.invoke(null);
		} catch(Exception e) {
			throw new AlgoMonNoExiste(nombreAlgoMon + " no existe!");
		}
	}

	/* Agrega el contenido del botón. */
	private void agregarContenido() {
		this.setPadding(new Insets(20f));
		this.setMinWidth(180f);
		this.setMinHeight(100f);
		this.setText(this.algoMon.getNombre() + "\n" + (int) this.algoMon.getVidaMaxima() + " HP");
		this.setGraphic(ContenedorImagenes.getImageView(this.algoMon.getNombre()));
	}

	/* Establece la acción a realizar cuando se hace click sobre el botón. */
	private void establecerAccion() {
		this.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

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
