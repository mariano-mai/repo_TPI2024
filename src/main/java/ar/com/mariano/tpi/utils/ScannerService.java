package ar.com.mariano.tpi.utils;

public interface ScannerService {
	
	String entradaDeTexto();
	
	int entradaDeNumero();
	
	Long entradaDeNumeroLong();
	
	Double entradaDeNumeroD();
	
	boolean esONoEs(int valor);

}
