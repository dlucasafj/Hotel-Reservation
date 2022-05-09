package resevation.controller;

import reservation.model.Cliente;
import reservation.model.Hotel;
import reservation.model.service.ServiceHotel;

/**
 * Classe Controller, cria hotéis, clientes, e obtém o nome do hotel mais barato
 * @author daniel
 *
 */
public class ControllerHotel {
	private Hotel lakewood;
	private Hotel bridgewood;
	private Hotel ridgewood;

	private ServiceHotel serviceHotel;
	private Cliente cliente;

	/**
	 * Construtor que instancia os hotéis
	 */
	public ControllerHotel() {
		this.lakewood = new Hotel("Lakewood", 3, 110, 90, 80, 80);
		this.bridgewood = new Hotel("Bridgewood", 4, 160, 60, 110, 50);
		this.ridgewood = new Hotel("Ridgewood", 5, 220, 150, 100, 40);

		serviceHotel = new ServiceHotel();
	}

	/**
	 * Cria uma instância de Cliente
	 * 
	 * @param info dados de entrada do usuário
	 */
	public void cria_cliente(String info) {
		String[] dados = info.split(":\\s");
		String nome = dados[0];
		String datas = dados[1];

		cliente = new Cliente(nome, serviceHotel.obtemData(datas));

	}

	/**
	 * Retorna a instância de um cliente
	 * 
	 * @return
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Retorna o nome do hotel mais barato
	 * 
	 * @return
	 */
	public String hotel_barato() {
		String hotel_barato = serviceHotel.calcula_valores(cliente, lakewood, bridgewood, ridgewood);
		return hotel_barato;
	}

}
