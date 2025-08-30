package mrbet;

import java.util.Objects;

	/**
	 * Representação de um time, com codigo, nome e mascote.
	 * @author Gledson Perdival
	 */
public class Time {
	
	private String nomeTime;
	private String codigo;
	private String mascote;
	
	/**
	 * Cria um time.
	 * @param codigo é o identificador do time no sistema
	 * @param nome é o nome do time
	 * @param mascote é o mascote do time
	 */
	public Time(String codigo, String nomeTime, String mascote) {
		this.nomeTime = nomeTime;
		this.codigo = codigo;
		this.mascote = mascote;
		
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getMascote() {
		return mascote;
	}
	
	@Override
	public String toString() {
		return "[" + this.codigo + "]" + " " + this.nomeTime + " / " + mascote;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(codigo, other.codigo);
	}
}
