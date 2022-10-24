package ListaPessoas.TiposLeitores;
import ListaPessoas.ColecaoDePessoas;
import ListaPessoas.Pessoa;
import ListaPessoas.Ordenadores.Ordenador;


public class VetorDePessoas implements ColecaoDePessoas{
	private Pessoa listaDePessoas[];
	private int totalDePessoas;

	public VetorDePessoas() {
		this.listaDePessoas = new Pessoa[1094379];
		this.totalDePessoas = 0;
	}
	
	public VetorDePessoas(int tamanhoMaximoDaLista) {
		this.listaDePessoas = new Pessoa[tamanhoMaximoDaLista];
		this.totalDePessoas = 0;
	}
	
	@Override
	public void adicionarPessoa(Pessoa pessoa) {
		this.listaDePessoas[totalDePessoas] = pessoa;
		this.totalDePessoas++;
	}
	
	@Override
	public boolean excluirUltimaPessoa() {
		if (this.totalDePessoas > 0) {
			this.totalDePessoas--;
			return true;
		}
		return false;
	}
	
	@Override
	public Pessoa obterPessoa(int indiceDaPessoa) {
		return this.listaDePessoas[indiceDaPessoa];
	}
	
	@Override
	public int obterTotalDePessoas() {
		return this.totalDePessoas;
	}
	
	@Override
    public void adicionarPessoaPorIndice(int indice, Pessoa pessoa) {
		Pessoa[] vetorAuxiliar = new Pessoa[listaDePessoas.length+1];
		int cont = 0;
		while (cont < indice) {
			vetorAuxiliar[cont]=listaDePessoas[cont];
			cont++;
		}
		if (cont == indice) {
			vetorAuxiliar[cont] = pessoa;
		}
		while (cont < listaDePessoas.length) {
			vetorAuxiliar[cont+1] = listaDePessoas[cont];
			cont++;
		}
		listaDePessoas = vetorAuxiliar;
		this.totalDePessoas++;
    }

	@Override
	public boolean excluirPessoaPorIndice(int indice) {
		if (this.totalDePessoas > 0) {
			Pessoa[] vetorAuxiliar = new Pessoa [listaDePessoas.length-1];
			int cont = 0;
			while (cont < indice) {
				vetorAuxiliar[cont]=listaDePessoas[cont];
				cont++;
			}
			while ((cont+1)<listaDePessoas.length) {
				vetorAuxiliar[cont]=listaDePessoas[cont+1];
				cont++;
			}
			listaDePessoas=vetorAuxiliar;
			this.totalDePessoas--;
			return true;
		}
		return false;
	}

	@Override
	public int buscarPessoasPorNome(String nome) {
			if (this.totalDePessoas > 0) {
				for (int posicao = 0; posicao < totalDePessoas; posicao++) {
					 String nomeComparado = this.listaDePessoas[posicao].obterNome();
					 
					if (nome.equals(nomeComparado)) {
						return posicao;
					}
				}
			}
			return -1;
	}

	@Override
	public boolean excluirPessoaPorNome(String nome) {
		if (this.totalDePessoas > 0) {
			int indicePessoa=-1;
			for (int posicao = 0; posicao < totalDePessoas; posicao++) {
				 String nomeComparado = this.listaDePessoas[posicao].obterNome();
				 
				if (nome.equals(nomeComparado)) {
					indicePessoa = posicao;
					break;
				}
			}
			if (indicePessoa>=0) {
				excluirPessoaPorIndice(indicePessoa);
				return true;
			}
		}
		return false;
	}

	@Override
	public void ordenarLista(Ordenador ordenador) {
			ordenador.PorAnoDeNascimento(this, 0, this.totalDePessoas - 1);
	}
	
	@Override
	public void trocarPosicoesEntreDuasPessoas(int primeiraPosicao, int segundaPosicao)  {
		Pessoa armazenamentoAuxiliar; 
		armazenamentoAuxiliar = this.listaDePessoas[primeiraPosicao];
		this.listaDePessoas[primeiraPosicao] = this.listaDePessoas[segundaPosicao];
		this.listaDePessoas[segundaPosicao] = armazenamentoAuxiliar;
		
	}

	@Override
	public void alterarPessoa(int posicaoDaPessoa, Pessoa novaPessoa) {
		this.listaDePessoas[posicaoDaPessoa] = novaPessoa;
		
	}


}
