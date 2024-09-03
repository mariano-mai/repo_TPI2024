package ar.com.mariano.tpi.service.listado.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import ar.com.mariano.tpi.domain.Chef;
import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.domain.Participante;
import ar.com.mariano.tpi.domain.Resenia;
import ar.com.mariano.tpi.service.listado.ListadoYBusqueda;
import ar.com.mariano.tpi.service.menu.impl.MostrarOpcionesChef;
import ar.com.mariano.tpi.service.menu.impl.MostrarOpcionesEvento;
import ar.com.mariano.tpi.service.menu.impl.MostrarOpcionesParticipantes;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class ListadoYBusquedaImpl implements ListadoYBusqueda{
	
	public static ListadoYBusquedaImpl listado = new ListadoYBusquedaImpl();
	
	private Map<UUID, Participante> participantes = new HashMap<>();
	private Map<UUID, Evento> eventos = new HashMap<>();
	private Map<UUID, Chef> chefs = new HashMap<>();
	Resenia resenia;

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
		System.out.println("\nSelección del Evento");
		System.out.println("Ingrese primer letra del nombre del evento: ");
		String letra = ScannerServiceImpl.scannerService.entradaDeTexto().toUpperCase();
		int i = 1;
		for(Map.Entry<UUID, Evento> evento : eventos.entrySet()) {
			if(evento.getValue().getNombre().startsWith(letra)) {
				mapaTemporal.put(i, evento.getValue());
				i++;
			}
		}
		if(i != 1) {
			System.out.println("Seleccione el evento: ");
			for(Map.Entry<Integer, Evento> evento : mapaTemporal.entrySet()) {
				System.out.println(evento.getKey()+"- "+evento.getValue().getNombre()+"_("+evento.getValue().getCapacidad()+" lugares disponibles)");
			}
			
		}else if(i == 1){
			System.out.println("No se encontraron coincidencias.");
			MostrarOpcionesEvento.opcionesEvento.mostrarOpciones();
		}
		int valor = ScannerServiceImpl.scannerService.entradaDeNumero();
		eventoSeleccionado = mapaTemporal.get(valor);
		return eventoSeleccionado;
	}

	@Override
	public void gestionarEvento(Evento evento) {
		evento.setFechaYHora(hora());	
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

	public Map<UUID, Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Map<UUID, Participante> participantes) {
		this.participantes = participantes;
	}

	public Map<UUID, Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Map<UUID, Evento> eventos) {
		this.eventos = eventos;
	}

	public Map<UUID, Chef> getChefs() {
		return chefs;
	}

	public void setChefs(Map<UUID, Chef> chefs) {
		this.chefs = chefs;
	}

	@Override
	public Participante buscarParticipante(Map<UUID, Participante> participantes) {
		Map<Integer, Participante> mapaTemporal = new HashMap<>();
		Participante parti = new Participante();
		System.out.println("\nSelección del Participante");
		System.out.println("Ingrese primer letra del apellido del participante: ");
		String letra = ScannerServiceImpl.scannerService.entradaDeTexto().toUpperCase();
		int i = 1;
		for(Map.Entry<UUID, Participante> participante : participantes.entrySet()) {
			if(participante.getValue().getApellido().startsWith(letra)) {
				mapaTemporal.put(i, participante.getValue());
				i++;
			}
		}
		if(i != 1) {
			System.out.println("Seleccione el participante: ");
			for(Map.Entry<Integer, Participante> participante : mapaTemporal.entrySet()) {
				System.out.println(participante.getKey()+"- "+participante.getValue().getApellido()+", "+participante.getValue().getNombre());
			}
			
		}else if(i == 1){
			System.out.println("No se encontraron coincidencias.");
			MostrarOpcionesParticipantes.opcParticipantes.mostrarOpciones();
		}
		int valor = ScannerServiceImpl.scannerService.entradaDeNumero();
		parti = mapaTemporal.get(valor);
		return parti;
	}

	@Override
	public Chef buscarChef(Map<UUID, Chef> chefs) {
		Map<Integer, Chef> mapaTemporal = new HashMap<>();
		Chef chef = new Chef();
		System.out.println("\nSelección del Chef");
		System.out.println("Ingrese primer letra del nombre del chef: ");
		String letra = ScannerServiceImpl.scannerService.entradaDeTexto().toUpperCase();
		int i = 1;
		for(Map.Entry<UUID, Chef> cheff : chefs.entrySet()) {
			if(cheff.getValue().getNombre().startsWith(letra)) {
				mapaTemporal.put(i, cheff.getValue());
				i++;
			}
		}
		if(i != 1) {
			System.out.println("Seleccione el chef: ");
			for(Map.Entry<Integer, Chef> cheff : mapaTemporal.entrySet()) {
				System.out.println(cheff.getKey()+"- "+cheff.getValue().getNombre());
			}
			
		}else if(i == 1){
			System.out.println("No se encontraron coincidencias.");
			MostrarOpcionesChef.opcChef.mostrarOpciones();
		}
		int valor = ScannerServiceImpl.scannerService.entradaDeNumero();
		chef = mapaTemporal.get(valor);
		return chef;
	}

	@Override
	public Resenia buscarResenia(Evento evento) {
		
		List<Resenia> listaOpiniones = new ArrayList<>();
		Participante participante1 = ListadoYBusquedaImpl.listado.buscarParticipante(participantes);
		for(Resenia resenia1 : evento.getResenias()) {
			listaOpiniones.add(resenia1);
			
		}
		for(Resenia res2 : listaOpiniones) {
			if(res2.getParticipante().equals(participante1)) {
				resenia = res2;
			}
		}
		return resenia;
	}
	
	
	
}
