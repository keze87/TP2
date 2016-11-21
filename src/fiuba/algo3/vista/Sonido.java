package src.fiuba.algo3.vista;

import java.io.File;
import java.util.HashMap;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Sonido {

	static String rutaSonido = "src/fiuba/algo3/vista/Sonidos/";
	private static HashMap<String, MediaPlayer> sonidos = new HashMap<>();

	static {

		Sonido.agregar("Ataque rápido.wav");
		Sonido.agregar("BotonPresionado.wav");
		Sonido.agregar("Brasas.wav");
		Sonido.agregar("Burbuja.wav");
		Sonido.agregar("Cañón de agua.wav");
		Sonido.agregar("Canto.wav");
		Sonido.agregar("Chupavidas.wav");
		Sonido.agregar("click.mp3");
		Sonido.agregar("Fogonazo.wav");
		Sonido.agregar("Látigo cepa.wav");
		Sonido.agregar("Maldicion.wav");
		Sonido.agregar("Pokemon_Opening.mp3");
		Sonido.agregar("RecibirElemento.wav");
		Sonido.agregar("Wrong.mp3");
		Sonido.agregar("Pokemon_Battle.mp3");
		Sonido.agregar("Victoria.mp3");

	}

	public static void play(String nombreArchivo) {

		MediaPlayer retorno = Sonido.get(nombreArchivo);

		retorno.seek(Duration.ZERO);

		retorno.play();

	}

	public static void play(String nombreArchivo, double volumen) {

		MediaPlayer retorno = Sonido.get(nombreArchivo);

		retorno.seek(Duration.ZERO);

		retorno.setVolume(volumen);

		retorno.play();

	}

	public static void stop(String nombreArchivo) {

		MediaPlayer retorno = Sonido.get(nombreArchivo);

		retorno.stop();

	}

	public static MediaPlayer get(String nombreArchivo) {
		String nombreCompleto = nombreArchivo.concat(".mp3");

		if(!sonidos.containsKey(nombreCompleto)){
			nombreCompleto = nombreArchivo.concat(".wav");
		}
		MediaPlayer retorno = sonidos.get(nombreCompleto);

		if (retorno == null) {
			retorno = Sonido.get("Wrong");
		}

		return retorno;

	}

	private static void agregar(String key) {

		String nombreArchivo = rutaSonido + key;
		Media media = new Media(new File(nombreArchivo).toURI().toString());
		sonidos.put(key, new MediaPlayer(media));

	}


	public static void stopSonidos(){
		stop("Pokemon_Battle");
		stop("Pokemon_Opening");
	}
}