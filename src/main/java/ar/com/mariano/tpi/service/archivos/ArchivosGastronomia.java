package ar.com.mariano.tpi.service.archivos;

import java.util.List;

import ar.com.mariano.tpi.domain.Evento;

public interface ArchivosGastronomia {
	
	void exportarArchivos(List<Evento> eventos);

}
