package fila;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner entradaDoTeclado = new Scanner(System.in);
		System.out.println("Qual tipo de Fila gostaria de inicializar?\n"
				+ "1 - Fila Simples\n"
				+ "2 - Fila Vetor\n");
		int opcaoDoMenu = entradaDoTeclado.nextInt();
		entradaDoTeclado.nextLine();
		Fila fila;
		if(opcaoDoMenu == 1) {
			fila = new FilaSimples();
		} else {
			fila = new FilaVetor();
		}
		while (opcaoDoMenu != 0) { 
			System.out.println("\n#################################");
			System.out.println("O que deseja fazer?\n"
					+ "1 - Enfileirar número\n"
					+ "2 - Desenfileirar número\n" 
					+ "3 - Obter frente\n"
					+ "4 - Verificar se está vazia\n"
					+ "5 - Listar conteúdo\n"
					+ "0 - Sair\n");
			opcaoDoMenu = entradaDoTeclado.nextInt();
			switch (opcaoDoMenu) {
					case 1:
						System.out.println("Entre com o número: ");
						boolean verificarSeFoiEmpilhado = fila.enfileirar(entradaDoTeclado.nextInt());
						if(verificarSeFoiEmpilhado == true) {
							System.out.println(" Enfileirado com Sucesso");
						} else {System.out.println("Não foi possivel Empilhar");}
						break;
						
					case 2:
						System.out.println("Foi desenfileirado o "+fila.desenfileirar());
						break;
	
					case 3:
						System.out.println("O conteudo do topo é "+fila.obterTopo());
						break;
					
					case 4:
						boolean n = fila.verificarConteudo();
						if (n) {
							System.out.println("A fila não está vazia.");
						} else {
							System.out.println("A fila está vazia.");
						}
						break;
			
					case 5:
						System.out.println(fila.toString());
						break;
					
					case 0:
						break;
						
					default:
						System.out.println("Opção inválida!!!");	
						
			}
		}
	}
}
