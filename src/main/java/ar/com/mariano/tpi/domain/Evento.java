package ar.com.mariano.tpi.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Evento {
	
	private UUID idEvento;
	private String nombre;
	private String descripcion;
	private LocalDateTime fechaYHora;
	private String ubicacion;
	private int capacidad;
	private Chef chefACargo;
	private List<Resenia> resenias = new ArrayList<>();
	private List<Participante> participante = new ArrayList<>();
	
	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evento(UUID idEvento, String nombre, String descripcion, LocalDateTime fechaYHora, String ubicacion,
			int capacidad, Chef chefACargo) {
		super();
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaYHora = fechaYHora;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.chefACargo = chefACargo;
	}

	public UUID getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(UUID idEvento) {
		this.idEvento = idEvento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Chef getChefACargo() {
		return chefACargo;
	}

	public void setChefACargo(Chef chefACargo) {
		this.chefACargo = chefACargo;
	}

	public List<Resenia> getResenias() {
		return resenias;
	}

	public void setResenias(List<Resenia> resenias) {
		this.resenias = resenias;
	}

	public List<Participante> getParticipante() {
		return participante;
	}

	public void setParticipante(List<Participante> participante) {
		this.participante = participante;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.append("Id: ").append(this.idEvento)
					 .append("\nNombre: ").append(this.getNombre())
					 .append("\nFecha y Hora: ").append(this.getFechaYHora().getDayOfMonth()+"/"+this.getFechaYHora().getMonth()+" - "+this.getFechaYHora().getHour()+":"+this.getFechaYHora().getMinute())
					 .append("\nDirección: ").append(this.getUbicacion())
					 .append("\nCapacidad: ").append(this.getCapacidad())
					 .toString();
	}

}
