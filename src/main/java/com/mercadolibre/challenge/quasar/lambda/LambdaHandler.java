package com.mercadolibre.challenge.quasar.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.mercadolibre.challenge.quasar.model.Carrier;
import com.mercadolibre.challenge.quasar.model.SatelliteWrapper;
import com.mercadolibre.challenge.quasar.service.LambdaService;



/**
 * Clase para instalar una funcion lambda en AWS
 * @author omarnl
 *
 */
public class LambdaHandler implements RequestHandler<SatelliteWrapper,Carrier> {

	private LambdaService lambdaService;
    
	public LambdaHandler() {
		lambdaService=new LambdaService();
	}
	public Carrier handleRequest(SatelliteWrapper satelliteWrapper, Context context) {
		return lambdaService.getCarrierResponse(satelliteWrapper);		
	}
	
}
