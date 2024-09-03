package ar.com.mariano.tpi.service.archivos.impl;

import java.io.FileWriter;
import java.util.List;

import com.opencsv.CSVWriter;

import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.service.archivos.ArchivosGastronomia;

public class ArchivosGastronomiaImpl implements ArchivosGastronomia{

	@Override
	public void exportarArchivos(List<Evento> eventos) {
		final String ruta1 = "\\src\\main\\java\\ar\\com\\mariano\\tpi\\recursos";
		String ruta = System.getProperty("user.dir").concat(ruta1).concat("archivoEventos.csv");
		
		try(CSVWriter csvWriter = new CSVWriter(new FileWriter(ruta))){
			String[] encabezado = {
		}
		
	}

}
