package com.mercadolibre.challenge.quasar.exceptions;

/**
 * Clase que se utiliza para los mensajes de negocio en el servicio MessageService
 * @author omarnl
 *
 */
public class MessageException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1479292909620967174L;

	public MessageException(String errorMessage){
        super(errorMessage);
    }
	
}
