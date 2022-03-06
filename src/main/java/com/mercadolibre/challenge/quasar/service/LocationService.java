package com.mercadolibre.challenge.quasar.service;

import com.mercadolibre.challenge.quasar.exceptions.LocationException;


/**
 * Clase que representa el servicio de localizacion en base a las distancias
 * @author omarnl
 *
 */
public class LocationService {
	/**
	 * Metodo que determina la localización en base al distancias
	 * @param distance
	 * @return
	 * @throws LocationException
	 */
	public double[] getLocation(double []distance)throws LocationException{
		
		if(distance.length<3)
			throw new LocationException("Faltan mensajes de los satelites para determinar el mensaje");
		
		double []position=new double[2];
		
		//TODO FALTA LOGICA PARA DETERMINAR DISTANCIAS
		
		
		
		position[0]=-100.0;
		position[1]=75.5;
		
		return position; 
	}
}
