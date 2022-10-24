package ListaPessoas;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DatasetPessoas {
	public ColecaoDePessoas lerDoArquivo(String caminhoDoArquivo, ColecaoDePessoas listaDePessoas) throws FileNotFoundException, IOException {
		FileReader fluxoDeLeituraDeArquivoTexto = new FileReader(caminhoDoArquivo);
		BufferedReader leituraBufferizada = new BufferedReader(fluxoDeLeituraDeArquivoTexto);
		String linhaLidaDoArquivo = leituraBufferizada.readLine();
		String listaDeCampos[];
		
		Pessoa pessoa = null;
		int numeroPessoa = 0;
		while (linhaLidaDoArquivo != null) {		
			listaDeCampos = linhaLidaDoArquivo.split(",");
			if (listaDeCampos.length == 10) {
				try {	
					int dataDeNacimento  = Integer.parseInt(listaDeCampos[6]);
					int dataDeFalecimento  = Integer.parseInt(listaDeCampos[7]);
					pessoa = new Pessoa(listaDeCampos[1], listaDeCampos[2], listaDeCampos[3], listaDeCampos[4], listaDeCampos[5], dataDeNacimento,  dataDeFalecimento);
					listaDePessoas.adicionarPessoa(pessoa);

				} catch (java.lang.NumberFormatException e) {
			
			}
		}
			linhaLidaDoArquivo = leituraBufferizada.readLine(); 
		}
		fluxoDeLeituraDeArquivoTexto.close();
		return listaDePessoas;
	}

	public void escreverNoArquivo(String caminhoDoArquivo, ColecaoDePessoas listaDePessoas) throws IOException {
		 FileWriter fluxoDeEscritaDeArquivoTexto = new FileWriter(caminhoDoArquivo, false);
		 int totalDePessoas = listaDePessoas.obterTotalDePessoas();
		 Pessoa pessoa = null;
		 for (int numeroDaPessoa = 0; numeroDaPessoa < listaDePessoas.obterTotalDePessoas(); numeroDaPessoa++) {
			 pessoa = listaDePessoas.obterPessoa(numeroDaPessoa);
			 fluxoDeEscritaDeArquivoTexto.write(pessoa.obterNome() + ",");
			 fluxoDeEscritaDeArquivoTexto.write(pessoa.obterDescricao() + ",");
			 fluxoDeEscritaDeArquivoTexto.write(pessoa.obterGenero() + ",");
			 fluxoDeEscritaDeArquivoTexto.write(pessoa.obterPais() + ",");
			 fluxoDeEscritaDeArquivoTexto.write(pessoa.obterOcupacao() + ",");
			 fluxoDeEscritaDeArquivoTexto.write(pessoa.obterDataDeNacimento() + ",");
			 fluxoDeEscritaDeArquivoTexto.write(pessoa.obterDataDeFalecimento());
			 fluxoDeEscritaDeArquivoTexto.write("\n");			 
		 }
		 fluxoDeEscritaDeArquivoTexto.flush();
		 fluxoDeEscritaDeArquivoTexto.close();
	}
}
