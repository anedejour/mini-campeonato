package controller;

import java.awt.AWTEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Clubes;

public class ClubesController {
	public static void main(String[] args) {

		JFrame f;
		f = new JFrame();

		Clubes clubes = new Clubes();

		while (true) {
			String nomeClube = JOptionPane.showInputDialog("Digite o nome do clube: ");
			if (nomeClube == null)
				break;
			clubes.addClube(nomeClube);
			int incluirOutroTime = JOptionPane.showConfirmDialog(null, "Deseja incluir outro?");
			if (incluirOutroTime != JOptionPane.YES_OPTION)
				break;
		}
		if (clubes.listarClubes().size() == 0) {
			JOptionPane.showMessageDialog(null, "Nao ha times listados");

		} else {
			for (int i = 0; i < clubes.listarClubes().size(); i++) {
				if (clubes.listarClubes().size() - 1 == i) {
					clubes.listarClubes();
				} else {
					clubes.listarClubes();
				}
			}
		}

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if (clubes.listarClubes().size() % 2 != 0) {
			JOptionPane.showConfirmDialog(null, "Insira mais um time");
			System.exit(0);
		}
//		else if ((int) Math.pow(clubes.listarClubes().size(), 2)%2 < 1) {
//			JOptionPane.showConfirmDialog(null, "Insira mais dois times");
//			System.exit(0);
//		}
		else {
			int montarJogos = JOptionPane.showConfirmDialog(null, "Ver como ficaram os jogos?");
			if (montarJogos == JOptionPane.YES_OPTION) {
				JOptionPane.showConfirmDialog(null, "Jogos formados: \n" + clubes.formarJogos());
			}
		}
		int registroGols = JOptionPane.showConfirmDialog(null, "Registrar gols");

		if (registroGols == JOptionPane.YES_OPTION) {
			for (int i = 0; i < clubes.listarClubes().size(); i++) {

				String registrarGols = (String) JOptionPane.showInputDialog(f,
						"Gols de " + clubes.listarClubes().get(i));
				int golPorTime = Integer.parseInt(registrarGols);
				clubes.gols(golPorTime);
			}
//			JOptionPane.showConfirmDialog(null, "Gols: \n" + clubes.mostrarGols());

			for (int i = 0; i < clubes.mostrarGols().size() - 1; i += 2) {
				if (clubes.mostrarGols().get(i) > clubes.mostrarGols().get(i + 1)) {
					JOptionPane.showMessageDialog(f, "Vencedor: " + clubes.listarClubes().get(i), "Resultado",
							JOptionPane.INFORMATION_MESSAGE);
					clubes.ganhadoresPrimeiroJogo(clubes.listarClubes().get(i));
				} else {
					JOptionPane.showMessageDialog(f, "Vencedor: " + clubes.listarClubes().get(i + 1), "Resultado",
							JOptionPane.INFORMATION_MESSAGE);
					clubes.ganhadoresPrimeiroJogo(clubes.listarClubes().get(i + 1));
				}

			}

			JOptionPane.showMessageDialog(f, "Disputa entre os vencedores");

			JOptionPane.showConfirmDialog(null, "Jogos formados: \n" + clubes.formarUltimosJogos());

			registroGols = JOptionPane.showConfirmDialog(null, "Registrar gols");

			if (registroGols == JOptionPane.YES_OPTION) {
				for (int i = 0; i < clubes.ganhadoresPrimeiro().size(); i++) {

					String registrarGols = (String) JOptionPane.showInputDialog(f,
							"Gols de " + clubes.ganhadoresPrimeiro().get(i));
					int golPorTime = Integer.parseInt(registrarGols);
					clubes.golsUltimaFase(golPorTime);
				}

				for (int i = 0; i < clubes.mostrarGolsUltimaFase().size() - 1; i += 2) {
					if (clubes.mostrarGolsUltimaFase().get(i) > clubes.mostrarGolsUltimaFase().get(i + 1)) {
						JOptionPane.showMessageDialog(f, "Vencedor: " + clubes.ganhadoresPrimeiro().get(i), "Resultado",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(f, "Vencedor: " + clubes.ganhadoresPrimeiro().get(i + 1),
								"Resultado", JOptionPane.INFORMATION_MESSAGE);
					}

				}
			}
		}
	}
}
