package mrbet;

import java.util.HashMap;
import java.util.ArrayList;

	/**
	 * Classe controladora do sistema MrBet
	 * @author Gledson Perdival
	 */
public class MrBetControler {
	
	private HashMap <String, Campeonato> campeonatos = new HashMap<>();
	private HashMap <String, Time> times = new HashMap<>();
	private ArrayList<String> apostas = new ArrayList<>();
	
	
	/**
	 * Cria e inclui os times no sistema.
	 * @param codigo é o identificador do time
	 * @param nome é o nome do time
	 * @param mascote é o mascote do time
	 * @return String confirmando ou não a inclusão do time no sistema
	 */
	public String incluirTime(String codTime, String nome, String mascote) {
		if(codTime == null || nome == null || mascote ==  null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if(codTime.trim().equals("") || nome.trim().equals("") || mascote.trim().equals("")) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		
		Time time = new Time(codTime, nome, mascote);
		if(this.times.containsKey(codTime)) {
			return "TIME JA EXISTE!";
		}
		
		this.times.put(codTime, time);
		return "INCLUSAO REALIZADA!";
	}
	
	/**
	 * confere se existe o time pedido no sistema.
	 * @param codigo é o código do time a ser recebido para ser procurado
	 * @return String com o código, nome e mascote do time caso ele exista ou a informação da inexistência dele
	 */
	public String recuperarTime(String codTime) {
		if(codTime == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if(codTime.trim().equals("")) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if(this.times.containsKey(codTime)) {
			return this.times.get(codTime).toString();
		}
		return "TIME NAO EXISTE!";
	}
	
	/**
	 * Cria e inclui os campeonatos no sistema.
	 * @param nome é o nome e identificador do campeonato
	 * @param participantes a quantidade máxima de participantes desse campeonato
	 * @return String confirmando ou não a inclusão do campeonato no sistema
	 */
	public String incluirCampeonato(String nome, int participantes) {
		if(nome == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if(nome.trim().equals("")) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		String nomeSemUpper = nome.substring(0,1).toUpperCase() + nome.substring(1,nome.length()).toLowerCase();
		if (this.campeonatos.containsKey(nome) || this.campeonatos.containsKey(nomeSemUpper)) {
			return "CAMPEONATO JA EXISTE!";
		}
		
		Campeonato campeonato = new Campeonato(nome, participantes);
		this.campeonatos.put(nome, campeonato);
		return "CAMPEONATO ADICIONADO!";
	}
	
	/**
	 * inclui um time existente do sistema em um campeonato.
	 * @param codTime é o código do time a ser colocado em determinado campeonato
	 * @param nomeCamp é o nome do campeonato a receber um time
	 * @return String com a confirmação ou não da inclusão de um time em um campeonato
	 */
	public String incluirTimeCampeonato(String codTime, String nomeCamp) {
		if(codTime == null || nomeCamp == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if(codTime.trim().equals("") || nomeCamp.trim().equals("")) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if(!this.times.containsKey(codTime)) {
			throw new IllegalArgumentException("O TIME NAO EXISTE!");
		}
		if(!this.campeonatos.containsKey(nomeCamp)) {
			throw new IllegalArgumentException("CAMPEONATO NAO EXISTE!");
		}
		if(this.campeonatos.get(nomeCamp).getTimesParticipantes().size() >= this.campeonatos.get(nomeCamp).getNumParticipantes()) {
			return "TODOS OS TIMES DESSE CAMPEONATO JA FORAM INCLUIDOS!";
		}
		if(this.campeonatos.get(nomeCamp).getTimesParticipantes().containsKey(codTime)) {
			return "O TIME JA FOI INCLUIDO ANTERIORMENTE!";
		}
		this.campeonatos.get(nomeCamp).getTimesParticipantes().put(codTime, this.times.get(codTime));
		return "TIME INCLUIDO NO CAMPEONATO!";
	}
	
	/**
	 * Verifica se um time está dentro de um campeonato.
	 * @param codTime é o código do time a ser procurado em determinado campeonato
	 * @param nomeCamp é o nome do campeonato no qual será procurado um time
	 * @return String com a confirmação ou não da existência do time no campeonato
	 */
	public String verificaTimeCampeonato(String codTime, String nomeCamp) {
		if(codTime == null || nomeCamp == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if(codTime.trim().equals("") || nomeCamp.trim().equals("")) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if(!this.times.containsKey(codTime)) {
			throw new IllegalArgumentException("O TIME NAO EXISTE!");
		}
		if(!this.campeonatos.containsKey(nomeCamp)) {
			throw new IllegalArgumentException("O CAMPEONATO NAO EXISTE!");
		}
		if(this.campeonatos.get(nomeCamp).getTimesParticipantes().containsKey(codTime)) {
			return "O TIME ESTA NO CAMPEONATO!";
		}
		if(!this.campeonatos.get(nomeCamp).getTimesParticipantes().containsKey(codTime)) {
			return "O TIME NAO ESTA NO CAMPEONATO!";
		}
		return "";
	}
	
	/**
	 * Mostra quais campeonatos o time participa.
	 * @param codigo é o código do time no qual será informado os campeonatos em que ele está
	 * @return String com os campeonatos em que o time está
	 */
	public String campsParticipando(String codTime) {
		if(codTime == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if(codTime.trim().equals("")) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if(!this.times.containsKey(codTime)) {
			throw new IllegalArgumentException("O TIME NAO EXISTE!");
		}
		
		String retorno =  "Time: " + codTime + " | Campeonatos do " + this.times.get(codTime).getNomeTime() + " | ";
		for(Campeonato camp : this.campeonatos.values()) {
			if(camp.getTimesParticipantes().containsKey(codTime)) {
				retorno += "* " + camp.toString() + " | ";
			}
		}
		if (retorno.endsWith("| Campeonatos do " + this.times.get(codTime).getNomeTime() + " | ")) {
		    return "O TIME NAO ESTA EM NENHUM CAMPEONATO!";
		}
		
		retorno = retorno.substring(0, retorno.length() - 3);
		return retorno;
	}
	
	/**
	 * Realiza uma aposta da coloação de um time no campeonato.
	 * @param codTime é o código do time no qual o usuário vai apostar
	 * @param nomeCamp é o nome do campeonato que o time participa
	 * @param colocacao é a posição final que o usuário aposta que o time terminará nesse campeonato
	 * @param preco é o valor da aposta
	 * @return String com a confirmação ou não da aposta
	 */
	public String tentarSorte(String codTime, String nomeCamp, int colocacao, double preco) {
		if(codTime == null || nomeCamp == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if(codTime.trim().equals("") || nomeCamp.trim().equals("")) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if(!this.times.containsKey(codTime)) {
			throw new IllegalArgumentException("O TIME NAO EXISTE!");
		}
		if(!this.campeonatos.containsKey(nomeCamp)) {
			throw new IllegalArgumentException("CAMPEONATO NAO EXISTE!");
		}
		if(this.campeonatos.get(nomeCamp).getNumParticipantes() < colocacao || colocacao <= 0) {
			return "APOSTA NAO REGISTRADA!";
		}
		if(!this.campeonatos.get(nomeCamp).getTimesParticipantes().containsKey(codTime)) {
			return "O TIME NAO ESTA NO CAMPEONATO!";
		}
		
		String aposta = this.times.get(codTime)+ " | " + this.campeonatos.get(nomeCamp).toString() + " | " + "R$" + preco;
		apostas.add(aposta);
		return "APOSTA REGISTRADA!";
	}
	
	/**
	 * mostra os status das apostas realizadas.
	 * @return todas as apostas realizadas até o momento pel usuário
	 */
	public String statusAposta() {
		String retorno = "Apostas: | ";
		if(this.apostas.size() == 0) {
			return "NAO TEM APOSTAS REGISTRADAS!";
		}
		for(int i = 0; i < this.apostas.size(); i++) {
			retorno += (i + 1)  +  ". " + this.apostas.get(i) + " | " ;
			
		}
		retorno = retorno.substring(0, retorno.length() - 3);
		return retorno;
	}
	
}
