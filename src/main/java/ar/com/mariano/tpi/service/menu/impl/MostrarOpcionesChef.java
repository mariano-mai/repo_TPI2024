package ar.com.mariano.tpi.service.menu.impl;

import ar.com.mariano.tpi.bootstrap.impl.BootstrapDataImpl;
import ar.com.mariano.tpi.service.chef.impl.ChefServiceImpl;
import ar.com.mariano.tpi.service.menu.MostrarOpciones;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class MostrarOpcionesChef implements MostrarOpciones{
	
	public static MostrarOpciones opcChef = new MostrarOpcionesChef();

	@Override
	public void mostrarOpciones() {
		int opcion;
		do {
			System.out.println("\nGESTIÓN DE PARTICIPANTES\n¿Qué desea hacer?");
			System.out.println("1- Agregar Chef\n2- Asignar chef a evento.\n3- Generar chef aleatorio.\n0- Nada, salir de este menú.\n");
			opcion = ScannerServiceImpl.scannerService.entradaDeNumero();
			switch(opcion) {
				case 1:
					ChefServiceImpl.chef.crearChef();
					break;
				case 2:
					ChefServiceImpl.chef.asignarChefAEvento();
					break;
				case 3:
					BootstrapDataImpl.bootStrap.crearChefBD();
					break;
				default:
			}
		}while(opcion != 0);
		MenuServiceImpl.menu.mostrarMenu();
		
	}

}
