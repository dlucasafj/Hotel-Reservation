package reservation.model.service;

import java.util.ArrayList;

import java.util.List;

import reservation.model.Cliente;
import reservation.model.Hotel;

/**
 * Classe Serviço que contém toda a regra de negócio da aplicação
 * 
 * @author daniel
 *
 */
public class ServiceHotel {

	private List<String> weeks;
	private List<String> final_week;

	/**
	 * Construtor da classe de serviço que instancia a lista dos dias da semana
	 */
	public ServiceHotel() {
		this.listaSemana();
	}

	/**
	 * Obtém os dias que o cliente informou
	 * 
	 * @param info array de datas sem ser formatadas
	 * @return Lista das datas formatadas
	 */
	public List<String> obtemData(String info) {
		List<String> dias = new ArrayList<>();
		String[] datas = info.split(",\\s");

		// obtém os dias da semana
		for (int i = 0; i < datas.length; i++) {
			String d = datas[i];
			dias.add(d.substring(d.length() - 5, d.length()).replace("(", "").replace(")", ""));

		}
		return dias;
	}

	/**
	 * Calcula o orçamento dos hotéis e retorna o hotel mais barato
	 * 
	 * @param cliente
	 * @param lakewood
	 * @param bridgewood
	 * @param ridgewood
	 * @return String com o nome do hotél mais barato
	 */
	public String calcula_valores(Cliente cliente, Hotel lakewood, Hotel bridgewood, Hotel ridgewood) {

		int semana = this.conta_dias_semana(cliente.getDatas());
		int finalS = this.conta_final_semana(cliente.getDatas());
		String resultado = "";

		if (cliente.getTipo().equals("Regular")) {
			int total_lakewood = (semana * lakewood.getTaxa_normal_semana()) + (finalS * lakewood.getTaxa_normal_fds());
			int total_bridgewood = (semana * bridgewood.getTaxa_normal_semana())
					+ (finalS * bridgewood.getTaxa_normal_fds());
			int total_ridgewood = (semana * ridgewood.getTaxa_normal_semana())
					+ (finalS * ridgewood.getTaxa_normal_fds());

			resultado = this.pesquisa_hotel_barato(total_lakewood, total_bridgewood, total_ridgewood, lakewood,
					bridgewood, ridgewood);

		} else if (cliente.getTipo().equals("Rewards")) {
			int total_fidelidade_lakewood = (semana * lakewood.getTaxa_fidelidade_semana())
					+ (finalS * lakewood.getTaxa_fidelidade_fds());
			int total_fidelidade_bridgewood = (semana * bridgewood.getTaxa_fidelidade_semana())
					+ (finalS * bridgewood.getTaxa_fidelidade_fds());
			int total_fidelidae_ridgewood = (semana * ridgewood.getTaxa_fidelidade_semana())
					+ (finalS * ridgewood.getTaxa_fidelidade_fds());
			resultado = this.pesquisa_hotel_barato(total_fidelidade_lakewood, total_fidelidade_bridgewood,
					total_fidelidae_ridgewood, lakewood, bridgewood, ridgewood);

		}

		return resultado;
	}

	/**
	 * Verifica qual hotel é mais barato
	 * 
	 * @param total_lakewood
	 * @param total_bridgewood
	 * @param total_ridgewood
	 * @param lakewood
	 * @param bridgewood
	 * @param ridgewood
	 * @return nome do hotél mais barato
	 */
	private String pesquisa_hotel_barato(int total_lakewood, int total_bridgewood, int total_ridgewood, Hotel lakewood,
			Hotel bridgewood, Hotel ridgewood) {

		if (total_lakewood == total_bridgewood && total_lakewood == total_ridgewood) {
			return ridgewood.getName();
		}

		if (total_lakewood < total_bridgewood && total_lakewood < total_ridgewood) {
			return lakewood.getName();
		} else if (total_bridgewood < total_lakewood && total_bridgewood < total_ridgewood) {
			return bridgewood.getName();
		} else if (total_ridgewood < total_lakewood && total_ridgewood < total_bridgewood) {
			return ridgewood.getName();
		}

		// Caso de Igualdade
		if (total_lakewood == total_bridgewood) {
			if (lakewood.getClassificacao() > bridgewood.getClassificacao()) {
				return lakewood.getName();
			} else {
				return bridgewood.getName();
			}
		} else if (total_lakewood == total_ridgewood) {
			if (lakewood.getClassificacao() > ridgewood.getClassificacao()) {
				return lakewood.getName();
			} else {
				return ridgewood.getName();
			}
		} else if (total_bridgewood == total_ridgewood) {
			if (bridgewood.getClassificacao() > ridgewood.getClassificacao()) {
				return bridgewood.getName();
			} else {
				return ridgewood.getName();
			}
		}
		return null;
	}

	/**
	 * Conta a quantidade de dias que se refere aos dias da semana
	 * 
	 * @param datas
	 * @return
	 */
	private int conta_dias_semana(List<String> datas) {
		int semana = 0;
		for (String data : datas) {
			if (this.weeks.contains(data)) {
				semana++;
			}
		}
		return semana;
	}

	/**
	 * Conta a quantidade de dias que refere-se ao final de semana
	 * 
	 * @param datas
	 * @return
	 */
	private int conta_final_semana(List<String> datas) {
		int final_semana = 0;
		for (String data : datas) {
			if (this.final_week.contains(data)) {
				final_semana++;
			}
		}
		return final_semana;
	}

	/**
	 * Cria uma lista com os nomes dos dias da semana e do final de semana
	 */
	private void listaSemana() {
		this.weeks = new ArrayList<>();
		this.final_week = new ArrayList<>();

		weeks.add("mon");
		weeks.add("tue");
		weeks.add("tues");
		weeks.add("wed");
		weeks.add("thu");
		weeks.add("thur");
		weeks.add("thurs");
		weeks.add("fri");
		final_week.add("sat");
		final_week.add("sun");
	}
}
