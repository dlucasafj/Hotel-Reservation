package reservation.model;

import java.util.List;

/**
 * Classe que representa um cliente
 * 
 * @author daniel
 *
 */
public class Cliente {

	private String tipo;
	private List<String> datas;

	/**
	 * Construtor da Classe Cliente
	 * 
	 * @param tipo  Informa se é cliente Regular ou Rewards
	 * @param datas Os dias que o cliente pretende se hospedar
	 */
	public Cliente(String tipo, List<String> datas) {
		super();
		this.tipo = tipo;
		this.datas = datas;
	}

	public String getTipo() {
		return tipo;
	}

	public List<String> getDatas() {
		return datas;
	}

}
