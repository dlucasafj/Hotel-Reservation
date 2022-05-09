import java.util.Scanner;

/**
 * Classe para executar o projeto na linha de comando
 * 
 * @author daniel
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HotelReservation hotelReservation = new HotelReservation();

		String dados = in.nextLine();

		String hotel = hotelReservation.getCheapestHotel(dados);

		in.close();

		System.out.println(hotel);
	}

}
