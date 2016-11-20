
package src.fiuba.algo3.vista;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sonido {
	public static MediaPlayer click;
	private String rutaSonido = "src/fiuba/algo3/vista/Sonidos/";

	public Sonido(){
		click = setSonido("click.mp3");
	}

	/*Crea y devuelve un sonido*/
	private MediaPlayer setSonido(String nombreSonido) {
		Media sonido = new Media(new File(rutaSonido + nombreSonido).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sonido);
		return mediaPlayer;
	}


}