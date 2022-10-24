package ListaPessoas;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import ListaPessoas.Ordenadores.MetodoBolha;
import ListaPessoas.Ordenadores.MetodoInsercao;
import ListaPessoas.Ordenadores.MetodoQuickSort;
import ListaPessoas.Ordenadores.MetodoSelecao;
import ListaPessoas.TiposLeitores.ArrayListDePessoas;
import ListaPessoas.TiposLeitores.VetorDePessoas;
import ListaPessoas.TiposLeitores.Encadeada.ListaEncadeadaDePessoas;

public class ExercicioDatasetPessoas {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		DatasetPessoas datasetpessoas = new DatasetPessoas();
		String caminhoDoArquivo = "C:\\Users\\win10\\Desktop\\IFF\\3 Terceiro periodo\\TpPresencial\\ReduzidoAgeDataset-V1.csv";
		ColecaoDePessoas listaDePessoas = null; 
			@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("Como deseja criar a Coleção de pessoas?\n"
				+ "1 = Vetor\n"
				+ "2 = ArrayList\n"
				+ "3 = Lista Encadeada");
		int TipoDeArmazenador = teclado.nextInt();
		if (TipoDeArmazenador == 1) {
			listaDePessoas = datasetpessoas.lerDoArquivo(caminhoDoArquivo, new VetorDePessoas());
		}
		else if (TipoDeArmazenador == 2) {
			listaDePessoas = datasetpessoas.lerDoArquivo(caminhoDoArquivo, new ArrayListDePessoas());
		}
		else if (TipoDeArmazenador == 3) {
			listaDePessoas = datasetpessoas.lerDoArquivo(caminhoDoArquivo, new ListaEncadeadaDePessoas());
		}
		else {
			System.out.println("Opção inválida!");
		}
		int escolha = 100;
		while (escolha != 0) { 
			System.out.println("O que deseja fazer?\n"
					+ "1 = listar pessoas\n"
					+ "2 = obter pessoa\n"
					+ "3 = obter total de pessoas\n"
					+ "4 = incluir pessoa no final da lista\n"
					+ "5 = incluir pessoa em um indice\n"
					+ "6 = excluir ultima pessoa\n"
					+ "7 = excluir pessoa por indice\n"
					+ "8 = excluir pessoa por nome\n"
					+ "9 = ordenar pelo ano de nascimento\n"
					+ "0 = sair do programa");
			escolha = teclado.nextInt();
			switch (escolha) {
			case 1:
				int numeroDoRegistro = 0;
				Pessoa pessoa = null;
				for (int numeroDaPessoa = 0; numeroDaPessoa < listaDePessoas.obterTotalDePessoas(); numeroDaPessoa++) {
					pessoa = listaDePessoas.obterPessoa(numeroDaPessoa);
					System.out.println("***Registro número: " + numeroDoRegistro + "***");
					System.out.println("Nome: " + pessoa.obterNome());
					System.out.println("Descrição: " + pessoa.obterDescricao());
					System.out.println("Gênero: " + pessoa.obterGenero());
					System.out.println("País: " + pessoa.obterPais());
					System.out.println("Ocupação:" + pessoa.obterOcupacao());
					System.out.println("Data de nascimento:" + pessoa.obterDataDeNacimento());
					System.out.println("Data de falecimento:" + pessoa.obterDataDeFalecimento() + "\n\n");
					numeroDoRegistro++;
				}
				break;
			case 2:
				System.out.print("Informe o indice da pessoa: ");
				int indice = teclado.nextInt();
				Pessoa objPessoa = listaDePessoas.obterPessoa(indice);
				System.out.println("Nome: " + objPessoa.obterNome());
				System.out.println("Descrição: " + objPessoa.obterDescricao());
				System.out.println("Gênero: " + objPessoa.obterGenero());
				System.out.println("País: " + objPessoa.obterPais());
				System.out.println("Ocupação:" + objPessoa.obterOcupacao());
				System.out.println("Data de nascimento:" + objPessoa.obterDataDeNacimento());
				System.out.println("Data de falecimento:" + objPessoa.obterDataDeFalecimento() + "\n\n");
				break;
			case 3:
				System.out.println("O total de pessoas é: " + listaDePessoas.obterTotalDePessoas());
				break;
			case 4:
				{
				System.out.print("Nome: ");
				String nomePessoa = teclado.nextLine();
				
				System.out.print("descrição: ");
				String descricao = teclado.nextLine();
				
				System.out.print("Gênero: ");
				String genero = teclado.nextLine();
				
				System.out.print("País: ");
				String pais = teclado.nextLine();
				
				System.out.print("Ocupação: ");
				String ocupacao = teclado.nextLine();
				
				System.out.print("Data de nascimento: ");
				int dataDeNascimento = teclado.nextInt();
				
				System.out.print("Data de falecimento: ");
				int dataDeFalecimento = teclado.nextInt();
				Pessoa objPessoa2 = new Pessoa(nomePessoa, descricao, genero, pais, ocupacao, dataDeNascimento, dataDeFalecimento);
				
				listaDePessoas.adicionarPessoa(objPessoa2);
				System.out.println("Pessoa adicionada com sucesso!!!");
				}
				break;
			case 5:
				System.out.print("Nome: ");
				String nomePessoa = teclado.nextLine();
				
				System.out.print("descrição: ");
				String descricao = teclado.nextLine();
				
				System.out.print("Gênero: ");
				String genero = teclado.nextLine();
				
				System.out.print("País: ");
				String pais = teclado.nextLine();
				
				System.out.print("Ocupação: ");
				String ocupacao = teclado.nextLine();
				
				System.out.print("Data de nascimento: ");
				int dataDeNascimento = teclado.nextInt();
				
				System.out.print("Data de falecimento: ");
				int dataDeFalecimento = teclado.nextInt();
				Pessoa objPessoa2 = new Pessoa(nomePessoa, descricao, genero, pais, ocupacao, dataDeNascimento, dataDeFalecimento);
				
				System.out.print("Informe o indice: ");
				int indice2 = teclado.nextInt();
				
				listaDePessoas.adicionarPessoaPorIndice(indice2, objPessoa2);
				System.out.println("Pessoa adicionada com sucesso!!!");
				break;
			case 6:
				boolean excluido = listaDePessoas.excluirUltimaPessoa();
				if (excluido) {
					System.out.println("Pessoa excluida com sucesso!");
				}
				else {
					System.out.println("Erro ao excluir pessoa");
				}
				break;
				
			case 7:
				System.out.print("Informe o indice da pessoa a ser excluida: ");
				int indiceParaExclusao = teclado.nextInt();
				boolean foiExcluido = listaDePessoas.excluirPessoaPorIndice(indiceParaExclusao);
				if (foiExcluido == true) {
					System.out.println("Pessoa excluida com sucesso!");
				}
				else {
					System.out.println("Erro ao excluir pessoa");
				}	
				break;
				
			case 8:
				System.out.println("Informe o nome da pessoa a ser excluida: ");
				@SuppressWarnings("unused") String limparBufferTeclado = teclado.nextLine();
				String nomeExcluir = teclado.nextLine();
				boolean excluirNome = listaDePessoas.excluirPessoaPorNome(nomeExcluir);
				if ( excluirNome == true) {
					System.out.println("Pessoa excluida com sucesso!");
				}
				else {
					System.out.println("Erro ao excluir pessoa");
				}
				break;
				
			case 9:
				System.out.println("Por qual metodo deseja ordenar ?\n"
						+ "1 = Ordenar Pelo Metodo de Bolha\n"
						+ "2 = Ordenar Pelo Metodo de Selecao\n"
						+ "3 = Ordenar Pelo Metodo de Insercao\n"
						+ "4 = Ordenar Pelo Metodo de QuickSort\n");
				int escolherTipoDeOrdenador = teclado.nextInt();
				switch (escolherTipoDeOrdenador) {
					case 1:
						listaDePessoas.ordenarLista(new MetodoBolha());
						System.out.println("Ordenado com sucesso!");
					break;
					
					case 2:
						listaDePessoas.ordenarLista(new MetodoSelecao());
						System.out.println("Ordenado com sucesso!");
					break;
					
					case 3:
						listaDePessoas.ordenarLista(new MetodoInsercao());
						System.out.println("Ordenado com sucesso!");
					break;
					
					case 4:
						listaDePessoas.ordenarLista(new MetodoQuickSort());
						System.out.println("Ordenado com sucesso!");
					break;
					default:
						System.out.println("Opção inválida!!!");
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida!!!");
			}
		}
		
	}
	
}
