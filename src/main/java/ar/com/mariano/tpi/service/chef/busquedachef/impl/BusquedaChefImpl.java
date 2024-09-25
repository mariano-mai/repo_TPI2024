package ar.com.mariano.tpi.service.chef.busquedachef.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import ar.com.mariano.tpi.domain.Chef;
import ar.com.mariano.tpi.service.chef.busquedachef.BusquedaChefInterface;
import ar.com.mariano.tpi.service.chef.mapeochef.impl.MapeoChefImpl;
import ar.com.mariano.tpi.service.menu.impl.MostrarOpcionesChef;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class BusquedaChefImpl implements BusquedaChefInterface{

	@Override
	public Chef buscarChef() {
		return buscarChef(MapeoChefImpl.chefs);
	}
	
	private Chef buscarChef(Map<UUID, Chef> chefs) {
		Map<Integer, Chef> mapaTemporal = new HashMap<>();
		Chef chef = new Chef();
		System.out.println("\nSelección del Chef");
		System.out.println("Ingrese primer letra del nombre del chef: ");
		String letra = ScannerServiceImpl.scannerService.entradaDeTexto().toUpperCase();
		int i = 1;
		for(Map.Entry<UUID, Chef> cheff : chefs.entrySet()) {
			if(cheff.getValue().getNombre().startsWith(letra)) {
				mapaTemporal.put(i, cheff.getValue());
				i++;
			}
		}
		if(i != 1) {
			System.out.println("Seleccione el chef: ");
			for(Map.Entry<Integer, Chef> cheff : mapaTemporal.entrySet()) {
				System.out.println(cheff.getKey()+"- "+cheff.getValue().getNombre());
			}
			
		}else if(i == 1){
			System.out.println("No se encontraron coincidencias.");
			MostrarOpcionesChef.opcChef.mostrarOpciones();
		}
		int valor = ScannerServiceImpl.scannerService.entradaDeNumero();
		chef = mapaTemporal.get(valor);
		return chef;
	}

}
