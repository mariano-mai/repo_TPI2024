package ar.com.mariano.tpi.service.evento.mapeoevento.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.service.evento.mapeoevento.MapeoEventoInterface;

public class MapeoEventoImpl implements MapeoEventoInterface{
	
	public static Map<UUID, Evento> eventos = new HashMap<>();

	@Override
	public void mapearEvento(Evento evento) {
		eventos.put(evento.getIdEvento(), evento);
		
	}

}
