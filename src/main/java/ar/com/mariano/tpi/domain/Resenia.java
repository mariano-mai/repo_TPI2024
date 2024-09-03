package ar.com.mariano.tpi.domain;

import java.util.UUID;

public class Resenia {
	
	private UUID idResenia;
	private Evento evento;
	private Participante participante;
	private String comentario;
	private int punto;
	
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getPunto() {
		return punto;
	}

	public void setPunto(int punto) {
		this.punto = punto;
	}

	@Override
	public String toString() {
		StringBuilder strB = new StringBuilder();
		return strB.append("PARTICIPANTE: ").append(this.participante.getApellido()+", "+this.participante.getNombre())
				   .append("\nCALIFICACIÓN: ").append(this.punto)
				   .append("\nCOMENTARIO: ").append(this.comentario)
				   .toString();
	}

}
