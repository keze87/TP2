package src.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraMenu extends MenuBar {

	public BarraMenu(Stage stage) {
		super();

		final Menu menuArchivo = new Menu("Archivo");
		final Menu menuOpciones = new Menu("Opciones");
		final Menu menuAyuda = new Menu("Ayuda");
		final Menu menuVista = new Menu("Vista");

		MenuItem pantallaCompleta = new MenuItem("Pantalla completa");
		MenuItem pantallaNormal = new MenuItem("Pantalla normal");

		setDisposicionPantallaInicial(stage, pantallaCompleta, pantallaNormal);

		eventoPantallaCompleta(pantallaCompleta, stage, pantallaNormal);
		eventoPantallaNormal(pantallaNormal, stage, pantallaCompleta);

		menuVista.getItems().addAll(pantallaCompleta, pantallaNormal);

		this.getMenus().addAll(menuArchivo, menuOpciones, menuVista, menuAyuda);
	}

	private void eventoPantallaNormal(MenuItem pantallaNormal, Stage stage, MenuItem pantallaCompleta) {
		pantallaNormal.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				stage.setFullScreen(false);
				pantallaNormal.setDisable(true);
				pantallaCompleta.setDisable(false);
			}
		});
	}

	private void eventoPantallaCompleta(MenuItem pantallaCompleta, Stage stage, MenuItem pantallaNormal) {
		pantallaCompleta.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				stage.setFullScreen(true);
				pantallaCompleta.setDisable(true);
				pantallaNormal.setDisable(false);
			}
		});
	}

	/*Establece si los menus items pantallaCompleta, pantallaNormal estaran
	activados/desactivados en la primera scena*/
	private void setDisposicionPantallaInicial(Stage stage,
			MenuItem pantallaCompleta, MenuItem pantallaNormal) {
		if(stage.isFullScreen()){
			pantallaCompleta.setDisable(true);
		}
		else{
			pantallaNormal.setDisable(true);
		}

	}

}
