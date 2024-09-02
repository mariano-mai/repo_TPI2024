package ar.com.mariano.tpi.service.menu.impl;

import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.domain.Participante;
import ar.com.mariano.tpi.service.listado.impl.ListadoYBusquedaImpl;
import ar.com.mariano.tpi.service.menu.MostrarOpciones;
import ar.com.mariano.tpi.service.resenia.impl.ReseniaServiceImpl;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class MostrarOpcionesResenia implements MostrarOpciones{
	
	public static MostrarOpciones opcRes = new MostrarOpcionesResenia();

	@Override
	public void mostrarOpciones() {
		int opcion;
		do {
			System.out.println("\nGESTIÓN DE RESEÑAS\n¿Qué desea hacer?");
			System.out.println("1- Escribir opinión\n2- Editar opinión.\n3- Eliminar opinión.\n0- Nada, salir de este menú.\n");
			opcion = ScannerServiceImpl.scannerService.entradaDeNumero();
			switch(opcion) {
				case 1:
					Participante nuevoPart = ListadoYBusquedaImpl.listado.buscarParticipante(ListadoYBusquedaImpl.listado.getParticipantes());
					Evento nuevoEvent = ListadoYBusquedaImpl.listado.buscarEvento(ListadoYBusquedaImpl.listado.getEventos());
					ReseniaServiceImpl.coment.escribirComentario(nuevoPart, nuevoEvent);
					break;
				case 2:
					ReseniaServiceImpl.coment.editarComentario(ListadoYBusquedaImpl.listado.buscarEvento(ListadoYBusquedaImpl.listado.getEventos()));
					break;
				case 3:
					ReseniaServiceImpl.coment.eliminarComentario(ListadoYBusquedaImpl.listado.buscarEvento(ListadoYBusquedaImpl.listado.getEventos()));
					break;
				default:
			}
		}while(opcion != 0);
		MenuServiceImpl.menu.mostrarMenu();
		
	}

}
