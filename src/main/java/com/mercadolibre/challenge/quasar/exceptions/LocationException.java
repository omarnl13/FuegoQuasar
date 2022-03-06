package com.mercadolibre.challenge.quasar.exceptions;
/**
 * Clase que se utiliza para los mensajes de negocio en el servicio LocationService
 * @author omarnl
 *
 */
public class LocationException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 921880623001574345L;

	public LocationException(String errorMessage){
        super(errorMessage);
    }
}
