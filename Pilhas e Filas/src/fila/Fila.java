package fila;

public interface Fila {

	public boolean enfileirar(int dado);

	public String desenfileirar();

	public String obterTopo();

	public boolean verificarConteudo();

	@Override
	public String toString();
}