package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.fiuba.algo3.modelo.ataques.Ataque;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.efectos.Efecto;
import src.fiuba.algo3.modelo.elementos.Elemento;
import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.EstadoNormal;
import src.fiuba.algo3.modelo.excepciones.AlgoMonDormidoNoPuedeAtacar;
import src.fiuba.algo3.modelo.excepciones.AlgoMonMurio;
import src.fiuba.algo3.modelo.excepciones.AlgoMonMurioPorQuemadura;
import src.fiuba.algo3.modelo.excepciones.AlgoMonNoTieneAtaque;
import src.fiuba.algo3.modelo.excepciones.AlgoMonRecibeDañoQuemadura;
import src.fiuba.algo3.modelo.tipo.Tipo;

public class AlgoMon {

	protected NombreAlgoMon nombre;
	protected Tipo tipo;
	protected Map<NombreAtaque, Ataque> ataques;
	protected Estado estado;

	public AlgoMon(NombreAlgoMon nombre, double vidaMaxima, List<Ataque> ataques) {
		this.nombre = nombre;
		this.ataques = new HashMap<NombreAtaque, Ataque>();
		this.agregarAtaques(ataques);
		this.estado = new EstadoNormal(vidaMaxima);
	}

	/* Devuelve el nombre del algoMon. */
	public String getNombre() {
		return this.nombre.toString();
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
	public void atacar(NombreAtaque nombreAtaque, AlgoMon contrincante) throws AlgoMonNoTieneAtaque {
		try {
			if (this.estado.puedeRealizarAccion()) {
				this.recibirEfecto(this.ataques.get(nombreAtaque).atacar(contrincante));
				this.estado.accionRealizada();
			}

			else {
				this.estado.accionRealizada();
				throw new AlgoMonDormidoNoPuedeAtacar(this.nombre + " está dormido. ¡No puede atacar!");
			}

		} catch(NullPointerException e) {
			throw new AlgoMonNoTieneAtaque(this.nombre + " no puede usar " + nombreAtaque.toString() + "!");
		} catch(AlgoMonMurio e) {
			this.estado.accionRealizada();
			throw e;
		} catch(AlgoMonRecibeDañoQuemadura e) {
			throw new AlgoMonRecibeDañoQuemadura("¡" + this.nombre + " recibe daño de la quemadura!");
		} catch(AlgoMonMurioPorQuemadura e) {
			throw new AlgoMonMurioPorQuemadura("¡" + this.nombre + " murió a causa de la quemadura!");
		}
	}

	/**
	 * Aplica un efecto al estado del algoMon.
	 * @param efecto efecto a aplicar.
	 */
	public void recibirEfecto(Efecto efecto) {
		try {
			this.estado = efecto.aplicar(this.estado);
		} catch(AlgoMonMurio e) {
			throw new AlgoMonMurio("¡" + this.nombre + " murió!");
		}
	}

	/**
	 * Aplica el daño resultante de recibir un ataque.
	 * @param ataque ataque recibido de otro algoMon.
	 */
	public void recibirElemento(Elemento elemento){
		try {
			elemento.aplicar(this);
			this.estado.accionRealizada();
		} catch (AlgoMonRecibeDañoQuemadura e) {
			throw new AlgoMonRecibeDañoQuemadura("¡" + this.nombre + " recibe daño de la quemadura!");
		} catch(AlgoMonMurioPorQuemadura e) {
			throw new AlgoMonMurioPorQuemadura("¡" + this.nombre + " murió a causa de la quemadura!");
		}
	}

	/**
	 * Determina si el algoMon tiene un ataque dado.
	 * @param nombreAtaque nombre del ataque.
	 * @return true si tiene el ataque, sino false.
	 */
	public boolean contieneAtaque(NombreAtaque nombreAtaque) {
		return this.ataques.containsKey(nombreAtaque);
	}

	/* Devuelve true o false según si la vida es igual a la vida máxima. */
	public boolean tieneVidaCompleta() {
		return this.estado.tieneVidaCompleta();
	}

	public void aumentarCantidadAtaquesDisponibles(int cantidad) {
		for (Ataque ataque : ataques.values()) {
			ataque.aumentarCantidad(cantidad);
		}
	}

	public Ataque getAtaque(NombreAtaque nombre) {
		return this.ataques.get(nombre);
	}

	public List<NombreAtaque> getNombresAtaques() {
		List<NombreAtaque> nombresAtaques = new ArrayList<NombreAtaque>(this.ataques.keySet());

		nombresAtaques.sort(new Comparator<NombreAtaque>() {

			@Override
			public int compare(NombreAtaque a, NombreAtaque b) {
				return a.toString().compareTo(b.toString());
			}

		});

		return nombresAtaques;
	}

	public int getUsosRestantesAtaque(NombreAtaque nombre) {
		return this.ataques.get(nombre).getUsosRestantes();
	}

	public int getUsosTotalesAtaque(NombreAtaque nombreAtaque) {
		return this.ataques.get(nombreAtaque).getUsosTotales();
	}

	/* Agrega los ataques al diccionario de ataques. */
	private void agregarAtaques(List<Ataque> ataques) {
		for (Ataque ataque : ataques) {
			this.ataques.put(ataque.getNombre(), ataque);
		}
	}

}
