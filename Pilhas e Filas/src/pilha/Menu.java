package pilha;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner entradaDoTeclado = new Scanner(System.in);
		System.out.println("Qual tipo de Pilha gostaria de inicializar?\n"
				+ "1 - Pilha Simples\n"
				+ "2 - Pilha Vetor\n");
		int opcaoDoMenu = entradaDoTeclado.nextInt();
		entradaDoTeclado.nextLine();
		Pilha pilha;
		if(opcaoDoMenu == 1) {
			pilha = new PilhaSimples();
		} else {
			pilha = new PilhaVetor();
		}
		while (opcaoDoMenu != 0) {
			System.out.println("\n#################################");
			System.out.println("O que deseja fazer?\n"
					+ "1 - Empilhar número\n"
					+ "2 - Desempilhar número\n"
					+ "3 - Obter topo\n"
					+ "4 - Verificar se está vazia\n"
					+ "5 - Listar conteúdo\n"
					+ "0 - Sair");
			
			opcaoDoMenu = entradaDoTeclado.nextInt();
			switch (opcaoDoMenu) {
				case 1:
					System.out.println("Entre com o número: ");
					boolean verificarSeFoiEmpilhado = pilha.empilhar(entradaDoTeclado.nextInt());
					if(verificarSeFoiEmpilhado == true) {
						System.out.println(" Empilhado com Sucesso");
					} else {System.out.println("Não foi possivel Empilhar");}
					break;
					
				case 2:
					System.out.println("Foi desempilhado o "+pilha.desempilhar());
					break;
					
				case 3:
					System.out.println("O conteudo do topo é  "+pilha.obterTopo());
					break;
					
				case 4:
					boolean n = pilha.verificarConteudo();
					if (n) {
						System.out.println("A pilha não está vazia.");
					} else {
						System.out.println("A pilha está vazia.");
					}
					break;
					
				case 5:
					System.out.println(pilha.toString());
					break;
					
				case 0:
					break;
					
				default:
					System.out.println("Opção inválida!!!");	
						
			}
		}
	}
}
						
