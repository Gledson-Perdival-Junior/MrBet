package mrbet;

import java.util.*;

public class MrBetMain {
	
	public static void main(String[] Args) {
	MrBetControler MrBet = new MrBetControler();
		
	Scanner sc = new Scanner(System.in);
	String escolha = "";
	while (true) {
		escolha = menu(sc);
		comando(escolha, MrBet, sc);
		}
	}
	
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(M)Minha inclusão de times\n" + 
						"(R)Recuperar time\n" + 
						"(.)Adicionar campeonato\n" + 
						"(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" +
						"(E)Exibir campeonatos que o time participa\n" +
						"(T)Tentar a sorte e status\n" +
						"(!)Já pode fechar o programa!\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}
	
	private static void comando(String escolha, MrBetControler mrBet, Scanner sc) {
		switch(escolha) {
		case "M":
			adicionaTime(mrBet, sc);
			break;
		case "R":
			recuperaTime(mrBet, sc);
			break;
		case ".":
			adicionaCampeonato(mrBet, sc);
			break;
		case "B":
			System.out.println("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato?");
			sc.nextLine();
			String escolhaB = sc.nextLine().toUpperCase();
			switch(escolhaB) {
			case "I":
				incluirTimeCampeonato(mrBet, sc);
				break;
			case "V":
				verificaTime(mrBet, sc);
				break;
			}
			break;
		case "E":
			exibeCampeonatosTime(mrBet, sc);
			break;
		case "T":
			System.out.println("(A)Apostar ou (S)Status das Apostas?");
			sc.nextLine();
			String escolhaT = sc.nextLine().toUpperCase();
			switch(escolhaT) {
			case "A":
				aposta(mrBet, sc);
				break;
			case "S":
				statusAposta(mrBet, sc);
				break;
			}
			break;
		case "!":
			sair();
			break;
		default:
			System.out.println("Opção inválida!");
		}
			
	}

	private static void statusAposta(MrBetControler mrBet, Scanner sc) {
		System.out.println(mrBet.statusAposta());		
	}

	private static void aposta(MrBetControler mrBet, Scanner sc) {
		System.out.println("Código: ");
		String codigo = sc.nextLine();
		System.out.println("Campeonato: ");
		String campeonato = sc.nextLine();
		System.out.println("Colocação: ");
		int colocacao = sc.nextInt();
		System.out.println("Valor da aposta: ");
		int valor = sc.nextInt();
		System.out.println(mrBet.tentarSorte(codigo, campeonato, colocacao, valor));
	}

	private static void exibeCampeonatosTime(MrBetControler mrBet, Scanner sc) {
		System.out.println("Código: ");
		sc.nextLine();
		String codigo = sc.nextLine();
		System.out.println(mrBet.campsParticipando(codigo));
	}

	private static void verificaTime(MrBetControler mrBet, Scanner sc) {
		System.out.println("Código: ");
		String codigo = sc.nextLine();
		System.out.println("Campeonato: ");
		String campeonato = sc.nextLine();
		System.out.println(mrBet.verificaTimeCampeonato(codigo, campeonato));
	}

	private static void incluirTimeCampeonato(MrBetControler mrBet, Scanner sc) {
		System.out.println("Código: ");
		String codigo = sc.nextLine();
		System.out.println("Campeonato: ");
		String campeonato = sc.nextLine();
		System.out.println(mrBet.incluirTimeCampeonato(codigo, campeonato));
	}

	private static void adicionaCampeonato(MrBetControler mrBet, Scanner sc) {
		System.out.println("Campeonato: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.println("Participantes: ");
		int participantes = sc.nextInt();
		System.out.println(mrBet.incluirCampeonato(nome, participantes));
	}

	private static void recuperaTime(MrBetControler mrBet, Scanner sc) {
		System.out.println("Código: ");
		sc.nextLine();
		String codigo = sc.nextLine();
		System.out.println(mrBet.recuperarTime(codigo));
	}


	private static void adicionaTime(MrBetControler mrBet, Scanner sc) {
		System.out.println("Código: ");
		sc.nextLine();
		String codigo = sc.nextLine();
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		System.out.println("Mascote: ");
		String mascote = sc.nextLine();
		System.out.println(mrBet.incluirTime(codigo, nome, mascote));
	}
	
	private static void sair() {
		System.exit(0);		
	}
}

