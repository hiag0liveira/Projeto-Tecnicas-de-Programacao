# Projeto Tecnicas de Programacao 

![status do projeto](https://img.shields.io/badge/STATUS-EM%20DESENVOLVIMENTO-orange)


> Codigos retirados das aulas de Tecnicas de Programação.
## Descrição
Este prjeto tem o objetivo de estudar a **manipulação, armazenamento e ordenação** de dados.

Foi feito um sistema que armazena informações de pessoas a partir de um [arquivo csv](https://www.kaggle.com/datasets/imoore/age-dataset?resource=download).

Essas informações são:
- Nome 
- Descricão
- Gênero
- País
- Ocupacão
- Ano de nacimento
- Ano de falecimento

## Manipulação

 Cada linha do [arquivo csv](https://www.kaggle.com/datasets/imoore/age-dataset?resource=download) usado representa uma [pessoa](/Main/src/colecoes/Pessoa.java) com as suas devidas características.
 
 Para extrair essas informações foi criado uma classe que usa as APIs [FileReader](https://docs.oracle.com/javase/7/docs/api/java/io/FileReader.html) e [BufferedReader](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html).
 
 A classe recebeu o nome de [DataSetPessoas](/Main/src/dataset/DatasetPessoas.java) e possui os seguintes metodos:
 
 - lerDoArquivo()
 - escreverNoArquivo()
 
 ### Metodo lerDoArquivo()
 
 Este metodo tem o objetivo de receber o conteudo do arquivo, lendo-o linha por linha, criando um objeto da classe [Pessoa](/Main/src/colecoes/Pessoa.java) e armazenando esse objeto em uma [coleção de pessoas](/Main/src/colecoes/ColecaoDePessoas.java).
 
 Para isso o metodo recebe como parametro o **caminho do arquivo** a ser recolhido as informaçoes, e a **coleção de pessoas** que receberá os objetos criados dentro do metodo.
 
 ```
 public ColecaoDePessoas lerDoArquivo(String caminhoDoArquivo, ColecaoDePessoas listaDePessoas) {}
 ```

Dentro do metodo é instanciado um objeto de [FileReader](https://docs.oracle.com/javase/7/docs/api/java/io/FileReader.html), e para isso, é passado como parametro o caminho do arquivo a ser utilizado;

É instanciado logo em seguida um objeto de [BufferedReader](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html), recemendo o objeto fluxoDeLeituraDeArquivoTexto criado na linha anterior.

```
FileReader fluxoDeLeituraDeArquivoTexto = new FileReader(caminhoDoArquivo);
BufferedReader leituraBufferizada = new BufferedReader(fluxoDeLeituraDeArquivoTexto);
```

A partir desse ponto, é utilixado o metodo readLine de [BufferedReader](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html), que retorna uma linha do arquivo em formato de String. Essa String é dividida em varios campos de um Array usando o metodo split(), onde o metodo recebe como parâmetro ","

## Armazenamento

## Ordenação
