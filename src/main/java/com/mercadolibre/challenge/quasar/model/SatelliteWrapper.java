package com.mercadolibre.challenge.quasar.model;

import java.util.List;

/**
 * Clase emboltoria para representar el payload para el servicio rest
 * @author omarnl
 *
 */
public class SatelliteWrapper {
	
	private List<Satellite> satellites;

    public void setSatellites(List<Satellite> satellites) {
        this.satellites = satellites;
    }

    public List<Satellite> getSatellites() {
        return satellites;
    }

}
