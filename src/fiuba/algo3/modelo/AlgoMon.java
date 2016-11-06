package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import src.fiuba.algo3.modelo.ataques.Ataque;

public class AlgoMon {

	protected String nombre;
	protected int vidaMaxima;
	protected int vida;
	protected Tipo tipo;
	protected List<Ataque> ataques;

	public AlgoMon(String nombre, int vidaMaxima, Ataque ataque1, Ataque ataque2, Ataque ataque3) {
		this.nombre = nombre;
		this.vidaMaxima = vidaMaxima;
		this.vida = vidaMaxima;
		this.ataques = new ArrayList<Ataque>();
	}

	/**
	 * Agrega un ataque a la colección de ataques.
	 * @param numeroAtaque numero del ataque a agregar.
	 * @param ataque ataque para agregar a la colección de ataques.
	 */
	private void setAtaque(int numeroAtaque, Ataque ataque) {
		this.ataques.add(numeroAtaque, ataque);
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
		// TODO Auto-generated method stub
	}

	public void ataque2(AlgoMon contrincante) {
		// TODO Auto-generated method stub
	}

	public void ataque3(AlgoMon contrincante) {
		// TODO Auto-generated method stub
	}

	/**
	 * Aplica el daño resultante de recibir un ataque.
	 * @param ataque ataque recibido de otro algoMon.
	 */
	public void recibirAtaque(Ataque ataque) {
		// Testear
		this.vida -= ataque.getPoder() * ataque.getTipo().getMultiplicadorContra(this.tipo);
	}

}
