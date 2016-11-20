package src.fiuba.algo3.vista;

import java.io.File;
import java.util.HashMap;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Sonido {

	static String rutaSonido = "src/fiuba/algo3/vista/Sonidos/";

	private static HashMap<String, MediaPlayer> sonidos = new HashMap<>();

	public static MediaPlayer getSeek(String nombreArchivo) {

		MediaPlayer retorno = Sonido.get(nombreArchivo);

		retorno.seek(Duration.ZERO);

		return retorno;

	}

	public static MediaPlayer get(String nombreArchivo) {

		if (sonidos.size() == 0) {
			Sonido.inicializar();
		}

		MediaPlayer retorno = sonidos.get(nombreArchivo);

		if (retorno == null) {
			retorno = Sonido.get("Wrong.mp3");
		}

		return retorno;

	}

	private static void inicializar(){

		Sonido.agregar("Ataque rápido.wav");
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
		Sonido.agregar("Wrong.mp3");
		Sonido.agregar("Pokemon_Battle.mp3");

	}

	private static void agregar(String key) {

		String nombreArchivo = rutaSonido + key;
		Media media = new Media(new File(nombreArchivo).toURI().toString());
		sonidos.put(key, new MediaPlayer(media));

	}

}