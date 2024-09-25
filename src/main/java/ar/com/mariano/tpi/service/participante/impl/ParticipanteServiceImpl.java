package ar.com.mariano.tpi.service.participante.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.domain.Participante;
import ar.com.mariano.tpi.service.evento.busquedaevento.BusquedaEventoInterface;
import ar.com.mariano.tpi.service.evento.busquedaevento.impl.BusquedaEventoImpl;
import ar.com.mariano.tpi.service.participante.ParticipanteService;
import ar.com.mariano.tpi.service.participante.busquedaparticipante.BusquedaParticipanteInterface;
import ar.com.mariano.tpi.service.participante.busquedaparticipante.impl.BusquedaParticipanteImpl;
import ar.com.mariano.tpi.service.participante.mapeoparticipante.MapeoParticipanteInterface;
import ar.com.mariano.tpi.service.participante.mapeoparticipante.impl.MapeoParticipanteImpl;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class ParticipanteServiceImpl implements ParticipanteService{
	
	Participante nuevoPart;
	Evento nuevoEvento;
	BusquedaParticipanteInterface buscarParti = new BusquedaParticipanteImpl();
	BusquedaEventoInterface buscarEvento = new BusquedaEventoImpl();
	MapeoParticipanteInterface mapearParti = new MapeoParticipanteImpl();
	
	public static ParticipanteService parti = new ParticipanteServiceImpl();
	
	@Override
	public Participante crearParticipante() {
		nuevoPart = new Participante();
		nuevoPart.setIdParticipante(UUID.randomUUID());
		System.out.println("NOMBRE DEL PARTICIPANTE: ");
		nuevoPart.setNombre(ScannerServiceImpl.scannerService.entradaDeTexto());
		System.out.println("APELLIDO DEL PARTICIPANTE: ");
		nuevoPart.setApellido(ScannerServiceImpl.scannerService.entradaDeTexto());
		System.out.println("INTERESES CULINARIOS: ");
		nuevoPart.setInteresesCulinarios(ScannerServiceImpl.scannerService.entradaDeTexto());
		System.out.println("HISTORIAL DE EVENTOS");
		nuevoPart.setHistorialEventos(listarEventos());
		mapearParti.mapearParticipante(nuevoPart);
		//ListadoYBusquedaImpl.listado.mapearParticipante(nuevoPart);
		return nuevoPart;
	}

	@Override
	public void inscribir() {
		nuevoPart = buscarParti.buscarParticipante();
		//nuevoPart = BusquedaInterfaceImpl.busca.buscarParticipante(MapeoInterfaceImpl.getParticipantes());
		nuevoEvento = buscarEvento.buscarEvento();
		//nuevoEvento = BusquedaInterfaceImpl.busca.buscarEvento(MapeoInterfaceImpl.getEventos());
		//Participante nuevoPart = ListadoYBusquedaImpl.listado.buscarParticipante(ListadoYBusquedaImpl.listado.getParticipantes());
		//Evento nuevoEvento = ListadoYBusquedaImpl.listado.buscarEvento(ListadoYBusquedaImpl.listado.getEventos());
		if(nuevoEvento.getCapacidad()==0) {
			System.out.println("Evento lleno.\nNo se pudo inscribir al participante.");
		}else {
			nuevoEvento.getParticipante().add(nuevoPart);
			int i = nuevoEvento.getCapacidad()-1;
			nuevoEvento.setCapacidad(i);
			System.out.println(nuevoPart.toString());
			System.out.println("Participante registrado con éxito.\nCapacidad actual del evento: "+nuevoEvento.getCapacidad());
		}
		
	}

	@Override
	public void remover() {
		removerParticipante(buscarParti.buscarParticipante());
		
	}
	
	private void removerParticipante(Participante participante) {
		MapeoParticipanteImpl.participantes.remove(participante.getIdParticipante());
		//ListadoYBusquedaImpl.listado.getParticipantes().remove(participante.getIdParticipante());
		System.out.println("Participante removido con éxito.");
	}
	
	private List<Evento> listarEventos(){
		List<Evento> listaTemp = new ArrayList<>();
		int opcion;
		do{
			System.out.println("¿Desea agregar un evento al historial?\n1- SI.\n2- NO.");
			opcion = ScannerServiceImpl.scannerService.entradaDeNumero();
			switch(opcion) {
			case 1:
				listaTemp.add(BusquedaEventoImpl.buscaEventos.buscarEvento());
				//listaTemp.add(ListadoYBusquedaImpl.listado.buscarEvento(ListadoYBusquedaImpl.listado.getEventos()));
				break;
			default:
			}
		}while(opcion !=2);
		
		return listaTemp;
	}
	

	
	

}
