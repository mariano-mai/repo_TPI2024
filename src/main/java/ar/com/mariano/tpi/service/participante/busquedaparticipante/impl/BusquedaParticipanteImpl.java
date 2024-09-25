package ar.com.mariano.tpi.service.participante.busquedaparticipante.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import ar.com.mariano.tpi.domain.Participante;
import ar.com.mariano.tpi.service.menu.impl.MostrarOpcionesParticipantes;
import ar.com.mariano.tpi.service.participante.busquedaparticipante.BusquedaParticipanteInterface;
import ar.com.mariano.tpi.service.participante.mapeoparticipante.impl.MapeoParticipanteImpl;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class BusquedaParticipanteImpl implements BusquedaParticipanteInterface{

	@Override
	public Participante buscarParticipante() {
		return buscarParticipante(MapeoParticipanteImpl.participantes);
	}
	
	private Participante buscarParticipante(Map<UUID, Participante> participantes) {
		Map<Integer, Participante> mapaTemporal = new HashMap<>();
		Participante parti = new Participante();
		System.out.println("\nSelección del Participante");
		System.out.println("Ingrese primer letra del apellido del participante: ");
		String letra = ScannerServiceImpl.scannerService.entradaDeTexto().toUpperCase();
		int i = 1;
		for(Map.Entry<UUID, Participante> participante : participantes.entrySet()) {
			if(participante.getValue().getApellido().startsWith(letra)) {
				mapaTemporal.put(i, participante.getValue());
				i++;
			}
		}
		if(i != 1) {
			System.out.println("Seleccione el participante: ");
			for(Map.Entry<Integer, Participante> participante : mapaTemporal.entrySet()) {
				System.out.println(participante.getKey()+"- "+participante.getValue().getApellido()+", "+participante.getValue().getNombre());
			}
			
		}else if(i == 1){
			System.out.println("No se encontraron coincidencias.");
			MostrarOpcionesParticipantes.opcParticipantes.mostrarOpciones();
		}
		int valor = ScannerServiceImpl.scannerService.entradaDeNumero();
		parti = mapaTemporal.get(valor);
		return parti;
	}

}
