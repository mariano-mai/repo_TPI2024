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
			System.out.println("1- Crear Evento\n2- Opciones de Eventos Existentes.\n0- Nada, salir de este menú.\n");
			opcion = ScannerServiceImpl.scannerService.entradaDeNumero();
			switch(opcion) {
				case 1:
					EventoServiceImpl.eventoService.crearEvento();
					break;
				case 2:
					System.out.println("\nMENÚ DE GESTIÓN DE EVENTOS EXISTENTES\n");
					ListadoYBusquedaImpl.listado.gestionarEvento(ListadoYBusquedaImpl.listado.buscarEvento(ListadoYBusquedaImpl.listado.getEventos()));
					break;
				default:
			}
		}while(opcion != 0);
		
	}

}
