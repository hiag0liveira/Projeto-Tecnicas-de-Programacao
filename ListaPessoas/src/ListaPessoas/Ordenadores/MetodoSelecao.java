package ListaPessoas.Ordenadores;

import ListaPessoas.ColecaoDePessoas;

public class MetodoSelecao implements Ordenador {

	@Override
	public void PorAnoDeNascimento(ColecaoDePessoas listaDePessoas, int inicio, int fim) {
		 int QuantidadeDePessoas = listaDePessoas.obterTotalDePessoas();
         for(int i = 0; i < QuantidadeDePessoas; i++){
           int menorAnoDeNascimento = i;
           for(int j = i + 1; j < QuantidadeDePessoas; j++){
               if(listaDePessoas.obterPessoa(j).obterDataDeNacimento() < listaDePessoas.obterPessoa(menorAnoDeNascimento).obterDataDeNacimento()){
                   menorAnoDeNascimento = j;
               }

           }
           listaDePessoas.trocarPosicoesEntreDuasPessoas(menorAnoDeNascimento, i);     
       } 
       
	}

}
