package ar.com.mariano.tpi.service.participante.mapeoparticipante.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import ar.com.mariano.tpi.domain.Participante;
import ar.com.mariano.tpi.service.participante.mapeoparticipante.MapeoParticipanteInterface;

public class MapeoParticipanteImpl implements MapeoParticipanteInterface{
	
	public static Map<UUID, Participante> participantes = new HashMap<>();

	@Override
	public void mapearParticipante(Participante participante) {
		participantes.put(participante.getIdParticipante(), participante);
		
	}

}
