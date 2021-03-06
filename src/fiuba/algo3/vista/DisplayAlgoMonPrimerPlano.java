package src.fiuba.algo3.vista;

import src.fiuba.algo3.modelo.AlgoMon;

public class DisplayAlgoMonPrimerPlano extends DisplayAlgoMon {

	public DisplayAlgoMonPrimerPlano(AlgoMon algoMon) {
		super(algoMon, 3);
	}

	@Override
	public void inicializar() {
		super.inicializar();
		this.getChildren().add(this.imagen);
		this.getChildren().add(this.contenedorInformacion);
	}

	@Override
	protected void actualizarImagen() {
		this.imagen.setImage(ContenedorImagenes.getImagen(this.algoMon.getNombre() + "_espalda"));
		super.actualizarImagen();
	}

}
