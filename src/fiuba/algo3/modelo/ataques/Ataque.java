package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.efectos.Efecto;
import src.fiuba.algo3.modelo.efectos.EfectoMultiple;
import src.fiuba.algo3.modelo.efectos.QuitarVida;
import src.fiuba.algo3.modelo.excepciones.AtaqueAgotado;
import src.fiuba.algo3.modelo.tipo.Tipo;

public abstract class Ataque {
	protected String nombre;
	protected int potencia;
	protected int usosTotales;
	protected int usosRestantes;
	protected Tipo tipo;
	protected EfectoMultiple efecto;
	protected Efecto efectoBaseAlgoMonAtacado,efectoAlgoMonAtacante;

	public Ataque(String nombre, int poder, int usosTotales, Efecto efectoBaseAtacado, Efecto efectoAtacante) {
		this.nombre = nombre;
		this.potencia = poder;
		this.usosTotales = usosTotales;
		this.usosRestantes = usosTotales;
		this.efectoBaseAlgoMonAtacado = efectoBaseAtacado;
		this.efectoAlgoMonAtacante= efectoAtacante;
	}

	/* Devuelve el nombre del ataque. */
	public String getNombre() {
		return nombre;
	}

	//Ataca a un algomon y devuelve el efecto sobre el atacante
	public Efecto atacar(AlgoMon algoMon) throws AtaqueAgotado {
		double vidaQuitada = this.calcularDaño(algoMon);
		this.efecto = new EfectoMultiple();
		this.efecto.agregarEfecto(this.efectoBaseAlgoMonAtacado);
		this.efectoAlgoMonAtacante.setVidaQuitadaAlOponente(vidaQuitada);

		if(!quedanUsos()) {
			throw new AtaqueAgotado("No quedan más usos para este ataque!");
		}

		this.efecto.agregarEfecto(new QuitarVida(vidaQuitada));

		algoMon.recibirEfecto(efecto);
		this.usosRestantes--;
		return this.efectoAlgoMonAtacante;
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

	public void aumentarCantidad(int cant) {
		this.usosRestantes+=cant;
	}
}
