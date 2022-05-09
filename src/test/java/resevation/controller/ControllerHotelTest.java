package resevation.controller;

import static org.junit.Assert.*;


import org.junit.Test;

import reservation.model.Cliente;
/**
 * Testa a classe ControllerHotel
 * @author daniel
 *
 */
public class ControllerHotelTest {

	String dados = "Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)";

	ControllerHotel controlador;

	/**
	 * Testa para saber se o controlador está criando um Cliente
	 */
	@Test
	public void testCria_cliente() {
		controlador = new ControllerHotel();

		controlador.cria_cliente(dados);
		Cliente atual = controlador.getCliente();

		assertEquals(Cliente.class, atual.getClass());
	}

	/**
	 *  Testa o método que retorna o Nome do Hotel mais barato
	 */
	@Test
	public void testHotel_barato() {
		String dados2 = "Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)";
		String dados3 = "Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)";
		
		
		controlador = new ControllerHotel();

		controlador.cria_cliente(dados);
		String resultado = controlador.hotel_barato();
		
		
		controlador.cria_cliente(dados2);
		String resultado2 = controlador.hotel_barato();
		
		
		controlador.cria_cliente(dados3);
		String resultado3 = controlador.hotel_barato();
		
		assertEquals("Lakewood", resultado);
		assertEquals("Bridgewood",resultado2);
		assertEquals("Ridgewood", resultado3);
	}

}
