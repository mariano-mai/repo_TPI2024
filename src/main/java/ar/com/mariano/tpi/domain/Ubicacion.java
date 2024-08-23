package ar.com.mariano.tpi.domain;

import ar.com.mariano.tpi.enumerators.Provincias;
import ar.com.mariano.tpi.enumerators.TipoCamino;

public class Ubicacion {
	
	private Provincias provincia;
	private String ciudad;
	private TipoCamino tipoCamino;
	private String nombreCamino;
	private int altura;
	private String otros;
	
	public Ubicacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ubicacion(Provincias provincia, String ciudad, TipoCamino tipoCamino, String nombreCamino, int altura) {
		super();
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.tipoCamino = tipoCamino;
		this.nombreCamino = nombreCamino;
		this.altura = altura;
	}

	public Provincias getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincias provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public TipoCamino getTipoCamino() {
		return tipoCamino;
	}

	public void setTipoCamino(TipoCamino tipoCamino) {
		this.tipoCamino = tipoCamino;
	}

	public String getNombreCamino() {
		return nombreCamino;
	}

	public void setNombreCamino(String nombreCamino) {
		this.nombreCamino = nombreCamino;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}
	

}
