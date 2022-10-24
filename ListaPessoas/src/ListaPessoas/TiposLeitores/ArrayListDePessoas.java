package ListaPessoas.TiposLeitores;

import java.util.ArrayList;

import ListaPessoas.ColecaoDePessoas;
import ListaPessoas.Pessoa;
import ListaPessoas.Ordenadores.Ordenador;

public class ArrayListDePessoas implements ColecaoDePessoas{
	private ArrayList <Pessoa> listaDePessoas= null;
	private int totalDePessoas;

	public ArrayListDePessoas() {
		listaDePessoas = new ArrayList<Pessoa>();
		new ArrayList<Pessoa>();
		this.totalDePessoas = 0;
	}
	
	@Override
	public void adicionarPessoa(Pessoa pessoa) {
		this.listaDePessoas.add(pessoa);
		this.totalDePessoas++;
	}
	
	@Override
	public boolean excluirUltimaPessoa() {
		if (this.totalDePessoas > 0) {
			this.listaDePessoas.remove(totalDePessoas);
			this.totalDePessoas--;
			return true;
		}
		return false;
	}
	
	@Override
	public Pessoa obterPessoa(int indiceDaPessoa) {
		return this.listaDePessoas.get(indiceDaPessoa);
	}
	
	@Override
	public int obterTotalDePessoas() {
		return this.totalDePessoas;
	}

	@Override
	public void adicionarPessoaPorIndice(int indice, Pessoa pessoa) {
		this.listaDePessoas.add(indice, pessoa);
		this.totalDePessoas++;
	}

	@Override
	public boolean excluirPessoaPorIndice(int indice) {
		if (this.totalDePessoas > 0) {
			this.listaDePessoas.remove(indice);
			this.totalDePessoas--;
			return true;
		}
		return false;
	}
	
	@Override
	public int buscarPessoasPorNome(String nome) {
		if (this.totalDePessoas > 0) {
			for (int posicao = 0; posicao < totalDePessoas; posicao++) {		 
				if (listaDePessoas.get(posicao).obterNome().toLowerCase().equals(nome.toLowerCase())) {
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
			for (int cont = 0; cont < listaDePessoas.size(); cont++) {
				if (listaDePessoas.get(cont).obterNome().toLowerCase().equals(nome.toLowerCase())) {
					indicePessoa = cont;
					break;
				}
			}
			if (indicePessoa>=0) {
				this.listaDePessoas.remove(indicePessoa);
				this.totalDePessoas--;
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
	public void trocarPosicoesEntreDuasPessoas(int primeiraPosicao, int segundaPosicao) {
		Pessoa armazenamentoAuxiliar; 
		armazenamentoAuxiliar = this.listaDePessoas.get(primeiraPosicao);
		this.listaDePessoas.set(primeiraPosicao, this.listaDePessoas.get(segundaPosicao));
		this.listaDePessoas.set(segundaPosicao, armazenamentoAuxiliar);
		
	}

	@Override
	public void alterarPessoa(int posicaoDaPessoa, Pessoa novaPessoa) {
		 this.listaDePessoas.add(posicaoDaPessoa, novaPessoa);  
	}



}
