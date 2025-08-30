package mrbet;

import java.util.*;
import java.util.Objects;

	/**
	 * Representação de um campeonato com nome e times participantes.
	 * @author Gledson Perdival
	 */
public class Campeonato {
	
	private String nome;
	private int numParticipantes;
	private HashMap<String, Time> timesParticipantes;
	
	/**
	 * Cria um campeonato.
	 * @param nome é o nome do campeonato
	 * @param qtdParticipantes é a quantidade máxima de participantes permitidos
	 */
	public Campeonato(String nomeCampeonato, int numParticipantes) {
		this.nome = nomeCampeonato;
		this.numParticipantes = numParticipantes;
		this.timesParticipantes = new HashMap<>();
	}
	
	public String getNome() {
		return nome;
	}

	public int getNumParticipantes() {
		return numParticipantes;
	}
	
	public HashMap<String, Time> getTimesParticipantes() {
		return timesParticipantes;
	}
	
	@Override
	public String toString() {
		return nome + " - " + timesParticipantes.size() + "/" + numParticipantes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(nome, other.nome);
	}
}
