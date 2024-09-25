package ar.com.mariano.tpi.service.chef.mapeochef.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import ar.com.mariano.tpi.domain.Chef;
import ar.com.mariano.tpi.service.chef.mapeochef.MapeoChefInterface;

public class MapeoChefImpl implements MapeoChefInterface{
	
	public static Map<UUID, Chef> chefs = new HashMap<>();

	@Override
	public void mapearChef(Chef chef) {
		chefs.put(chef.getIdChef(), chef);
		
	}

}
