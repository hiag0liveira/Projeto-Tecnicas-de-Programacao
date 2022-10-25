package pilha;

public interface Pilha {

	public boolean empilhar(int dado);

	public String desempilhar();

	public String obterTopo();

	public boolean verificarConteudo();

	@Override
	public String toString();
}