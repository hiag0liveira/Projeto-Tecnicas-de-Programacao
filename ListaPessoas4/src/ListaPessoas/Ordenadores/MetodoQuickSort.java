package ListaPessoas.Ordenadores;

import ListaPessoas.ColecaoDePessoas;
import ListaPessoas.Pessoa;

public class MetodoQuickSort implements Ordenador {

	@Override
	public void PorAnoDeNascimento(ColecaoDePessoas listaDePessoas, int inicio, int fim) {
		int posicaoPivo;
		if (fim > inicio) {
			posicaoPivo = particionarVetor(listaDePessoas, inicio, fim);
			PorAnoDeNascimento(listaDePessoas, inicio, posicaoPivo - 1);
			PorAnoDeNascimento(listaDePessoas, posicaoPivo + 1, fim);
		}	
	}

	private static int particionarVetor(ColecaoDePessoas listaDePessoas, int inicio, int fim) {
			int esquerda, direita;
			Pessoa pivo;
			esquerda = inicio;
			direita = fim;
			pivo = listaDePessoas.obterPessoa(inicio);
			while (esquerda < direita) {
				while (listaDePessoas.obterPessoa(esquerda).obterDataDeNacimento() <= pivo.obterDataDeNacimento() && esquerda < fim) {
					esquerda++;
				}
				while (listaDePessoas.obterPessoa(direita).obterDataDeNacimento() > pivo.obterDataDeNacimento() && direita > inicio) {
					direita--;
				}
				if (esquerda < direita) {
					listaDePessoas.trocarPosicoesEntreDuasPessoas(esquerda, direita);
				}
			}
			listaDePessoas.alterarPessoa(inicio, listaDePessoas.obterPessoa(direita));
			listaDePessoas.alterarPessoa(direita, pivo);
			return direita;
	}

}
