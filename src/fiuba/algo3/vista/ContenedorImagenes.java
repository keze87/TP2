package src.fiuba.algo3.vista;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public final class ContenedorImagenes {
	private static String directorio = "src/fiuba/algo3/vista/Imagenes/";
	private static Map<String, Image> imagenes;

	static {
		imagenes = new HashMap<String, Image>();
	}

	public static Image getImagen(String nombreImagen) {
		return imagenes.get(nombreImagen);
	}

	public static ImageView getImageView(String nombreImagen) {
		return new ImageView(imagenes.get(nombreImagen));
	}

	public static void cargarImagenes() {
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
