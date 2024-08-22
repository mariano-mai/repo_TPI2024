package ar.com.mariano.tpi.utils.impl;

import java.util.Scanner;

import ar.com.mariano.tpi.utils.ScannerService;

public class ScannerServiceImpl implements ScannerService{
	
	Scanner entrada;

	@Override
	public String entradaDeTexto() {
		entrada = new Scanner(System.in);
		String texto = entrada.nextLine();
		entrada.close();
		return texto;
	}

	@Override
	public int entradaDeNumero() {
		entrada = new Scanner(System.in);
		int numero = entrada.nextInt();
		entrada.close();
		return numero;
	}

	@Override
	public Long entradaDeNumeroLong() {
		entrada = new Scanner(System.in);
		Long numero = entrada.nextLong();
		entrada.close();
		return numero;
	}

	@Override
	public boolean esONoEs(int valor) {
		boolean esHabilitado = false;
		if(valor == 1) {
			esHabilitado = true;
		}
		return esHabilitado;
	}

}
