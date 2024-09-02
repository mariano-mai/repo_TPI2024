package ar.com.mariano.tpi.service.resenia.impl;

import java.util.UUID;

import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.domain.Participante;
import ar.com.mariano.tpi.domain.Resenia;
import ar.com.mariano.tpi.service.listado.impl.ListadoYBusquedaImpl;
import ar.com.mariano.tpi.service.resenia.ReseniaService;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class ReseniaServiceImpl implements ReseniaService{
	
	public static ReseniaService coment = new ReseniaServiceImpl();
	
	Resenia opinion;

	@Override
	public void escribirComentario(Participante participante, Evento evento) {
		opinion = new Resenia();
		opinion.setIdResenia(UUID.randomUUID());
		opinion.setParticipante(participante);
		opinion.setEvento(evento);
		double calificacion = puntuacion(opinion);
		opinion.setCalificacion(calificacion);
		System.out.println("DEJE UN BREVE COMENTARIO SOBRE SU EXPERIENCIA EN EL EVENTO:");
		opinion.setComentario(ScannerServiceImpl.scannerService.entradaDeTexto());
	}
	
	private Double puntuacion(Resenia resenia) {
		int numer = 0;
		int i = 0;
		double promedio;
		System.out.println("¿CÓMO LE PARECIÓ EL EVENTO?\n1- Muy malo.\n2- Malo.\n3- Regular.\n4- Bueno.\n5- Muy bueno.");
		int calificacion = ScannerServiceImpl.scannerService.entradaDeNumero();
		resenia.getPuntos().add(calificacion);
		for(int punto : resenia.getPuntos()) {
			numer = numer + punto;
			i++;
		}
		promedio = numer/i;
		return promedio;
	}

	@Override
	public void editarComentario(Evento evento) {
		int opcion;
		Resenia res1 = ListadoYBusquedaImpl.listado.buscarResenia(evento);
		do {
			System.out.println("\n"+res1.toString()+"\n");
			System.out.println("¿EDITAR?\n1- SI.\n0- NO.");
			opcion = ScannerServiceImpl.scannerService.entradaDeNumero();
			switch(opcion) {
			case 1:
				System.out.println("Ingrese nueva puntuación:");
				res1.setCalificacion(ScannerServiceImpl.scannerService.entradaDeNumeroD());
				System.out.println("Ingrese nuevo comentario: ");
				res1.setComentario(ScannerServiceImpl.scannerService.entradaDeTexto());
				break;
			default:
			}
		}while(opcion != 0);
		
	}

	@Override
	public void eliminarComentario(Evento evento) {
		int opcion;
		Resenia res1 = ListadoYBusquedaImpl.listado.buscarResenia(evento);
		do {
			System.out.println("\n"+res1.toString()+"\n");
			System.out.println("¿ELIMINAR?\n1- SI.\n0- NO.");
			opcion = ScannerServiceImpl.scannerService.entradaDeNumero();
			switch(opcion) {
			case 1:
				evento.getResenias().remove(res1);
				break;
			default:
			}
		}while(opcion != 0);
		
	}

}
