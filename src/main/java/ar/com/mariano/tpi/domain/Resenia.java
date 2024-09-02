package ar.com.mariano.tpi.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Resenia {
	
	private UUID idResenia;
	private Evento evento;
	private Participante participante;
	private Double calificacion;
	private String comentario;
	private List<Integer> puntos = new ArrayList<>();
	
	public Resenia() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<Integer> getPuntos() {
		return puntos;
	}

	public void setPuntos(List<Integer> puntos) {
		this.puntos = puntos;
	}
	
	@Override
	public String toString() {
		StringBuilder strB = new StringBuilder();
		return strB.append("PARTICIPANTE: ").append(this.participante.getApellido()+", "+this.participante.getNombre())
				   .append("CALIFICACIÓN: ").append(this.calificacion)
				   .append("COMENTARIO: ").append(this.comentario)
				   .toString();
	}

}
