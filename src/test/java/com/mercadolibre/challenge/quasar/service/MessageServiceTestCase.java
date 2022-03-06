package com.mercadolibre.challenge.quasar.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.challenge.quasar.exceptions.MessageException;

/**
 * Clase que se utliza para las pruebas unitarias del servicio MessageService
 * @author omarnl
 *
 */
public class MessageServiceTestCase {
	
	private static final Logger LOGGER = LogManager.getLogger(MessageServiceTestCase.class);
	
	private MessageService messageService;
	private List<String> satMsg;
	private List<List<String>> satellitesMes;
	
	  @Before
	  public void inicializar() {
		  messageService= new MessageService();
	  }
	  
	  @Test(expected = MessageException.class)
	  public void validaParametrosNulls() throws MessageException {		  
		  try {
			  messageService.getMessage(satellitesMes);			  
		  }catch(Exception e) {
			  LOGGER.error(e);
			  throw e;
		  }
	  }
	  
	  @Test(expected = MessageException.class)
	  public void validaParametrosVacios() throws MessageException {
		  satellitesMes=new ArrayList<List<String>>();
		  try {
			  messageService.getMessage(satellitesMes);			  
		  }catch(Exception e) {
			  LOGGER.error(e);
			  throw e;
		  }
	  }
	  
	  @Test(expected = MessageException.class)
	  public void validaParametrosFaltantes() throws MessageException {
		  satellitesMes=new ArrayList<List<String>>();
		  satMsg=new ArrayList<String>();
		  satMsg.add("este"); satMsg.add(""); satMsg.add(""); satMsg.add("mensaje"); satMsg.add("");			
		  satellitesMes.add(satMsg); satMsg=new ArrayList<String>();
		  satMsg.add(""); satMsg.add("es"); satMsg.add(""); satMsg.add("mensaje"); satMsg.add("");			
		  satellitesMes.add(satMsg);			  
		  try {
			  messageService.getMessage(satellitesMes);			  
		  }catch(Exception e) {
			  LOGGER.error(e);
			  throw e;
		  }
	  }
	
	  @Test(expected = MessageException.class)
	  public void validaFraseIncompleta1() throws MessageException {
		  satellitesMes=new ArrayList<List<String>>();
		  satMsg=new ArrayList<String>();
		  satMsg.add("este");  satMsg.add("");  satMsg.add("");  satMsg.add("mensaje"); satMsg.add("");			
		  satellitesMes.add(satMsg);  satMsg=new ArrayList<String>();
		  satMsg.add("este");  satMsg.add("");  satMsg.add("");  satMsg.add("mensaje"); satMsg.add("");			
		  satellitesMes.add(satMsg);  satMsg=new ArrayList<String>();
		  satMsg.add("este");  satMsg.add("");  satMsg.add("");  satMsg.add("mensaje"); satMsg.add("");
		  satellitesMes.add(satMsg);
		  try {
			  messageService.getMessage(satellitesMes);			  
		  }catch(Exception e) {
			  LOGGER.error(e);
			  throw e;
		  }
	  }
	  
	  @Test(expected = MessageException.class)
	  public void validaFraseIncompleta2() throws MessageException {
		  satellitesMes=new ArrayList<List<String>>();
		  satMsg=new ArrayList<String>();
		  satMsg.add("este");  satMsg.add("");  satMsg.add("un");  satMsg.add("mensaje"); satMsg.add("");			
		  satellitesMes.add(satMsg);  satMsg=new ArrayList<String>();
		  satMsg.add("este");  satMsg.add("");  satMsg.add("");  satMsg.add("mensaje"); satMsg.add("");			
		  satellitesMes.add(satMsg);  satMsg=new ArrayList<String>();
		  satMsg.add("este");  satMsg.add("");  satMsg.add("");  satMsg.add("mensaje"); satMsg.add("secreto");
		  satellitesMes.add(satMsg);
		  try {
			  messageService.getMessage(satellitesMes);			  
		  }catch(Exception e) {
			  LOGGER.error(e);
			  throw e;
		  }
	  }
	  
	  @Test(expected = MessageException.class)
	  public void validaFraseIncompleta3() throws MessageException {
		  satellitesMes=new ArrayList<List<String>>();
		  satMsg=new ArrayList<String>();
		  satMsg.add("este");  satMsg.add("");  satMsg.add("un");  satMsg.add("mensaje"); satMsg.add("");			
		  satellitesMes.add(satMsg);  satMsg=new ArrayList<String>();
		  satMsg.add("");  satMsg.add("");  satMsg.add("");  satMsg.add("mensaje"); satMsg.add("");			
		  satellitesMes.add(satMsg);  satMsg=new ArrayList<String>();
		  satMsg.add("");  satMsg.add("");  satMsg.add("");  satMsg.add("mensaje"); satMsg.add("secreto");
		  satellitesMes.add(satMsg);
		  try {
			  messageService.getMessage(satellitesMes);			  
		  }catch(Exception e) {
			  LOGGER.error(e);
			  throw e;
		  }
	  }
	  
	  @Test
	  public void validaFraseConDesfase() throws MessageException {
		  satellitesMes=new ArrayList<List<String>>();
		  satMsg=new ArrayList<String>();
		  satMsg.add("");  satMsg.add("este");  satMsg.add("es");  satMsg.add("un"); satMsg.add("");			
		  satellitesMes.add(satMsg);  satMsg=new ArrayList<String>();
		  satMsg.add("este");  satMsg.add("");  satMsg.add("");  satMsg.add("mensaje"); satMsg.add("");			
		  satellitesMes.add(satMsg);  satMsg=new ArrayList<String>();
		  satMsg.add("");  satMsg.add("");  satMsg.add("");  satMsg.add("secreto"); satMsg.add("");
		  satellitesMes.add(satMsg);
		  
		  String respuesta=messageService.getMessage(satellitesMes);
		  LOGGER.debug("Respuesta:"+respuesta);
		  
	  }
	  
	  @Test
	  public void validaCasoEjemplo() throws MessageException {
		  satellitesMes=new ArrayList<List<String>>();
		  satMsg=new ArrayList<String>();
		  satMsg.add("este");  satMsg.add("");  satMsg.add("");  satMsg.add("mensaje"); satMsg.add("");			
		  satellitesMes.add(satMsg);  satMsg=new ArrayList<String>();
		  satMsg.add("");  satMsg.add("es");  satMsg.add("");  satMsg.add(""); satMsg.add("secreto");			
		  satellitesMes.add(satMsg);  satMsg=new ArrayList<String>();
		  satMsg.add("este");  satMsg.add("");  satMsg.add("un");  satMsg.add(""); satMsg.add("");
		  satellitesMes.add(satMsg);
		  
		  String respuesta=messageService.getMessage(satellitesMes);
		  LOGGER.debug("Respuesta:"+respuesta);
		  
	  }
	  
	  
}
