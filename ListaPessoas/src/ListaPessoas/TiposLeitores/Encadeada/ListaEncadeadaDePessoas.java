package ListaPessoas.TiposLeitores.Encadeada;

import ListaPessoas.ColecaoDePessoas;
import ListaPessoas.Pessoa;
import ListaPessoas.Ordenadores.Ordenador;

public class ListaEncadeadaDePessoas implements ColecaoDePessoas {
	
	No inicio = null;
	private int totalDePessoas=0;

	@Override
	public void adicionarPessoa(Pessoa pessoa) {
	     No novoNo = new No(pessoa);
			No noAtual = this.inicio;
			if (this.inicio != null) {
				while (noAtual.proximo != null) {
					noAtual = noAtual.proximo;
				}
				noAtual.proximo = novoNo;
			} else {
				this.inicio = novoNo;
			}
			totalDePessoas++;
	        
	    }
	@Override
	public void adicionarPessoaPorIndice(int indicePessoa, Pessoa pessoa) {
		No novoNo = new No(pessoa);
        No noAtual = this.inicio;
        No noAnterior = null;
        int posicaoAtual = 0;

        while ((noAtual != null) && (indicePessoa != posicaoAtual)) {
            noAnterior = noAtual;
            noAtual = noAtual.proximo;
            posicaoAtual++;
        }

        if (indicePessoa == posicaoAtual) {
            if (noAnterior == null) {
                novoNo.proximo = this.inicio;
                this.inicio = novoNo;
            }
            else {
                noAnterior.proximo = novoNo;
                novoNo.proximo = noAtual;
            }
        }   
        totalDePessoas++;
	}

	@Override
	public boolean excluirUltimaPessoa() {
		 No noAtual = this.inicio;
			No noAnterior = null;

			if (this.inicio != null) {
				while (noAtual.proximo != null) {
					noAnterior = noAtual;
					noAtual = noAtual.proximo;
				}
				if (noAnterior != null) {
					noAnterior.proximo = null;
				} else {
					this.inicio = null;
				}
				totalDePessoas--;
				return true;
			}
			return false;
	    }
	@Override
	public Pessoa obterPessoa(int posicaoDaPessoa) {
		 No noAtual = this.inicio;
		 No noAnterior = null;
		 int posicaoAtual = 0;
			
			if (this.inicio != null) {
				while ((noAtual != null) && (posicaoDaPessoa != posicaoAtual)) {
					noAnterior = noAtual;
					noAtual = noAtual.proximo;
					posicaoAtual++;
				}
				
				return noAtual.dado;
		
			}
			return null;
	}
	
	@Override
	public int obterTotalDePessoas() {
		return this.totalDePessoas;
	}
	@Override
	public boolean excluirPessoaPorIndice(int indice) {
		No noAtual = this.inicio;
        No noAnterior = null;
        int posicaoAtual = 0;

        if (this.inicio != null) {
            while ((noAtual.proximo != null) && (indice != posicaoAtual)) {
                noAnterior = noAtual;
                noAtual = noAtual.proximo;
                posicaoAtual++;
            }
            if (indice == posicaoAtual) {
                if (noAnterior == null) {
                    this.inicio = noAtual.proximo;
                }
                else {
                    noAnterior.proximo = noAtual.proximo;
                }
                totalDePessoas--;
                return true;
            }
        }
        return false;
	}
	@Override
	public boolean excluirPessoaPorNome(String nome) {
		  	No noAtual = this.inicio;
	        No noAnterior = null;
	        int posicaoAtual = 0;
	        while ((noAtual != null)) {
	            noAnterior = noAtual;
	            noAtual = noAtual.proximo;
	            
	            if(nome.equals(noAnterior.dado.obterNome())){ 
	            	excluirPessoaPorIndice(posicaoAtual);
	            	return true;
	            }
	            posicaoAtual++;
	            }    
	        return false;
	    }
	
	@Override
	public int buscarPessoasPorNome(String nome) {
		No noAtual = this.inicio;
        No noAnterior = null;
        int posicaoAtual = 0;
        while ((noAtual != null)) {
            noAnterior = noAtual;
            noAtual = noAtual.proximo;
            if(nome.equals(noAnterior.dado.obterNome())){
            	return posicaoAtual;
            }
            posicaoAtual++;
		}
		return -1;
	}
	
	
	@Override
	public void ordenarLista(Ordenador ordenador) {
		ordenador.PorAnoDeNascimento(this, 0, this.totalDePessoas - 1);	
	}
	@Override
	public void trocarPosicoesEntreDuasPessoas(int primeiraPosicao, int segundaPosicao) {
		Pessoa armazenamentoAuxiliar;
		armazenamentoAuxiliar = this.obterDado(primeiraPosicao);
		this.definirDado(primeiraPosicao, this.obterDado(segundaPosicao));
		this.definirDado(segundaPosicao, armazenamentoAuxiliar);
        }

	@Override
	public void alterarPessoa(int posicaoDaPessoa, Pessoa novaPessoa) {
		this.definirDado(posicaoDaPessoa, novaPessoa);
	}
	
	public Pessoa obterDado(int posicao) {
		if ((posicao >= 0) && (posicao < this.totalDePessoas)) {
			No noAtual = this.inicio;
			for (int cont = 0 ; cont < posicao; cont++) {
				noAtual = noAtual.obterProximo();
			}
			return noAtual.obterPessoa();
		}
		return null;
	}
	
	public void definirDado(int posicao, Pessoa pessoa) {
		if ((posicao >= 0) && (posicao < this.totalDePessoas)) {
			No noAtual = this.inicio;
			for (int cont = 0 ; cont < posicao; cont++) {
				noAtual = noAtual.obterProximo();
			}
			noAtual.definirPessoa(pessoa);
		}
	}
	
}
