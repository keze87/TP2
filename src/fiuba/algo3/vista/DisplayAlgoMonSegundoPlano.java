package src.fiuba.algo3.vista;

import src.fiuba.algo3.modelo.AlgoMon;

public class DisplayAlgoMonSegundoPlano extends DisplayAlgoMon {

	public DisplayAlgoMonSegundoPlano(AlgoMon algoMon) {
		super(algoMon, 2);
	}

	@Override
	public void inicializar() {
		super.inicializar();
		this.getChildren().add(this.contenedorInformacion);
		this.getChildren().add(this.imagen);
	}

	@Override
	protected void actualizarImagen() {
		this.imagen.setImage(ContenedorImagenes.getImagen(this.algoMon.getNombre()));
		super.actualizarImagen();
	}

}
