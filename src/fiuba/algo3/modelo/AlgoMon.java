package src.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.fiuba.algo3.modelo.ataques.Ataque;
import src.fiuba.algo3.modelo.efectos.Efecto;
import src.fiuba.algo3.modelo.elementos.Elemento;
import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.EstadoNormal;
import src.fiuba.algo3.modelo.tipo.Tipo;

public class AlgoMon {

	protected String nombre;
	protected Tipo tipo;
	protected Map<String, Ataque> ataques;
	protected Estado estado;

	public AlgoMon(String nombre, int vidaMaxima, List<Ataque> ataques) {
		this.nombre = nombre;
		this.ataques = new HashMap<String, Ataque>();
		this.agregarAtaques(ataques);
		this.estado = new EstadoNormal(vidaMaxima);
	}

	/* Devuelve el nombre del algoMon. */
	public String getNombre() {
		return this.nombre;
	}

	/* Devuelve la vida máxima del algoMon. */
	public double getVidaMaxima() {
		return this.estado.getVidaMaxima();
	}

	/* Devuelve la vida actual del algoMon. */
	public double getVida() {
		return this.estado.getVida();
	}

	/* Devuelve el tipo del algoMon. */
	public Tipo getTipo() {
		return this.tipo;
	}

	/* Devuelve el estado del algoMon. */
	public Estado getEstado() {
		return estado;
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
	public void ataque(String nombreAtaque, AlgoMon contrincante) throws AlgoMonNoTieneAtaque {
		try {

			if (this.estado.puedeRealizarAccion()) {
				this.recibirEfecto(this.ataques.get(nombreAtaque).atacar(contrincante));
			}

			this.estado.accionRealizada();

		} catch (NullPointerException e) {
			throw new AlgoMonNoTieneAtaque(this.nombre + " no puede usar " + nombreAtaque + "!");
		}
	}

	/**
	 * Aplica un efecto al estado del algoMon.
	 * @param efecto efecto a aplicar.
	 */
	public void recibirEfecto(Efecto efecto) {
		this.estado = efecto.aplicar(this.estado);
	}

	/**
	 * Aplica el daño resultante de recibir un ataque.
	 * @param ataque ataque recibido de otro algoMon.
	 */
	public void recibirElemento(Elemento elemento){
		if(this.estado.puedeRealizarAccion()) {
			elemento.aplicar(this);
		}

		this.estado.accionRealizada();
	}

	/**
	 * Determina si el algoMon tiene un ataque dado.
	 * @param nombreAtaque nombre del ataque.
	 * @return true si tiene el ataque, sino false.
	 */
	public boolean contieneAtaque(String nombreAtaque) {
		return this.ataques.containsKey(nombreAtaque);
	}

	/* Agrega los ataques al diccionario de ataques. */
	private void agregarAtaques(List<Ataque> ataques) {
		for (Ataque ataque : ataques) {
			this.ataques.put(ataque.getNombre(), ataque);
		}
	}

	public void recibirAtaque(Ataque ataque) {

		this.recibirEfecto(ataque.atacar(this));

	}

}
