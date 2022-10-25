package fila;

public class FilaVetor implements Fila {

	private int[] fila = new int[20];
	private int topo = 0;
	private int finalFila = -1;

	@Override
	public boolean enfileirar(int dado) {
		try {
			this.fila[this.finalFila + 1] = dado;
			this.finalFila++;
			return true;
		} catch(ArrayIndexOutOfBoundsException e)	{
			andarFila();
			if (this.finalFila < 19) {
				this.finalFila++;
				this.fila[this.finalFila] = dado;
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public String desenfileirar() {
		if (this.finalFila != -1) {
			int noAtual = this.fila[this.topo];
			if(this.topo == this.finalFila) {
				this.topo = 0;
				this.finalFila = -1;
				return String.valueOf(noAtual);
			} else {
				this.topo++;
				return String.valueOf(noAtual);
			}
		}
		return "Fila vazia.";
	}

	@Override
	public String obterTopo() {
		if (this.finalFila != -1) {
			return String.valueOf(this.fila[this.topo]);
		}
		return "Fila vazia.";
	}

	@Override
	public boolean verificarConteudo() {
		if (this.finalFila != -1) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String elementos = new String();
		int controle = this.topo;
		while (controle <= this.finalFila) {
			elementos = elementos + this.fila[controle] + " ";
			controle++;
		}
		return "Fila [ " + elementos + "]";
	}
	
	public void andarFila() {
		int controle = 0;
		while(this.topo + controle < this.finalFila) {
			this.fila[controle] = this.fila[this.topo + controle];
			controle++;
		}
		this.topo = 0;
		this.finalFila = controle;
	}
}