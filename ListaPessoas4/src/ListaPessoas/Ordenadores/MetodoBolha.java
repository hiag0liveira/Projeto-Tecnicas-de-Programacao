package ListaPessoas.Ordenadores;

import ListaPessoas.ColecaoDePessoas;

public class MetodoBolha implements Ordenador {

	@Override
	public void PorAnoDeNascimento(ColecaoDePessoas listaDePessoas, int inicio, int fim) {
			int i, j;
			int totalDePessoas = listaDePessoas.obterTotalDePessoas();
			
			for (i = 0; i < totalDePessoas; i++) {
				for (j = 0; j < totalDePessoas - i - 1; j++) {
					if (listaDePessoas.obterPessoa(j).obterDataDeNacimento() > listaDePessoas.obterPessoa(j + 1).obterDataDeNacimento()) {		
						listaDePessoas.trocarPosicoesEntreDuasPessoas(j,j+1);
					}
				}
			}
	}

}
