package ar.com.mariano.tpi.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Evento {
	
	private UUID idEvento;
	private String nombre;
	private String descripcion;
	private LocalDate fechaYHora;
	private Ubicacion ubicacion;
	private int capacidad;
	private Chef chefACargo;
	private List<Resenia> resenias = new ArrayList<>();
	private List<Participante> participante = new ArrayList<>();
	
	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evento(UUID idEvento, String nombre, String descripcion, LocalDate fechaYHora, Ubicacion ubicacion,
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

	public LocalDate getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(LocalDate fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
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
	

}
