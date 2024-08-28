package ar.com.mariano.tpi.service.evento.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.service.evento.EventoService;
import ar.com.mariano.tpi.service.listado.impl.ListadoYBusquedaImpl;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class EventoServiceImpl implements EventoService {
	
	public static EventoService eventoService = new EventoServiceImpl();

	@Override
	public Evento crearEvento() {
		Evento nuevoEvento = new Evento();
		nuevoEvento.setIdEvento(UUID.randomUUID());
		System.out.println("NOMBRE DEL EVENTO: ");
		nuevoEvento.setNombre(ScannerServiceImpl.scannerService.entradaDeTexto().toUpperCase());
		nuevoEvento.setFechaYHora(hora());
		System.out.println("UBICACIÓN DEL EVENTO: ");
		nuevoEvento.setUbicacion(ScannerServiceImpl.scannerService.entradaDeTexto());
		System.out.println("DESCRIPCIÓN DEL EVENTO: ");
		nuevoEvento.setDescripcion(ScannerServiceImpl.scannerService.entradaDeTexto());
		System.out.println("CANTIDAD DE PARTICIPANTES: ");
		nuevoEvento.setCapacidad(ScannerServiceImpl.scannerService.entradaDeNumero());
		ListadoYBusquedaImpl.listado.mapearEvento(nuevoEvento);
		System.out.println("evento "+nuevoEvento.getNombre()+ " creado por éxito.");
		System.out.println("será el día "+nuevoEvento.getFechaYHora().getDayOfMonth()+" de "+nuevoEvento.getFechaYHora().getMonth());
		System.out.println("a las "+nuevoEvento.getFechaYHora().getHour()+":"+nuevoEvento.getFechaYHora().getMinute());
		return nuevoEvento;
	}

	@Override
	public void modificarEvento() {
		// TODO Auto-generated method stub
		
	}
	
	private LocalDateTime hora() {
		System.out.println("INGRESE NÚMERO DE DÍA: ");
		int dia = ScannerServiceImpl.scannerService.entradaDeNumero();
		System.out.println("INGRESE NÚMERO DE MES: ");
		int mes = ScannerServiceImpl.scannerService.entradaDeNumero();
		System.out.println("INGRESE AÑO: ");
		int anio = ScannerServiceImpl.scannerService.entradaDeNumero();
		System.out.println("INGRESE HORARIO DEL EVENTO: <00>:00");
		int hora = ScannerServiceImpl.scannerService.entradaDeNumero();
		System.out.println("INGRESE HORARIO DEL EVENTO: "+hora+":<00>");
		int minutos = ScannerServiceImpl.scannerService.entradaDeNumero();
		LocalDateTime horario = LocalDateTime.of(anio, mes, dia, hora, minutos);
		return horario;
	}

}
