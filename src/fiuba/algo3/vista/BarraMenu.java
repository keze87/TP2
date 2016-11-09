package src.fiuba.algo3.vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class BarraMenu extends MenuBar {

	public BarraMenu() {

		super();

		final Menu menu1 = new Menu("Archivo");
		final Menu menu2 = new Menu("Opciones");
		final Menu menu3 = new Menu("Ayuda");

		this.getMenus().addAll(menu1, menu2, menu3);

	}

}
