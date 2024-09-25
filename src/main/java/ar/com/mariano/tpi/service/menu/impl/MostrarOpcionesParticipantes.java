package ar.com.mariano.tpi.service.menu.impl;

import ar.com.mariano.tpi.bootstrap.impl.BootstrapDataImpl;
import ar.com.mariano.tpi.service.menu.MostrarOpciones;
import ar.com.mariano.tpi.service.participante.ParticipanteService;
import ar.com.mariano.tpi.service.participante.impl.ParticipanteServiceImpl;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class MostrarOpcionesParticipantes implements MostrarOpciones {
	
	public static MostrarOpciones opcParticipantes = new MostrarOpcionesParticipantes();
	ParticipanteService partiServ = new ParticipanteServiceImpl();

	@Override
	public void mostrarOpciones() {
		int opcion;
		do {
			System.out.println("\nGESTIÓN DE PARTICIPANTES\n¿Qué desea hacer?");
			System.out.println("1- Agregar Participante\n2- Inscribir Participante.\n3- Generar participante aleatorio.\n4- Remover participante.\n0- Nada, salir de este menú.\n");
			opcion = ScannerServiceImpl.scannerService.entradaDeNumero();
			switch(opcion) {
				case 1:
					partiServ.crearParticipante();
					break;
				case 2:
					partiServ.inscribir();
					break;
				case 3:
					BootstrapDataImpl.bootStrap.crearParticipanteBD();
					break;
				case 4:
					partiServ.remover();
					//partiServ.remover(ListadoYBusquedaImpl.listado.buscarParticipante(ListadoYBusquedaImpl.listado.getParticipantes()));
					break;
				default:
			}
		}while(opcion != 0);
		MenuServiceImpl.menu.mostrarMenu();
	}

}
