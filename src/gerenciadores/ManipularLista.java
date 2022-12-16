package gerenciadores;

import modelos.genericos.Objeto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManipularLista {

    public List criarLista(String caminhoDoArquivo, Objeto objeto){
        File arquivo = new File(caminhoDoArquivo);
        List<String> banco = new ArrayList<>();
        List lista = new ArrayList<>();
        try {
            if (!arquivo.exists()) {arquivo.createNewFile();}
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                String linha = br.readLine();
                banco.add(linha);
                String[] linhaDividida = linha.split(";");
                lista.add(objeto.lerBanco(List.of(linhaDividida)));}
            br.close();
            fr.close();
        } catch (IOException ex) {ex.printStackTrace();}
        return lista;
    }
}
