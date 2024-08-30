package ar.com.mariano.tpi.service.chef.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ar.com.mariano.tpi.domain.Chef;
import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.service.chef.ChefService;
import ar.com.mariano.tpi.service.listado.impl.ListadoYBusquedaImpl;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class ChefServiceImpl implements ChefService{
	
	public static ChefService chef = new ChefServiceImpl();
	
	Chef nuevoChef;

	@Override
	public Chef crearChef() {
		nuevoChef = new Chef();
		nuevoChef.setIdChef(UUID.randomUUID());
		System.out.println("NOMBRE DEL CHEF: ");
		nuevoChef.setNombre(ScannerServiceImpl.scannerService.entradaDeTexto());
		System.out.println("ESPECIALIDAD DEL CHEF: ");
		nuevoChef.setEspecialidad(ScannerServiceImpl.scannerService.entradaDeTexto());
		System.out.println("EVENTOS EN LOS QUE PARTICIPA: ");
		nuevoChef.setEventos(listarEventos());
		ListadoYBusquedaImpl.listado.mapearChef(nuevoChef);
		System.out.println("Chef añadido con éxito.");
		System.out.println(nuevoChef.toString());
		mostrarEventos(nuevoChef);
		return nuevoChef;
	}

	@Override
	public void asignar(Chef chef) {
		Evento evento = ListadoYBusquedaImpl.listado.buscarEvento(ListadoYBusquedaImpl.listado.getEventos());
		evento.setChefACargo(chef);
		System.out.println("El chef "+chef.getNombre()+" se asignó correctamente al evento "+evento.getNombre()+".");
	}
	
	private List<Evento> listarEventos(){
		List<Evento> listaTemp = new ArrayList<>();
		int opcion;
		do{
			System.out.println("¿Desea agregar un evento?\n1- SI.\n2- NO.");
			opcion = ScannerServiceImpl.scannerService.entradaDeNumero();
			switch(opcion) {
			case 1:
				Evento nuevoEvento = ListadoYBusquedaImpl.listado.buscarEvento(ListadoYBusquedaImpl.listado.getEventos());
				listaTemp.add(nuevoEvento);
				nuevoEvento.setChefACargo(nuevoChef);
				break;
			default:
			}
		}while(opcion !=2);
		
		return listaTemp;
	}
	
	private void mostrarEventos(Chef chef) {
		System.out.println("Eventos en los que participa:");
		for(Evento evento : chef.getEventos()) {
			System.out.println("- "+evento.getNombre()+"("+evento.getFechaYHora().getDayOfMonth()+"/"+evento.getFechaYHora().getMonthValue()+"/"+evento.getFechaYHora().getYear()+")");
		}
	}

}
