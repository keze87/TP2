package src.fiuba.algo3.vista;

import src.fiuba.algo3.modelo.AlgoMon;

public class BotonCambiarAlgoMon extends BotonAlgoMon {

	public BotonCambiarAlgoMon(AlgoMon algoMon) {
		super(algoMon);
		this.agregarContenido();
	}

	@Override
	protected void agregarTexto() {
		this.setText(this.algoMon.getNombre() + "\n" + (int) this.algoMon.getVida() + "/" + (int) this.algoMon.getVidaMaxima());
	}

	@Override
	protected void agregarImagen() {
		super.agregarImagen();
		this.getGraphic().setScaleX(0.5f);
		this.getGraphic().setScaleY(0.5f);
	}

}
