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

	/* Devuelve el estado del algoMon. */
	public Estado getEstado() {
		return estado;
	}

	/* Agrega los ataques al diccionario de ataques. */
	private void agregarAtaques(List<Ataque> ataques) {

		for (Ataque ataque : ataques) {

			this.ataques.put(ataque.getNombre(), ataque);

		}

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
	public void ataque(String nombreAtaque, AlgoMon contrincante) throws AlgoMonNoTieneAtaque{
		try {

			if (this.estado.puedeRealizarAccion()) {
				//contrincante.recibirAtaque(this.ataques.get(nombreAtaque));
				this.recibirEfecto(this.ataques.get(nombreAtaque).atacar(contrincante));
				this.estado.accionRealizada();
			}

		} catch (NullPointerException e) {
			throw new AlgoMonNoTieneAtaque(this.nombre + " no puede usar " + nombreAtaque + "!");
		}
	}

	/**
	 * Aplica el daño resultante de recibir un ataque.
	 * @param ataque ataque recibido de otro algoMon.
	 */
	//	public void recibirAtaque(Ataque ataque) {
	//
	//	this.recibirEfecto(ataque.atacar(this));
	//
	//	}
	public void recibirElemento(Elemento elemento){
		if(this.estado.puedeRealizarAccion()) {
			elemento.aplicar(this);
		}
		this.estado.accionRealizada();
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getVidaMaxima() {
		return this.estado.getVidaMaxima();
	}

	public double getVida() {
		return this.estado.getVida();
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public boolean contieneAtaque(String nombreAtaque) {

		return this.ataques.containsKey(nombreAtaque);

	}

	public void recibirEfecto(Efecto efecto) {
		this.estado=efecto.aplicar(this.estado);
	}

}
