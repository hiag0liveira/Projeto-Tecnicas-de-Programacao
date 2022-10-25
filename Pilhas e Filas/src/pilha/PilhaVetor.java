package pilha;

public class PilhaVetor implements Pilha {

	int[] pilha = new int[20];
	int topo = -1;

	@Override
	public boolean empilhar(int dado) {
		if (this.topo < 19) {
			this.topo++;
			this.pilha[this.topo] = dado;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String desempilhar() {
		if (this.topo != -1) {
			this.topo--;
			return String.valueOf(this.pilha[this.topo+1]);
		}
		return "Pilha vazia.";
	}

	@Override
	public String obterTopo() {
		if (this.topo != -1) {
			return String.valueOf(this.pilha[this.topo]);
		}
		return "Pilha vazia.";
	}

	@Override
	public boolean verificarConteudo() {
		if (this.topo != -1) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String elementos = new String();
		int noAtual = this.topo;
		while (noAtual != -1) {
			elementos = elementos + this.pilha[noAtual] + " ";
			noAtual--;
		}
		return "Pilha [ " + elementos + "]";
	}
}