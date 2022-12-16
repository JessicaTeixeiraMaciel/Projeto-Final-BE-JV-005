package aplicacao;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        File arquivo = new File("src/recursos/banco/nomes.txt");

        try {
            if (!arquivo.exists()) {
                //cria um arquivo (vazio)
                arquivo.createNewFile();
            }


            //caso seja um diretório, é possível listar seus arquivos e diretórios
            File[] arquivos = arquivo.listFiles();


            //escreve no arquivo
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Dados da pessoa serapados por virgula em uma única string");
            bw.newLine();
            bw.close();

            fw.close();


            //faz a leitura do arquivo
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);

            //enquanto houver mais linhas
            int i = 0;
            while (br.ready()) {
                //lê a proxima linha
                String linha = br.readLine();
                //faz algo com a linha
                if (linha.equals("Mateus")){
                    linha = "";
                    i++;
                }
                System.out.println(linha);
            }
            System.out.println("removi " + i + "Mateus");
            br.close();
            fr.close();


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}