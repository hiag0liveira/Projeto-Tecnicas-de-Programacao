package ListaPessoas;

import ListaPessoas.Ordenadores.Ordenador;

public interface ColecaoDePessoas {
	
	public void adicionarPessoa(Pessoa pessoa);
	
	public void adicionarPessoaPorIndice(int indice, Pessoa pessoa);
	
	public boolean excluirUltimaPessoa();
	
	public Pessoa obterPessoa(int posicaoDaPessoa);
	
	public int obterTotalDePessoas();
	
	public boolean excluirPessoaPorIndice(int indice);
	
	public boolean excluirPessoaPorNome(String nome);
	
	void ordenarLista(Ordenador ordenador);

	public void trocarPosicoesEntreDuasPessoas(int primeiraPosicao, int segundaPosicao);
	
	public void alterarPessoa(int posicaoDaPessoa, Pessoa novaPessoa);
}