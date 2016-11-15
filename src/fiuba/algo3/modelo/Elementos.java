package src.fiuba.algo3.modelo;

import src.fiuba.algo3.modelo.elementos.Pocion;
import src.fiuba.algo3.modelo.elementos.Restaurador;
import src.fiuba.algo3.modelo.elementos.SuperPocion;
import src.fiuba.algo3.modelo.elementos.Vitamina;

public final class Elementos {

	private int cantDePociones, cantDeSuperPociones, cantRestaurador, cantVitamina;
	public Elementos(){
		this.cantDePociones = 4;
		this.cantDeSuperPociones = 2;
		this.cantRestaurador = 3;
		this.cantVitamina = 5;
	}

	public Pocion getPocion(){
		if(cantDePociones > 0){
			cantDePociones--;
			return new Pocion();
		}
		return null;
	}
	public SuperPocion getSuperPocion(){
		if(cantDeSuperPociones > 0){
			cantDeSuperPociones--;
			return new SuperPocion();
		}
		return null;
	}
	public Restaurador getRestaurador(){
		if(cantRestaurador > 0){
			cantRestaurador--;
			return new Restaurador();
		}
		return null;
	}
	public Vitamina getVitamina(){
		if(cantVitamina > 0){
			cantVitamina--;
			return new Vitamina();
		}
		return null;
	}

}
