package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import src.fiuba.algo3.modelo.ataques.Ataque;

public class AlgoMon {

	protected String nombre;
	protected int vidaMaxima;
	protected double vida;
	protected Tipo tipo;
	protected List<Ataque> ataques;

	public AlgoMon(String nombre, int vidaMaxima, Ataque ataque1, Ataque ataque2, Ataque ataque3) {

		this.nombre = nombre;
		this.vidaMaxima = vidaMaxima;
		this.vida = vidaMaxima;
		this.ataques = new ArrayList<Ataque>();
		this.agregarAtaques(ataque1, ataque2, ataque3);

	}

	/* Agrega los ataques a la colección de ataques. */
	private void agregarAtaques(Ataque ataque1, Ataque ataque2, Ataque ataque3) {
		this.ataques.add(0, ataque1);
		this.ataques.add(1, ataque2);
		this.ataques.add(2, ataque3);
	}

	/**
	 * Determina si el algoMon está vivo.
	 * @return true si está vivo, sino false.
	 */
	public boolean estaVivo() {
		return this.vida > 0;
	}

	/**
	 * Ataca a otro algoMon con el ataque seleccionado.
	 * @param contrincante algoMon al cual se desea atacar.
	 */
	public void ataque1(AlgoMon contrincante) {
		contrincante.recibirAtaque(this.ataques.get(0));
	}

	public void ataque2(AlgoMon contrincante) {
		contrincante.recibirAtaque(this.ataques.get(1));
	}

	public void ataque3(AlgoMon contrincante) {
		contrincante.recibirAtaque(this.ataques.get(2));
	}

	/**
	 * Aplica el daño resultante de recibir un ataque.
	 * @param ataque ataque recibido de otro algoMon.
	 */
	public void recibirAtaque(Ataque ataque) {
		this.vida -= ataque.aplicarAtaque(this);
	}

	public double getVida() {

		return vida;

	}

	public String nombre() {

		return nombre;

	}

	public Tipo getTipo() {

		return this.tipo;

	}

	public Ataque ataque1() {

		return this.ataques.get(0);

	}

	public Ataque ataque2() {

		return this.ataques.get(1);

	}

	public Ataque ataque3() {

		return this.ataques.get(2);

	}


}
