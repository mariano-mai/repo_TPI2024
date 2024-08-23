package ar.com.mariano.tpi.service.menu.impl;



import ar.com.mariano.tpi.service.menu.MenuService;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class MenuServiceImpl implements MenuService {
	
	@Override
	public void mostrarMenu() {
		int opcion;
		do {
			System.out.println("elija opcion:");
			System.out.println("1- opcion 1.\n"+
							   "2- opcion 2.\n"+
							   "3- opcion 3.\n"+
							   "4- opcion 4.\n"+
							   "5- opcion 5.\n"+
							   "6- opcion 6.\n"+
							   "7- salir.");
			opcion = ScannerServiceImpl.scannerService.entradaDeNumero();
			switch(opcion) {
				case 1:
					//crear evento
					break;
				case 2:
					//inscribir participantes
					break;
				case 3:
					//gestión de chefs
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
		}while(opcion != 7);
		System.out.println("fin de la aplicación.");
	}

}
