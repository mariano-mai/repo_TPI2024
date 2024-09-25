package ar.com.mariano.tpi.service.menu.impl;

import ar.com.mariano.tpi.service.evento.busquedaevento.impl.BusquedaEventoImpl;
import ar.com.mariano.tpi.service.evento.impl.EventoServiceImpl;
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
					EventoServiceImpl.eventoService.modificarEvento();
					//EventoServiceImpl.eventoService.modificarEvento(BusquedaInterfaceImpl.busca.buscarEvento(MapeoInterfaceImpl.getEventos()));
					break;
				case 3:
					System.out.println(BusquedaEventoImpl.buscaEventos.buscarEvento().toString());
					//System.out.println(BusquedaInterfaceImpl.busca.buscarEvento(MapeoInterfaceImpl.getEventos()).toString());
					break;
				default:
			}
		}while(opcion != 0);
		MenuServiceImpl.menu.mostrarMenu();
	}

}
