package ar.com.mariano.tpi.service.resenia.impl;

import java.util.UUID;

import ar.com.mariano.tpi.domain.Evento;
import ar.com.mariano.tpi.domain.Participante;
import ar.com.mariano.tpi.domain.Resenia;
import ar.com.mariano.tpi.service.listado.impl.ListadoYBusquedaImpl;
import ar.com.mariano.tpi.service.menu.impl.MostrarOpcionesResenia;
import ar.com.mariano.tpi.service.resenia.ReseniaService;
import ar.com.mariano.tpi.utils.impl.ScannerServiceImpl;

public class ReseniaServiceImpl implements ReseniaService{
	
	public static ReseniaService coment = new ReseniaServiceImpl();
	
	Resenia opinion;
	Resenia res1 = new Resenia();

	@Override
	public void escribirComentario(Participante participante, Evento evento) {
		Resenia nuevaRes = crearComentario();
		nuevaRes.setEvento(evento);
		evento.getResenias().add(nuevaRes);
		nuevaRes.setParticipante(participante);
		System.out.println("Comentario ingresado con éxito.");
		System.out.println(nuevaRes.getParticipante().getApellido()+", "+nuevaRes.getParticipante().getNombre()+" comentó sobre el evento "+nuevaRes.getEvento().getNombre());
	}
	
	private int puntuacion(Resenia resenia) {
		int numer;
		System.out.println("\n1- Muy malo.\n2- Malo.\n3- Regular.\n4- Bueno.\n5- Muy bueno.");
		numer = ScannerServiceImpl.scannerService.entradaDeNumero();
		return numer;
	}

	@Override
	public void editarComentario(Evento evento) {
		int opcion;
		res1 = ListadoYBusquedaImpl.listado.buscarResenia(evento);
		if(res1 == null) {
			System.out.println("\nNo hay comentario.\n");
			MostrarOpcionesResenia.opcRes.mostrarOpciones();
		}else {
			do {
				System.out.println("\n"+res1.toString()+"\n");
				System.out.println("¿EDITAR?\n1- SI.\n0- NO.");
				opcion = ScannerServiceImpl.scannerService.entradaDeNumero();
				switch(opcion) {
				case 1:
					System.out.println("Ingrese nueva puntuación:");
					res1.setPunto(puntuacion(res1));
					System.out.println("Ingrese nuevo comentario: ");
					res1.setComentario(ScannerServiceImpl.scannerService.entradaDeTexto());
					break;
				default:
				}
			}while(opcion != 0);
		}
		
	}

	@Override
	public void eliminarComentario(Evento evento) {
		int opcion;
		res1 = ListadoYBusquedaImpl.listado.buscarResenia(evento);
		if(res1 == null) {
			System.out.println("\nNo hay comentario.\n");
			MostrarOpcionesResenia.opcRes.mostrarOpciones();
		}else {
			do {
				System.out.println("\n"+res1.toString()+"\n");
				System.out.println("¿ELIMINAR?\n1- SI.\n0- NO.");
				opcion = ScannerServiceImpl.scannerService.entradaDeNumero();
				switch(opcion) {
				case 1:
					evento.getResenias().remove(res1);
					System.out.println("Comentario eliminado Sin éxito.");
					opcion = 0;
					break;
				default:
				}
			}while(opcion != 0);
		}
		
	}
	
	private Resenia crearComentario() {
		opinion = new Resenia();
		opinion.setIdResenia(UUID.randomUUID());
		System.out.println("¿CÓMO LE PARECIÓ EL EVENTO?");
		int punto = puntuacion(opinion);
		opinion.setPunto(punto);
		System.out.println("DEJE UN BREVE COMENTARIO SOBRE SU EXPERIENCIA EN EL EVENTO:");
		opinion.setComentario(ScannerServiceImpl.scannerService.entradaDeTexto());
		return opinion;
	}

}
