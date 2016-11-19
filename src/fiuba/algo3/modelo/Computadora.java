package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.control.Button;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.Jugador;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.vista.BotoneraAcciones;

public class Computadora extends Jugador {

	List<Integer> chancesAtaque;

	private enum Accion {
		ATACAR, MOCHILA;
	}

	public Computadora() {

		super();

		this.capacidadEquipo = 1;

		this.agregarAlgoMonAlEquipo(AlgoMonBuilder.crearGengar());

	}

	private void crearArrayAtaque() {

		chancesAtaque = new ArrayList<>();

		List<NombreAtaque> nombresAtaques = this.getAlgoMonActivo().getNombresAtaques();

		int chancePorAtaque = Math.round(100 / nombresAtaques.size());

		for (int numeroAtaque = 0; numeroAtaque < nombresAtaques.size(); numeroAtaque++) {

			for (int i = 0; i < chancePorAtaque; i++) {

				chancesAtaque.add(numeroAtaque);

			}

		}

		while (chancesAtaque.size() < 100) {

			chancesAtaque.add(0);

		}

	}

	@Override
	public boolean esComputadora() {

		return true;

	}

	@Override
	public void jugar(Button botonAtacar, Button botonMochila) {

		Accion accion = this.elegirAccion();

		if (accion == Accion.ATACAR) {

			botonAtacar.fire(); //elijo atacar

		} else {

			botonMochila.fire(); //elijo usar elemento

		}

	}

	private Accion elegirAccion() {

		if (this.getAlgoMonActivo().getEstado().puedeRealizarAccion()) {

			List<Accion> array = new ArrayList<>();

			AlgoMon algoMon = this.getAlgoMonActivo();

			double porcentajeVidaAlgomon = (algoMon.getVida() * 100) / algoMon.getVidaMaxima();

			int chancesMochila = (int) Math.round(1000 / porcentajeVidaAlgomon);

			for (int i = 0; i < chancesMochila; i++) {

				array.add(Accion.MOCHILA);

			}

			while (array.size() < 100) {

				array.add(Accion.ATACAR);

			}

			Random random = new Random();

			return array.get(random.nextInt(100));

		} else {

			return Accion.MOCHILA;

		}

	}

	@Override
	public void elegirAtaque(BotoneraAcciones botoneraAcciones) {

		if (chancesAtaque == null) {

			this.crearArrayAtaque();

		}

		Random random = new Random();

		int ataqueElegido = chancesAtaque.get(random.nextInt(100));

		((Button) botoneraAcciones.getChildren().get(ataqueElegido)).fire();

	}

	@Override
	public void elegirElemento(BotoneraAcciones botoneraAcciones) {



	}

}
