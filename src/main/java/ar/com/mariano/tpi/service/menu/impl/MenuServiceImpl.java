package ar.com.mariano.tpi.service.menu.impl;



import java.util.Scanner;

import ar.com.mariano.tpi.service.archivos.impl.ArchivosGastronomiaImpl;
import ar.com.mariano.tpi.service.listado.impl.ListadoYBusquedaImpl;
import ar.com.mariano.tpi.service.listado.listado.impl.ListadoInterfaceImpl;
import ar.com.mariano.tpi.service.menu.MenuService;


public class MenuServiceImpl implements MenuService {
	
	public static MenuService menu = new MenuServiceImpl();
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void mostrarMenu() {
		int opcion;
		do {
			System.out.println("MENÚ PRINCIPAL\nElija una opción:");
			System.out.println("1- Gestionar Eventos.\n"+
							   "2- Gestionar Participantes.\n"+
							   "3- Gestionar Chefs.\n"+
							   "4- Gestionar Reseñas.\n"+
							   "5- Mostrar eventos próximos.\n"+
							   "6- Exportar Archivo.\n"+
							   "0- salir.");
			opcion = sc.nextInt();
			switch(opcion) {
				case 1:
					MostrarOpcionesEvento.opcionesEvento.mostrarOpciones();
					break;
				case 2:
					MostrarOpcionesParticipantes.opcParticipantes.mostrarOpciones();
					break;
				case 3:
					MostrarOpcionesChef.opcChef.mostrarOpciones();
					break;
				case 4:
					MostrarOpcionesResenia.opcRes.mostrarOpciones();
					break;
				case 5:
					System.out.println("Próximos eventos:");
					ListadoYBusquedaImpl.listado.listadoCronologico(ListadoYBusquedaImpl.listado.getEventos());
					break;
				case 6:
					ArchivosGastronomiaImpl.archivo.exportarArchivos(ListadoInterfaceImpl.eventos);
					break;
				default:
			}
		}while(opcion != 0);
		System.out.println("fin de la aplicación.");
	}

}
