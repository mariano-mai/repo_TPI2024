package ar.com.mariano.tpi.service.menu.impl;

import ar.com.mariano.tpi.service.evento.impl.EventoServiceImpl;
import ar.com.mariano.tpi.service.listado.impl.ListadoYBusquedaImpl;
import ar.com.mariano.tpi.service.menu.MostrarOpciones;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class MostrarOpcionesEvento implements MostrarOpciones{
	
	public static MostrarOpciones opcionesEvento = new MostrarOpcionesEvento();

	@Override
	public void mostrarOpciones() {
		int opcion;
		do {
			System.out.println("\nGESTIÓN DE EVENTOS\n¿Qué desea hacer?");
			System.out.println("1- Crear Evento\n2- Cambiar fecha y horario de un evento.\n3- Ver información de un evento.\n0- Nada, salir de este menú.\n");
			opcion = ScannerServiceImpl.scannerService.entradaDeNumero();
			switch(opcion) {
				case 1:
					EventoServiceImpl.eventoService.crearEvento();
					break;
				case 2:
					ListadoYBusquedaImpl.listado.gestionarEvento(ListadoYBusquedaImpl.listado.buscarEvento(ListadoYBusquedaImpl.listado.getEventos()));
					break;
				case 3:
					System.out.println(ListadoYBusquedaImpl.listado.buscarEvento(ListadoYBusquedaImpl.listado.getEventos()).toString());
					break;
				default:
			}
		}while(opcion != 0);
		MenuServiceImpl.menu.mostrarMenu();
	}

}
