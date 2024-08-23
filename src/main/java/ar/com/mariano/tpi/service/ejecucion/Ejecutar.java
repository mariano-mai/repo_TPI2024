package ar.com.mariano.tpi.service.ejecucion;

import ar.com.mariano.tpi.service.menu.MenuService;
import ar.com.mariano.tpi.service.menu.impl.MenuServiceImpl;

public class Ejecutar {
	
	public static void ejecutarApp() {
		MenuService menu = new MenuServiceImpl();
        menu.mostrarMenu();
	}

}
