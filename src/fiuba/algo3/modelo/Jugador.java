package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import src.fiuba.algo3.modelo.ataques.NombreAtaque;


public final class Jugador {
	private List<AlgoMon> algoMones;
	private AlgoMon algoMonActivo;
	private String nombre;
	private int cantidadMaximaAlgoMones=4;
	private Elementos elementos;
	public Jugador(String nombre){
		this.nombre = nombre;
		this.algoMones = new ArrayList<AlgoMon>();
	}

	public void agregarAlgoMon(AlgoMon algoMon){
		if(!tieneLaCantidadMaximaDeAlgoMones()&&elJugadorNoTieneElAlgoMon(algoMon)){
			this.algoMones.add(algoMon);
			if(this.algoMonActivo==null) this.algoMonActivo=algoMon;
		}
	}

	private boolean elJugadorNoTieneElAlgoMon(AlgoMon algoMon) {
		return !this.algoMones.contains(algoMon);
	}

	private boolean tieneLaCantidadMaximaDeAlgoMones() {
		return algoMones.size()==this.cantidadMaximaAlgoMones;
	}
	
	public boolean seLlama(String nombre){
		return this.nombre.equals(nombre);
	}
	
	public void cambiarAlgoMonActivo(NombreAlgoMon nombre){
		for(AlgoMon algoMon:algoMones){
			if (algoMon.seLlama(nombre)){
				this.algoMonActivo= algoMon;
			}
		}
	}
	
	public void usarPocion(){
		this.elementos.getPocion().aplicar(algoMonActivo);
	}
	
	public void usarSuperPocion(){
		this.elementos.getSuperPocion().aplicar(algoMonActivo);
	}
	
	public void usarRestaurador(){
		this.elementos.getRestaurador().aplicar(algoMonActivo);
	}
	
	public void usarVitamina(){
		this.elementos.getVitamina().aplicar(algoMonActivo);
	}
	
	public void atacar(NombreAtaque nombreAtaque,AlgoMon contrincante){
		this.algoMonActivo.atacar(nombreAtaque, contrincante);
	}
	
}
