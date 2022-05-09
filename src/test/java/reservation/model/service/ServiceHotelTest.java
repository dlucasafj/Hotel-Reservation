package reservation.model.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import reservation.model.Cliente;
import reservation.model.Hotel;

/**
 * Testa a classe ServiceHotel
 * @author daniel
 *
 */
public class ServiceHotelTest {
	ServiceHotel service;
	String datas = "16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed), 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)";

	/**
	 * Testa o método que obtém os dias da semana informados junto com as datas
	 */
	@Test
	public void testObtemData() {
		service = new ServiceHotel();

		List<String> dat = service.obtemData(datas);

		assertEquals("sun", dat.get(5));
		assertEquals(6, dat.size());
	}

	/**
	 * Testa o método que retorna o nome do hotel mais barato
	 */
	@Test
	public void testCalcula_valores() {
		service = new ServiceHotel();
		Hotel lakewood = new Hotel("Lakewood", 3, 110, 90, 80, 80);
		;
		Hotel bridgewood = new Hotel("Bridgewood", 4, 160, 60, 110, 50);
		;
		Hotel ridgewood = new Hotel("Ridgewood", 5, 220, 150, 100, 40);
		;

		String dias = "16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)";
		String dias2 = "20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)";
		String dias3 = "26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)";

		List<String> dat = service.obtemData(dias);
		List<String> dat2 = service.obtemData(dias2);
		List<String> dat3 = service.obtemData(dias3);

		Cliente cliente = new Cliente("Regular", dat);
		Cliente cliente2 = new Cliente("Regular", dat2);
		Cliente cliente3 = new Cliente("Rewards", dat3);

		String hotel = service.calcula_valores(cliente, lakewood, bridgewood, ridgewood);
		String hotel2 = service.calcula_valores(cliente2, lakewood, bridgewood, ridgewood);
		String hotel3 = service.calcula_valores(cliente3, lakewood, bridgewood, ridgewood);
		assertEquals("Lakewood", hotel);
		assertEquals("Bridgewood", hotel2);
		assertEquals("Ridgewood", hotel3);
	}

}
