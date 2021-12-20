package model;

import java.util.ArrayList;

public class Clubes {

	public Clubes() {

	}

	ArrayList<String> clubes = new ArrayList<String>();

	public void addClube(String nome) {
		clubes.add(nome);
	}

	public ArrayList<String> listarClubes() {

		return clubes;
	}

	ArrayList<String> jogos = new ArrayList<String>();

	public ArrayList<String> formarJogos() {

		for (int i = 0; i < clubes.size() - 1; i += 2) {
			String clube1 = clubes.get(i);
			String clube2 = clubes.get(i + 1);

			String jogo = clube1 + " x " + clube2;
			jogos.add(jogo);
		}

		return jogos;
	}

	ArrayList<Integer> gols = new ArrayList<Integer>();

	public void gols(Integer registrarGols) {

		gols.add(registrarGols);
	}

	public ArrayList<Integer> mostrarGols() {

		return gols;
	}

	ArrayList<String> ganhouPrimeiraFase = new ArrayList<String>();

	public void ganhadoresPrimeiroJogo(String clubeVencedor) {

		ganhouPrimeiraFase.add(clubeVencedor);
	}

	public ArrayList<String> ganhadoresPrimeiro() {

		return ganhouPrimeiraFase;
	}

	ArrayList<String> ultimosJogos = new ArrayList<String>();

	public ArrayList<String> formarUltimosJogos() {

		for (int i = 0; i < ganhouPrimeiraFase.size() - 1; i += 2) {
			String clube1 = ganhouPrimeiraFase.get(i);
			String clube2 = ganhouPrimeiraFase.get(i + 1);

			String jogo = clube1 + " x " + clube2;
			ultimosJogos.add(jogo);
		}

		return ultimosJogos;
	}

	ArrayList<Integer> golsUltimaFase = new ArrayList<Integer>();

	public void golsUltimaFase(Integer gols) {

		golsUltimaFase.add(gols);
	}

	public ArrayList<Integer> mostrarGolsUltimaFase() {

		return golsUltimaFase;
	}
}
