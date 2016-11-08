package src.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;

import src.fiuba.algo3.modelo.ataques.Ataque;
import src.fiuba.algo3.modelo.efectos.Efecto;
import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.EstadoNormal;

public class AlgoMon {

	protected String nombre;
	protected int vidaMaxima;
	protected Tipo tipo;
	protected Map<String, Ataque> ataques;
	protected Estado estado;

	public AlgoMon(String nombre, int vidaMaxima, Ataque ataque1, Ataque ataque2, Ataque ataque3) {

		this.nombre = nombre;
		this.vidaMaxima = vidaMaxima;
		this.ataques = new HashMap<String, Ataque>();
		this.agregarAtaques(ataque1, ataque2, ataque3);
		this.estado = new EstadoNormal(vidaMaxima);

	}

	/* Devuelve el estado del algoMon. */
	public Estado getEstado() {
		return estado;
	}

	/* Agrega los ataques al diccionario de ataques. */
	private void agregarAtaques(Ataque ataque1, Ataque ataque2, Ataque ataque3) {
		this.ataques.put(ataque1.getNombre(), ataque1);
		this.ataques.put(ataque2.getNombre(), ataque2);
		this.ataques.put(ataque3.getNombre(), ataque3);
	}

	/**
	 * Determina si el algoMon está vivo.
	 * @return true si está vivo, sino false.
	 */
	public boolean estaVivo() {
		return this.estado.estaVivo();
	}

	/**
	 * Ataca a un algoMon con el ataque seleccionado. Si el algoMon atacante
	 * no conoce el ataque, lanza una excepción.
	 * @param nombreAtaque nombre del ataque.
	 * @param contrincante algoMon a atacar.
	 */
	public void ataque(String nombreAtaque, AlgoMon contrincante) {
		try {

			if(this.estado.puedeRealizarAccion()) {
				contrincante.recibirAtaque(this.ataques.get(nombreAtaque));
				this.estado.accionRealizada();
			}

		} catch(NullPointerException e) {
			throw new AlgoMonNoTieneAtaque(this.nombre + " no puede usar " + nombreAtaque + "!");
		}
	}

	/**
	 * Aplica el daño resultante de recibir un ataque.
	 * @param ataque ataque recibido de otro algoMon.
	 */
	public void recibirAtaque(Ataque ataque) {
		//this.estado.setVida(estado.getVida() - ataque.aplicarAtaque(this));

		Efecto efectoDelAtaque;

		efectoDelAtaque = ataque.atacar(this);
		this.estado = efectoDelAtaque.aplicar(this.estado);

	}

	public String getNombre() {
		return this.nombre;
	}

	public double getVidaMaxima() {
		return this.vidaMaxima;
	}

	public double getVida() {
		return this.estado.getVida();
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
