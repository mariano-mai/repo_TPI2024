package ar.com.mariano.tpi.service.listado.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import ar.com.mariano.tpi.domain.Chef;
import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.domain.Participante;
import ar.com.mariano.tpi.service.listado.ListadoYBusqueda;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class ListadoYBusquedaImpl implements ListadoYBusqueda{
	
	public static ListadoYBusquedaImpl listado = new ListadoYBusquedaImpl();
	
	private Map<UUID, Participante> participantes = new HashMap<>();
	private Map<UUID, Evento> eventos = new HashMap<>();
	private Map<UUID, Chef> chefs = new HashMap<>();

	@Override
	public void mapearParticipante(Participante participante) {
		participantes.put(participante.getIdParticipante(), participante);
		
	}

	@Override
	public void mapearChef(Chef chef) {
		chefs.put(chef.getIdChef(), chef);
		
	}

	@Override
	public void mapearEvento(Evento evento) {
		eventos.put(evento.getIdEvento(), evento);
		
	}

	@Override
	public Evento buscarEvento(Map<UUID, Evento> eventos) {
		Map<Integer, Evento> mapaTemporal = new HashMap<>();
		Evento eventoSeleccionado = new Evento();
		System.out.println("Ingrese primer letra del nombre del evento: ");
		String letra = ScannerServiceImpl.scannerService.entradaDeTexto();
		int i = 1;
		for(Map.Entry<UUID, Evento> evento : eventos.entrySet()) {
			if(evento.getValue().getNombre().startsWith(letra)) {
				mapaTemporal.put(i, evento.getValue());
				i++;
			}
		}
		if(i == 1) {
			System.out.println("No se encontraron coincidencias.");
		}else {
			System.out.println("Seleccione el evento: ");
			for(Map.Entry<Integer, Evento> evento : mapaTemporal.entrySet()) {
				System.out.println(evento.getKey()+"- "+evento.getValue().getNombre());
			}
		}
		int valor = ScannerServiceImpl.scannerService.entradaDeNumero();
		eventoSeleccionado = mapaTemporal.get(valor);
		return eventoSeleccionado;
	}

	@Override
	public void gestionarEvento(Evento evento) {
		int opcion;
		do {
			System.out.println("¿Qué desea hacer?");
			System.out.println("1- Cambiar horario.\n2- Ver información.\n0- Salir de este menú.");
			opcion = ScannerServiceImpl.scannerService.entradaDeNumero();
			switch(opcion) {
				case 1:
					evento.setFechaYHora(hora());
					break;
				case 2:
					evento.toString();
					break;
				default:
			}
		}while (opcion != 0);
		
	}
	
	private LocalDateTime hora() {
		System.out.println("INGRESE NÚMERO DE DÍA: ");
		int dia = ScannerServiceImpl.scannerService.entradaDeNumero();
		System.out.println("INGRESE NÚMERO DE MES: ");
		int mes = ScannerServiceImpl.scannerService.entradaDeNumero();
		System.out.println("INGRESE AÑO: ");
		int anio = ScannerServiceImpl.scannerService.entradaDeNumero();
		System.out.println("INGRESE HORARIO DEL EVENTO: <00>:00");
		int hora = ScannerServiceImpl.scannerService.entradaDeNumero();
		System.out.println("INGRESE HORARIO DEL EVENTO: "+hora+":<00>");
		int minutos = ScannerServiceImpl.scannerService.entradaDeNumero();
		LocalDateTime horario = LocalDateTime.of(anio, mes, dia, hora, minutos);
		return horario;
	}

	
}
