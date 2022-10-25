package fila;

public class FilaSimples implements Fila {

	No topo = null;
	int quantidade = 0;

	@Override
	public boolean enfileirar(int dado) {
		No novoNo = new No(dado);
		No noAtual = this.topo;
		if (this.topo != null) {
			while (noAtual.proximo != null) {
				noAtual = noAtual.proximo;
			}			
			noAtual.proximo = novoNo;
			quantidade++;
			return true;
		} else {
			if (this.topo == null) {
				this.topo = novoNo;
				quantidade++;
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public String desenfileirar() {
		No noAtual = this.topo;
		if (this.topo != null) {
			if (this.topo.proximo != null) {
				this.topo = this.topo.proximo;
			} else {
				this.topo = null;
			}
			quantidade--;
			return String.valueOf(noAtual.dado);
		}
		return "Fila vazia.";
	}

	@Override
	public String obterTopo() {
		if (this.topo != null) {
			return String.valueOf(this.topo.dado);
		}
		return "Fila vazia.";
	}

	@Override
	public boolean verificarConteudo() {
		if (this.topo != null) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String elementos = new String();
		No noAtual = this.topo;
		while (noAtual != null) {
			elementos = elementos + noAtual.dado + " ";
			noAtual = noAtual.proximo;
		}
		return "Fila [ " + elementos + "]";
	}
}