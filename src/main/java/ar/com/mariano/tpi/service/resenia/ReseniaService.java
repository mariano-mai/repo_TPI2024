package ar.com.mariano.tpi.service.resenia;

import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.domain.Participante;

public interface ReseniaService {
	
	void escribirComentario(Participante participante, Evento evento);
	
	void editarComentario(Evento evento);
	
	void eliminarComentario(Evento evento);

}
