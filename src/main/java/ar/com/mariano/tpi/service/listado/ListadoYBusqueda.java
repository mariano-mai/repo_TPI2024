package ar.com.mariano.tpi.service.listado;

import java.util.Map;
import java.util.UUID;

import ar.com.mariano.tpi.domain.Chef;
import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.domain.Participante;
import ar.com.mariano.tpi.domain.Resenia;

public interface ListadoYBusqueda {
	
	void mapearParticipante(Participante participante);
	
	void mapearChef(Chef chef);
	
	void mapearEvento(Evento evento);
	
	Evento buscarEvento(Map<UUID, Evento> eventos);
	
	void gestionarEvento(Evento evento);
	
	Participante buscarParticipante(Map<UUID, Participante> participantes);
	
	Chef buscarChef(Map<UUID, Chef> chefs);
	
	Resenia buscarResenia(Evento evento);

}
