package ar.com.mariano.tpi.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Participante {
	
	private UUID idParticipante;
	private String nombre;
	private String apellido;
	private String interesesCulinarios;
	private List<Evento> historialEventos = new ArrayList<>();
	
	public Participante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Participante(UUID idParticipante, String nombre, String apellido,
			String interesesCulinarios, List<Evento> historialEventos) {
		super();
		this.idParticipante = idParticipante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.interesesCulinarios = interesesCulinarios;
		this.historialEventos = historialEventos;
	}

	public UUID getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(UUID idParticipante) {
		this.idParticipante = idParticipante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getInteresesCulinarios() {
		return interesesCulinarios;
	}

	public void setInteresesCulinarios(String interesesCulinarios) {
		this.interesesCulinarios = interesesCulinarios;
	}

	public List<Evento> getHistorialEventos() {
		return historialEventos;
	}

	public void setHistorialEventos(List<Evento> historialEventos) {
		this.historialEventos = historialEventos;
	}
	
	@Override
	public String toString() {
		StringBuilder strB = new StringBuilder();
		return strB.append("NOMBRE: ").append(this.getNombre())
				   .append("\nAPELLIDO: ").append(this.getApellido())
				   .append("\nINTERÉS: ").append(this.getInteresesCulinarios())
				   .toString();
	}

}
