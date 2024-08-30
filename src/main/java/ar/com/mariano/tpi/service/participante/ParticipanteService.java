package ar.com.mariano.tpi.service.participante;

import ar.com.mariano.tpi.domain.Participante;

public interface ParticipanteService {
	
	Participante crearParticipante();
	
	void inscribir();
	
	void remover(Participante participante);

}
