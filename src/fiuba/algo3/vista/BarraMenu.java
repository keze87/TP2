package src.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.Juego;

public class BarraMenu extends MenuBar {

	Juego juego;

	public BarraMenu(Stage stage, Juego juego) {
		super();

		this.juego = juego;

		Menu menuArchivo = this.menuArchivo(stage);
		Menu menuVista = this.menuVista(stage);

		this.getMenus().addAll(menuArchivo, menuVista);
	}

	private Menu menuArchivo(Stage stage) {

		Menu menuArchivo = new Menu("Archivo");

		MenuItem salir = new MenuItem("Salir");

		salir.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.exit(0);

			}

		});

		MenuItem reiniciar = new MenuItem("Reiniciar");

		reiniciar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				juego = new Juego();

				stage.setScene(new MenuPrincipal(stage, juego));

			}

		});

		menuArchivo.getItems().addAll(reiniciar, salir);

		return menuArchivo;

	}

	private Menu menuVista(Stage stage) {

		Menu menuVista = new Menu("Vista");

		MenuItem pantallaCompleta = new MenuItem("Pantalla completa");
		MenuItem pantallaNormal = new MenuItem("Pantalla normal");

		eventoPantallaCompleta(pantallaCompleta, stage, pantallaNormal);
		eventoPantallaNormal(pantallaNormal, stage, pantallaCompleta);

		menuVista.getItems().addAll(pantallaCompleta, pantallaNormal);

		menuVista.setOnShowing(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				setDisposicionPantallaInicial(stage, pantallaCompleta, pantallaNormal);

			}

		});

		return menuVista;

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
			pantallaNormal.setDisable(false);
		}
		else{
			pantallaCompleta.setDisable(false);
			pantallaNormal.setDisable(true);
		}

	}

}
