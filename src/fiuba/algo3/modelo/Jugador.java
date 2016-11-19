package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.elementos.Elemento;
import src.fiuba.algo3.modelo.elementos.NombreElemento;
import src.fiuba.algo3.modelo.excepciones.AlgoMonNoExiste;
import src.fiuba.algo3.modelo.excepciones.AlgoMonYaEstaActivo;
import src.fiuba.algo3.modelo.excepciones.EquipoCompleto;
import src.fiuba.algo3.modelo.excepciones.NoHayAlgoMonActivo;

public class Jugador {

	private static int capacidadEquipo = 3;
	private List<AlgoMon> equipo;
	private AlgoMon algoMonActivo;
	private Mochila mochila;

	public Jugador() {
		this.equipo = new ArrayList<AlgoMon>();
		this.mochila = new Mochila();
	}

	/* Determina si un algoMon dado está en el equipo. */
	public boolean tieneAlgoMonEnEquipo(AlgoMon algoMon) {
		return this.equipo.contains(algoMon);
	}

	/* Agrega un algoMon al equipo. Si el equipo está completo lanza una excepción.*/
	public void agregarAlgoMonAlEquipo(AlgoMon algoMon) {
		if(this.equipoEstaCompleto()) {
			throw new EquipoCompleto("El equipo está completo!");
		}

		this.equipo.add(algoMon);
	}

	/* Saca un algoMon dado del equipo. */
	public void sacarAlgoMonDelEquipo(AlgoMon algoMon) {
		this.equipo.remove(algoMon);
	}

	/* Devuelve una lista con los algoMon que conforman el equipo. */
	public List<AlgoMon> getEquipo() {
		return this.equipo;
	}

	/* Determina si el equipo está lleno. */
	public boolean equipoEstaCompleto() {
		return this.equipo.size() == Jugador.capacidadEquipo;
	}

	/* Asigna el primer algoMon del equipo como algoMon activo. */
	public void listoParaPelear() {
		this.algoMonActivo = this.equipo.get(0);
	}

	/* Determina si el jugador tiene algún algoMon vivo. */
	public boolean puedeSeguirJugando() {
		boolean hayAlgoMonVivos = true;

		for(AlgoMon algoMon : this.equipo) {
			hayAlgoMonVivos |= algoMon.estaVivo();
		}

		return hayAlgoMonVivos;
	}

	/* Devuelve el algoMon activo. */
	public AlgoMon getAlgoMonActivo() {
		try {
			return this.algoMonActivo;
		} catch(NullPointerException e) {
			throw new NoHayAlgoMonActivo("No hay un algoMon activo!");
		}
	}

	/* Ataca a otro algoMon con el algoMon activo. */
	public void atacarConAlgoMonActivo(NombreAtaque nombreAtaque, AlgoMon algoMon) {
		this.getAlgoMonActivo().atacar(nombreAtaque, algoMon);
	}

	/**
	 * Cambia el algoMon activo por otro algoMon dado.
	 * @param squirtle próximo algoMon activo.
	 */
	public void cambiarAlgoMonActivo(AlgoMon algoMon) {
		if(!this.tieneAlgoMonEnEquipo(algoMon)) {
			throw new AlgoMonNoExiste(algoMon.getNombre() + " no está en el equipo!");
		}

		else if(this.getAlgoMonActivo().equals(algoMon)) {
			throw new AlgoMonYaEstaActivo(algoMon.getNombre() + " ya es el algoMon activo!");
		}

		else if(!algoMon.estaVivo()) {
			//throw new AlgoMonMuerto(algoMon.getNombre() + " está muerto. No se puede cambiar!");
		}

		this.algoMonActivo = algoMon;
	}

	/* Devuelve una lista con los algoMonInactivos. */
	public List<AlgoMon> getAlgoMonInactivos() {
		List<AlgoMon> algoMonInactivos = new ArrayList<AlgoMon>(this.equipo);

		algoMonInactivos.remove(this.algoMonActivo);
		return algoMonInactivos;
	}

	/* Usa el elemento cuyo nombre es recibido por parámetro sobre el algoMon activo. */
	public void usarElemento(NombreElemento nombreElemento) {
		this.usarElemento(this.mochila.getElemento(nombreElemento));
	}


	/* Usa el elemento recibido por parámetro sobre el algoMon activo. */
	private void usarElemento(Elemento elemento) {
		this.getAlgoMonActivo().recibirElemento(elemento);
	}

}
