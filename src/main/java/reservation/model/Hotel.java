package reservation.model;

/**
 * Classe que representa um hotel
 * 
 * @author daniel
 *
 */
public class Hotel {

	private String name;
	private int classificacao;
	private int taxa_normal_semana;
	private int taxa_normal_fds;
	private int taxa_fidelidade_semana;
	private int taxa_fidelidade_fds;

	/**
	 * Construtor Padrão do Hotel
	 * 
	 * @param name                   Nome do Hotel
	 * @param classificacao          número da classificação do hotel
	 * @param taxa_normal_semana     valor para clientes normais nos dias da semana
	 * @param taxa_normal_fds        valor para clientes normais nos finais de
	 *                               semanas
	 * @param taxa_fidelidade_semana valor para clientes fidelidade nos dias da
	 *                               semana
	 * @param taxa_fidelidade_fds    valor para clientes fidelidades nos finais de
	 *                               semana
	 */
	public Hotel(String name, int classificacao, int taxa_normal_semana, int taxa_normal_fds,
			int taxa_fidelidade_semana, int taxa_fidelidade_fds) {

		this.name = name;
		this.classificacao = classificacao;
		this.taxa_normal_semana = taxa_normal_semana;
		this.taxa_normal_fds = taxa_normal_fds;
		this.taxa_fidelidade_semana = taxa_fidelidade_semana;
		this.taxa_fidelidade_fds = taxa_fidelidade_fds;
	}

	public String getName() {
		return name;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public int getTaxa_normal_semana() {
		return taxa_normal_semana;
	}

	public int getTaxa_normal_fds() {
		return taxa_normal_fds;
	}

	public int getTaxa_fidelidade_semana() {
		return taxa_fidelidade_semana;
	}

	public int getTaxa_fidelidade_fds() {
		return taxa_fidelidade_fds;
	}

}
