
import resevation.controller.ControllerHotel;

public class HotelReservation {

	public String getCheapestHotel(String input) {
		ControllerHotel controller = new ControllerHotel();
		controller.cria_cliente(input);

		return controller.hotel_barato();
	}
}
