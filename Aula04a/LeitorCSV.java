// Essa classe será responsável por abrir o arquivo csv, ler seus registros e transformar cada linha em um objeto, Cliente.
// Path: representa o caminho do arquivo
// Files: fornece métodos para trabalhar com arquivos
// BufferedReader: permite ler o arquivo linha por linha
// ArrayList: armazena os objetos

package Aula04a;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class LeitorCSV {

    // Método responsável por ler o CSV e retornar uma lista de clientes
    public ArrayList<Cliente> carregar (String caminhoArquivo) throws IOException{
        // Lista vazia para armazenar os clientes
        ArrayList<Cliente> clientes = new ArrayList<>();

        // Objeto do tipo path
        Path caminho = Path.of(caminhoArquivo);

        // Abre o arquivo para a leitura utilizando a codificação UTF-8
        try (BufferedReader leitor = Files.newBufferedReader(caminho, StandardCharsets.UTF_8)){

            // Variavel que armazena cada linha 
            String linha;

            // Inicializar o contador de linhas
            int numeroLinha = 0;

            // Lê o arquivo enquanto existirem linhas 
            while ((linha = leitor.readLine()) != null){

                // Incremento da linha
                numeroLinha++;

                // Ignora a primeira linha
                if (numeroLinha == 1){
                    continue;
                }

                // Dividie a linha em campos utilizando a virgula como separador;

                String[] dados = linha.split(",", -1);

                // Verifica se a linha possui 3 campos 
                if (dados.length != 3){
                    throw new IOException("Quantidade de colunas inválida na linha " + numeroLinha);
                } 

                // remove espaçamentos em branco
                String textoVisitas = dados[0].trim();
                String textoCompra = dados[1].trim();
                String textoCunjunto = dados[2].trim();

                // Variável que recebe as visitas
                int visitas;

                try{
                    visitas = Integer.parseInt(textoVisitas);
                } catch (NumberFormatException e){
                    throw new IOException("Quantidade de visitas inválidas na linha " + numeroLinha, e);
                }

                // Variável do resultado da compra
                boolean compra;

                if (textoCompra.equalsIgnoreCase("sim")){
                    compra = true;
                } else if (textoCompra.equalsIgnoreCase("Nao") || textoCompra.equalsIgnoreCase("Não")){
                    compra = false;
                } else {
                    throw new IOException("Resultado de compra inválida na linha " + numeroLinha);
                }

                // Verifica se o conjunto é treino ou teste
                if (!textoCunjunto.equalsIgnoreCase("treino") && !textoCunjunto.equalsIgnoreCase("teste")) {
                    throw new IOException("Conjunto inválido na linha " + numeroLinha);
                }

                // Cria um objeto Cliente com os dados da linha atual
                Cliente cliente = new Cliente(visitas, compra, textoCunjunto);

                // Adiciona o objeto criado cliente na lista de clientes
                clientes.add(cliente);
            }

        }
        return clientes;
    }

}
