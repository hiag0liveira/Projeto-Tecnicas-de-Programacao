package ListaPessoas.TiposLeitores.Encadeada;

import ListaPessoas.Pessoa;

public class No {
    public Pessoa dado;
	public No proximo;

	public No(Pessoa dado) {
		this.dado = dado;
		this.proximo = null;
	}
	
	public Pessoa obterPessoa() {
		return dado;
	}

	public void definirPessoa(Pessoa pessoa) {
		this.dado = pessoa;
	}

	public No obterProximo() {
		return proximo;
	}

	public void definirProximo(No proximo) {
		this.proximo = proximo;
	}
}
