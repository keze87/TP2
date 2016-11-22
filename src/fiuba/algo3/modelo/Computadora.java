package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.control.Button;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.Jugador;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.elementos.NombreElemento;
import src.fiuba.algo3.modelo.estados.Dormido;
import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.Quemado;
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

		Accion retorno;

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

			retorno = array.get(random.nextInt(100));

		} else {

			retorno = Accion.MOCHILA;

		}

		if (retorno == Accion.MOCHILA) {

			if ( ! mochila.quedanElementos()) {

				retorno = Accion.ATACAR;

			}

		} else {

			if ( ! this.getAlgoMonActivo().quedanAtaques()) {

				retorno = Accion.MOCHILA;

			}

		}


		return retorno;

	}

	@Override
	public void elegirAtaque(BotoneraAcciones botoneraAcciones) {

		if (chancesAtaque == null) {

			this.crearArrayAtaque();

		}

		Random random = new Random();

		int ataqueElegido = chancesAtaque.get(random.nextInt(100));

		while (this.getAlgoMonActivo().getUsosRestantesAtaque(
				this.getAlgoMonActivo().getNombresAtaques().get(ataqueElegido)) == 0) {

			ataqueElegido = chancesAtaque.get(random.nextInt(100));

		}

		((Button) botoneraAcciones.getChildren().get(ataqueElegido)).fire();

	}

	@Override
	public void elegirElemento(BotoneraAcciones botoneraAcciones) {

		int elementoElegido;

		AlgoMon algoMon = this.getAlgoMonActivo();

		Estado estadoAlgomon = algoMon.getEstado();

		double porcentajeVidaAlgomon = (algoMon.getVida() * 100) / algoMon.getVidaMaxima();

		if (((estadoAlgomon instanceof Dormido) || (estadoAlgomon instanceof Quemado)) &&
				(this.mochila.getCantidadRestanteElemento(NombreElemento.RESTAURADOR) > 0)) {

			elementoElegido = 2;

		} else if ((porcentajeVidaAlgomon < 50) &&
				(this.mochila.getCantidadRestanteElemento(NombreElemento.SUPERPOCION) > 0)) {

			elementoElegido = 1;

		} else if ((porcentajeVidaAlgomon < 50) &&
				(this.mochila.getCantidadRestanteElemento(NombreElemento.POCION) > 0)) {

			elementoElegido = 0;

		} else {

			if (this.mochila.getCantidadRestanteElemento(NombreElemento.RESTAURADOR) > 0) {
				elementoElegido = 2;
			} else if (this.mochila.getCantidadRestanteElemento(NombreElemento.SUPERPOCION) > 0) {
				elementoElegido = 1;
			} else if (this.mochila.getCantidadRestanteElemento(NombreElemento.POCION) > 0) {
				elementoElegido = 0;
			} else {
				elementoElegido = 3;
			}

		}

		((Button) botoneraAcciones.getChildren().get(elementoElegido)).fire();

	}

}
