package ar.com.mariano.tpi.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Chef {
	
	private UUID idChef;
	private String nombre;
	private String especialidad;
	private List<Evento> eventos = new ArrayList<>();
	
	public Chef() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chef(UUID idChef, String nombre, String especialidad, List<Evento> eventos) {
		super();
		this.idChef = idChef;
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.eventos = eventos;
	}

	public UUID getIdChef() {
		return idChef;
	}

	public void setIdChef(UUID idChef) {
		this.idChef = idChef;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	@Override
	public String toString() {
		StringBuilder strB = new StringBuilder();
		return strB.append("NOMBRE: ").append(this.getNombre())
				   .append("\nESPECIALIDAD: ").append(this.getEspecialidad())
				   .toString();
	}
	

}
