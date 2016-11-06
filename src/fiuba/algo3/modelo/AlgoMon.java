package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import src.fiuba.algo3.modelo.ataques.Ataque;
import src.fiuba.algo3.modelo.efectos.Efecto;
import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.EstadoNormal;

public class AlgoMon {

	protected String nombre;
	protected int vidaMaxima;
	protected Tipo tipo;
	protected List<Ataque> ataques;
	protected Estado estado;

	public AlgoMon(String nombre, int vidaMaxima, Ataque ataque1, Ataque ataque2, Ataque ataque3) {

		this.nombre = nombre;
		this.vidaMaxima = vidaMaxima;
		this.ataques = new ArrayList<Ataque>();
		this.agregarAtaques(ataque1, ataque2, ataque3);
		this.estado = new EstadoNormal(vidaMaxima);

	}
	public Estado getEstado() {
		return estado;
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
		return this.estado.estaVivo();
	}

	/**
	 * Ataca a otro algoMon con el ataque seleccionado.
	 * @param contrincante algoMon al cual se desea atacar.
	 */
	public void ataque1(AlgoMon contrincante) {
		if(estado.puedeRealizarAccion()){
			contrincante.recibirAtaque(this.ataques.get(0));
			estado.accionRealizada();
		}
	}

	public void ataque2(AlgoMon contrincante) {
		if(estado.puedeRealizarAccion()){
			contrincante.recibirAtaque(this.ataques.get(1));
			estado.accionRealizada();
		}
	}

	public void ataque3(AlgoMon contrincante) {
		if(estado.puedeRealizarAccion()){
			contrincante.recibirAtaque(this.ataques.get(2));
			estado.accionRealizada();
		}
	}

	/**
	 * Aplica el daño resultante de recibir un ataque.
	 * @param ataque ataque recibido de otro algoMon.
	 */
	public void recibirAtaque(Ataque ataque) {
		//this.estado.setVida(estado.getVida() - ataque.aplicarAtaque(this));

		Efecto efectoDelAtaque;

		efectoDelAtaque=ataque.atacar(this);
		this.estado=efectoDelAtaque.aplicar(this.estado);

	}

	public double getVida() {

		return estado.getVida();

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
