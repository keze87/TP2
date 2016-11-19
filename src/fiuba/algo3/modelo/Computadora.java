package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.control.Button;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.Jugador;

public class Computadora extends Jugador {

	private enum Accion {
		ATACAR, MOCHILA;
	}

	public Computadora() {

		super();

		this.capacidadEquipo = 1;

		this.agregarAlgoMonAlEquipo(AlgoMonBuilder.crearGengar());

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

			botonAtacar.fire();
			//botonMochila.fire(); TODO

		}

	}

	private Accion elegirAccion() {

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

	}

}
