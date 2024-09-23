package ar.com.mariano.tpi.service.archivos.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriter;

import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.service.archivos.ArchivosGastronomia;

public class ArchivosGastronomiaImpl implements ArchivosGastronomia{
	
	public static ArchivosGastronomia archivo = new ArchivosGastronomiaImpl();

	@Override
	public void exportarArchivos(List<Evento> eventos) {
		final String ruta1 = "\\src\\main\\java\\ar\\com\\mariano\\tpi\\recursos\\";
		String ruta = System.getProperty("user.dir").concat(ruta1).concat("archivoEventos.csv");
		
		try(CSVWriter csvWriter = new CSVWriter(new FileWriter(ruta))){
			String[] encabezado = {"ID", "NOMBRE", "CHEF A CARGO", "UBICACIÓN"};
			csvWriter.writeNext(encabezado);
			for(Evento evento : eventos) {
				String[] datos = {
						evento.getIdEvento().toString(),
						evento.getNombre().toString(),
						//evento.getChefACargo().getNombre(),
						"nadie",
						evento.getUbicacion()
				};
				csvWriter.writeNext(datos);
			}
			//csvWriter.close();
			System.out.println("Exportación exitosa.");
		}catch(IOException e) {
			System.out.println("Algo salió mal, motivo: "+e.getMessage().concat("Ubicación del archivo: "+ruta));
		}
		
	}

}
