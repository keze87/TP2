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

	private void setAtaque1(Ataque ataque) {
		this.ataques.add(0, ataque);
	}

	private void setAtaque2(Ataque ataque) {
		this.ataques.add(1, ataque);
	}

	private void setAtaque3(Ataque ataque) {
		this.ataques.add(2, ataque);
	}

	public boolean estaVivo() {
		return this.vida > 0;
	}

	public void ataque1(AlgoMon contrincante) {
		// TODO Auto-generated method stub
	}

	public void ataque2(AlgoMon contrincante) {
		// TODO Auto-generated method stub
	}

	public void ataque3(AlgoMon contrincante) {
		// TODO Auto-generated method stub
	}

	public void recibirAtaque(Ataque ataque) {
		// Testear
		this.vida -= ataque.getPoder() * ataque.getTipo().getMultiplicadorContra(this.tipo);
	}

}
