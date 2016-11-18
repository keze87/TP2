package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.efectos.Efecto;
import src.fiuba.algo3.modelo.efectos.EfectoMultiple;
import src.fiuba.algo3.modelo.efectos.QuitarVida;
import src.fiuba.algo3.modelo.excepciones.AtaqueAgotado;
import src.fiuba.algo3.modelo.tipo.Tipo;

public abstract class Ataque {
	protected NombreAtaque nombre;
	protected int potencia;
	protected int usosTotales;
	protected int usosRestantes;
	protected Tipo tipo;
	protected EfectoMultiple efecto;
	protected Efecto efectoBaseAlgoMonAtacado,efectoAlgoMonAtacante;

	public Ataque(NombreAtaque nombre, int poder, int usosTotales, Efecto efectoBaseAtacado, Efecto efectoAtacante) {
		this.nombre = nombre;
		this.potencia = poder;
		this.usosTotales = usosTotales;
		this.usosRestantes = usosTotales;
		this.efectoBaseAlgoMonAtacado = efectoBaseAtacado;
		this.efectoAlgoMonAtacante= efectoAtacante;
	}

	/* Devuelve el nombre del ataque. */
	public NombreAtaque getNombre() {
		return nombre;
	}

	/*Ataca a un algomon y devuelve el efecto sobre el atacante*/
	public Efecto atacar(AlgoMon algoMon) throws AtaqueAgotado {
		double vidaQuitada = this.calcularDaño(algoMon);
		this.validarCantidadDeUsos();
		this.crearEfectoAtacado(vidaQuitada);
		algoMon.recibirEfecto(efecto);
		this.usosRestantes--;
		
		return this.obtenerEfectoAtacante(vidaQuitada);
	}
	
	/*Crea el efecto que se aplicara al algomon atacado*/
	private void crearEfectoAtacado(double vidaQuitada){
		this.efecto = new EfectoMultiple();
		this.efecto.agregarEfecto(this.efectoBaseAlgoMonAtacado);
		this.efecto.agregarEfecto(new QuitarVida(vidaQuitada));
	}
	
	/*Devuelve el efecto que se aplicara al algomon atacante*/
	private Efecto obtenerEfectoAtacante(double vidaQuitada){
		this.efectoAlgoMonAtacante.setVidaQuitadaAlOponente(vidaQuitada);
		return efectoAlgoMonAtacante;
	}
	
	/**
	 * Calcula el daño provocado a un algoMon dado.
	 * @param algoMon algoMon a atacar.
	 * @return el daño calculado.
	 */
	private double calcularDaño(AlgoMon algoMon) {
		return Math.floor(this.potencia * this.tipo.getMultiplicadorContra(algoMon.getTipo()).getValor());
	}

	/* Determina si el ataque tiene usos restantes. */
	private boolean quedanUsos() {
		return this.usosRestantes > 0;
	}
	
	/*Valida la cantidad de usos*/
	private void validarCantidadDeUsos(){
		if(!quedanUsos()) {
			throw new AtaqueAgotado("No quedan más usos para este ataque!");
		}

	}
	
	/*Aumenta la cantidad de usos del ataque*/
	public void aumentarCantidad(int cant) {
		this.usosRestantes+=cant;
	}
	
	public int getCantidadDeUsosRestantes(){
		return this.usosRestantes;
	}
}
