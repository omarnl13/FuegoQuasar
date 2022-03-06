package com.mercadolibre.challenge.quasar.service;

import java.util.ArrayList;
import java.util.List;

import com.mercadolibre.challenge.quasar.exceptions.LocationException;
import com.mercadolibre.challenge.quasar.exceptions.MessageException;
import com.mercadolibre.challenge.quasar.model.Carrier;
import com.mercadolibre.challenge.quasar.model.Position;
import com.mercadolibre.challenge.quasar.model.Satellite;
import com.mercadolibre.challenge.quasar.model.SatelliteWrapper;

/**
 * Clase que representa el servicio de inteligencia y que respalda el servicio lambda de aws
 * @author omarnl
 *
 */
public class LambdaService {

	private MessageService messageService;
	
	private LocationService locationService;
	
	public LambdaService() {
		messageService=new MessageService();
		locationService=new LocationService();
	}
	
	
	public Carrier getCarrierResponse(SatelliteWrapper input) {
		
		List<List<String>> satellitesMessages= new ArrayList<List<String>>();
		
		double distances[]=null;
		
		
		if(input.getSatellites()!=null) {		
			
			distances=new double[input.getSatellites().size()];
			int i=0;
			for(Satellite satellite:input.getSatellites()) {
				if(satellite.getMessage()!=null)
					satellitesMessages.add(satellite.getMessage());
				
				distances[i++]=satellite.getDistance();
				
				
			}
		}else
			throw new RuntimeException("[BadRequest] :faltan parametros");
		
		
		Carrier carrier=new Carrier();
		
		try {
			 Position position=new Position();
			 double positionRes[]=null;
			 positionRes=locationService.getLocation(distances);
			 position.setX(positionRes[0]);
			 position.setY(positionRes[1]);
			 carrier.setPosition(position);
		} catch (LocationException e1) {
			throw new RuntimeException("[BadRequest] "+e1.getLocalizedMessage());
		}
		
		try {
			carrier.setMessage(messageService.getMessage(satellitesMessages));
		} catch (MessageException e) {
			throw new RuntimeException("[BadRequest] "+e.getLocalizedMessage());
		}
		
		
		
		
		return carrier;
		
	}
	
}
