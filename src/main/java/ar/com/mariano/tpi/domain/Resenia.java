package ar.com.mariano.tpi.domain;

import java.util.UUID;

public class Resenia {
	
	private UUID idResenia;
	private Evento evento;
	private Participante participante;
	private Double calificacion;
	private String comentario;
	
	public Resenia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resenia(UUID idResenia, Evento evento, Participante participante, Double calificacion, String comentario) {
		super();
		this.idResenia = idResenia;
		this.evento = evento;
		this.participante = participante;
		this.calificacion = calificacion;
		this.comentario = comentario;
	}

	public UUID getIdResenia() {
		return idResenia;
	}

	public void setIdResenia(UUID idResenia) {
		this.idResenia = idResenia;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	

}
