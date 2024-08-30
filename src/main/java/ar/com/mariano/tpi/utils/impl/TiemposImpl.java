package ar.com.mariano.tpi.utils.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

import ar.com.mariano.tpi.utils.Tiempos;

public class TiemposImpl implements Tiempos{
	
	public static Tiempos tiempo = new TiemposImpl();

	@Override
	public boolean ocurrioAntes(LocalDateTime fecha) {
		boolean variable = Boolean.FALSE;
		ChronoLocalDateTime<LocalDate> actual = LocalDateTime.now();
		if(fecha.isBefore(actual)) {
			variable = Boolean.TRUE;
		}
		return variable;
	}

}
