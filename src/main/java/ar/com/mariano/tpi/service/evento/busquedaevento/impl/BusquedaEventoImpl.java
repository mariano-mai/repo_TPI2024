package ar.com.mariano.tpi.service.evento.busquedaevento.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.service.evento.busquedaevento.BusquedaEventoInterface;
import ar.com.mariano.tpi.service.evento.mapeoevento.impl.MapeoEventoImpl;
import ar.com.mariano.tpi.service.menu.impl.MostrarOpcionesEvento;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class BusquedaEventoImpl implements BusquedaEventoInterface{
	
	public static BusquedaEventoInterface buscaEventos = new BusquedaEventoImpl();

	@Override
	public Evento buscarEvento() {
		return buscarEvento(MapeoEventoImpl.eventos);
		
	}

	private Evento buscarEvento(Map<UUID, Evento> eventos) {
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

}
