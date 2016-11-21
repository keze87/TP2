package src.fiuba.algo3.vista;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public final class ContenedorImagenes {
	private static String directorio = "src/fiuba/algo3/vista/Imagenes/";
	private static Map<String, Image> imagenes;

	static {
		cargarImagenes();
	}

	/**
	 * Devuelve una instancia de Image a partir del nombre de una imagen.
	 * @param nombreImagen nombre de la imagen.
	 * @return una nueva instancia de Image.
	 */
	public static Image getImagen(String nombreImagen) {
		return imagenes.get(nombreImagen);
	}

	/**
	 * Devuelve una instancia de ImageView a partir del nombre de una imagen.
	 * @param nombreImagen nombre de la imagen.
	 * @return una nueva instancia de ImageView.
	 */
	public static ImageView getImageView(String nombreImagen) {
		return new ImageView(getImagen(nombreImagen));
	}

	/**
	 * Devuelve una instancia de Background a partir del nombre de una imagen.
	 * @param nombreImagen nombre de la imagen.
	 * @return una nueva instancia de Background.
	 */
	public static Background getBackground(String nombreImagen) {
		BackgroundImage imagenFondo = new BackgroundImage(getImagen(nombreImagen), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

		return new Background(imagenFondo);
	}

	/* Agrega las imágenes de la carpeta de imágenes al diccionario. */
	public static void cargarImagenes() {
		imagenes = new HashMap<String, Image>();

		File carpetaImagenes = new File(directorio);
		File[] nombresImagenes = carpetaImagenes.listFiles();

		for (File nombreImagen : nombresImagenes) {
			if (nombreImagen.isFile()) {
				String[] partes = nombreImagen.getName().split("\\.");

				String claveImagen = partes[0];

				imagenes.put(claveImagen, new Image(directorio + nombreImagen.getName()));
			}
		}
	}

}
