package ListaPessoas.Ordenadores;

import ListaPessoas.ColecaoDePessoas;
import ListaPessoas.Pessoa;

public class MetodoInsercao implements Ordenador {

	@Override
	public void PorAnoDeNascimento(ColecaoDePessoas listaDePessoas, int inicio, int fim) {
		 int QuantidadeDePessoas = listaDePessoas.obterTotalDePessoas();
	        int passadorInicial;
	        Pessoa auxiliar;

	        for(int passadorSecundario = 1; passadorSecundario < QuantidadeDePessoas; passadorSecundario++ ){
	            auxiliar = listaDePessoas.obterPessoa(passadorSecundario);
	            passadorInicial = passadorSecundario -1;
	            while (passadorInicial >= 0 && listaDePessoas.obterPessoa(passadorInicial).obterDataDeNacimento() > auxiliar.obterDataDeNacimento()) {
	                Pessoa p = listaDePessoas.obterPessoa(passadorInicial);
	                listaDePessoas.alterarPessoa(passadorInicial+1, p);
	                passadorInicial--;
	            }
	            listaDePessoas.alterarPessoa(passadorInicial+1, auxiliar);
	        }  

	}

}
