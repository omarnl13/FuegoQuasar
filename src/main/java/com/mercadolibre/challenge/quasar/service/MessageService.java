package com.mercadolibre.challenge.quasar.service;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.mercadolibre.challenge.quasar.exceptions.MessageException;
/**
 * Clase que representa el servicio de desifrado de mensajes
 * @author omarnl
 *
 */
public class MessageService {
	
	/**
	 * Metodo que recibe los mensajes de los satelites y trata de determinar la frase secreta
	 * @param msgList
	 * @return
	 * @throws MessageException
	 */
	public String getMessage(List<List<String>> msgList) throws MessageException {
		
		if(msgList==null||msgList.size()<3)
			throw new MessageException("Faltan mensajes de los satelites para determinar el mensaje");
		
		int cantidadPalabras=getSizeMessage(msgList);
		
		String []frase=new String[cantidadPalabras];
		
		int indicePalabra;
		
				
		for(List<String> messageSatelite:msgList) {			
						
			indicePalabra=0;	
			for(String dat:messageSatelite) {
				
				if(indicePalabra<frase.length&&StringUtils.isNotBlank(dat)){
					if(StringUtils.isBlank(frase[indicePalabra])) {
							frase[indicePalabra]=dat;
					}else{
						if(indicePalabra==0&&countsNullsInArray(frase)>1) {
							if(StringUtils.isBlank(frase[indicePalabra])) {
								frase=moveStrings(frase,1);
								frase[indicePalabra]=dat;
							}
						}else {
							if(indexOf(frase, dat)>=0) {
								indicePalabra=indexOf(frase, dat);
								frase[indicePalabra]=dat;
							}else {
								int z=findNextNullInArray(frase);
								if(z>=0&&z<cantidadPalabras) {
									frase[z]=dat;
								}
								
							}
						}
							
					}
				}
				indicePalabra++;
			}
			
			frase=lTrim(frase);
			
		}
	
		
		
		if(countsNullsInArray(frase)>0)
			throw new MessageException("No se pudo determinar la mensaje");
		
				
				
		
		return Arrays.toString(frase).replaceAll(",", "").replaceAll("\\[", "").replaceAll("\\]", "");
		
	}
	
	
	private String[] lTrim(String []array) {
		
		String []trimmedArray=new String[array.length];
		
		int indice=0;
		for(String string:array) {
			if(StringUtils.isBlank(string)) {
				indice++;
			}else {
				break;
			}
		}
		
		for(int i=0; i<trimmedArray.length; i++) {
			if((indice+i)<array.length)
			trimmedArray[i]=array[indice+i];
		}
		
		
		
		
		return trimmedArray;
		
	}
	private String[] moveStrings(String []array, int nspace) {
		
		String []newArray=new String[array.length];
		
		int indice=nspace;
		for(int i=0; i<array.length; i++) {
			if(indice<array.length)
				newArray[indice++]=array[i];
		}
		return newArray;
	}
	
	private int indexOf(String []array,String string) {
		for(int i=0; i<array.length; i++) {
			if(StringUtils.isNotBlank(array[i])){				
				if(string.equalsIgnoreCase(array[i])) 
					return i;
			}
		}
		return -1;
	}
	
	
	private int countsNullsInArray(String []array) {
		int numsNulls=0;
		for(int i=0; i<array.length; i++) {
			if(array[i]==null)
				numsNulls++;
		}
		return numsNulls;
	}
	
	private int findNextNullInArray(String []array) {
		for(int i=0; i<array.length; i++) {
			if(array[i]==null)
				return i; 
		}
		return -1;
	}
	
	
	private int getSizeMessage(List<List<String>> msgList){
		int cantidadPalabras=0;
		for(List<String> messageSatelite:msgList) {	
			cantidadPalabras=cantidadPalabras<messageSatelite.size()?messageSatelite.size():cantidadPalabras;	
		}
		return cantidadPalabras;
	}
	
	
	
}
