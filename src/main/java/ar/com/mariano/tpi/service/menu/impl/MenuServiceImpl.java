package ar.com.mariano.tpi.service.menu.impl;



import java.util.Scanner;


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
							   "4- opcion 4.\n"+
							   "5- opcion 5.\n"+
							   "6- opcion 6.\n"+
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
					//reseñas de eventos
					break;
				case 5:
					//funcionalidades de listado
					break;
				case 6:
					//exportar archivo
					break;
				default:
			}
		}while(opcion != 0);
		System.out.println("fin de la aplicación.");
	}

}
