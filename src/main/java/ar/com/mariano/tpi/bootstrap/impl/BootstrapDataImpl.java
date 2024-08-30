package ar.com.mariano.tpi.bootstrap.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ar.com.mariano.tpi.bootstrap.BootstrapData;
import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.domain.Participante;
import ar.com.mariano.tpi.service.listado.impl.ListadoYBusquedaImpl;

public class BootstrapDataImpl implements BootstrapData{
	
	public static BootstrapData bootStrap = new BootstrapDataImpl();
	
	Evento nuevoEvento;
	
	Participante nuevoParticipante;
	
	List<Evento> eventos = new ArrayList<>();

	@Override
	public void crearEventoBD() {
		for(int i=0; i<20; i++) {
			nuevoEvento = new Evento();
			nuevoEvento.setIdEvento(UUID.randomUUID());
			nuevoEvento.setCapacidad(getRandomNumber(2, 20));
			nuevoEvento.setNombre(generarNombre(nuevoEvento.getCapacidad()));
			nuevoEvento.setFechaYHora(hora());
			nuevoEvento.setUbicacion(generarDireccion());
			nuevoEvento.setDescripcion("descripción de este evento");
			ListadoYBusquedaImpl.listado.mapearEvento(nuevoEvento);
			eventos.add(nuevoEvento);
		}
		
	}

	@Override
	public void setearEventoBD() {
		// TODO Auto-generated method stub
		
	}
	
	private String generarNombre(int capacidad) {
		String nombre = BootstrapData.NOMBRES[getRandomNumber(0, 80)]+"_evento";
		return nombre+"_"+"("+capacidad+")";
	}
	
	private int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	private LocalDateTime hora() {
		int dia = getRandomNumber(1, 28);
		int mes = getRandomNumber(1, 12);
		int anio = getRandomNumber(1990, 2025);
		int hora = getRandomNumber(9, 19);
		int minutos = getRandomNumber(0, 12)*5;
		LocalDateTime horario = LocalDateTime.of(anio, mes, dia, hora, minutos);
		return horario;
	}
	
	private String generarDireccion() {
		String dir, camino = "";
		int altura;
		int valor;
		dir = BootstrapData.APELLIDOS[getRandomNumber(0, 90)];
		altura = getRandomNumber(1, 90)*10;
		valor = getRandomNumber(1, 10);
		if(valor % 2 == 0) {
			camino = "Av. ";
		}
		return camino+dir+" "+altura;
	}

	@Override
	public Participante crearParticipanteBD() {
		nuevoParticipante = new Participante();
		nuevoParticipante.setIdParticipante(UUID.randomUUID());
		nuevoParticipante.setNombre(BootstrapData.NOMBRES[getRandomNumber(0, 90)]);
		nuevoParticipante.setApellido(BootstrapData.APELLIDOS[getRandomNumber(0, 90)]);
		nuevoParticipante.setInteresesCulinarios("a este bot le interesa cocinar");
		nuevoParticipante.setHistorialEventos(listarEventos());
		ListadoYBusquedaImpl.listado.mapearParticipante(nuevoParticipante);
		System.out.println(nuevoParticipante.toString());
		return nuevoParticipante;
	}
	
	private List<Evento> listarEventos(){
		List<Evento> eventos2 = new ArrayList<>();
		for(Evento evento : eventos) {
			int i = getRandomNumber(1, 10);
			if(i%2==0) {
				eventos2.add(evento);
			}
		}
		return eventos2;
	}

}
