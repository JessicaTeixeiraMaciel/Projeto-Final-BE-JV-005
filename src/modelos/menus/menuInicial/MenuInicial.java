package modelos.menus.menuInicial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuInicial {
    private String escolha;
    List<String> listaDeOpcoes = new ArrayList<>();

    public void boasVindas(){
        limparTela();
        System.out.println("Seja bem vindo ao gerenciador de consumo de gás do condomínio");
        textoColorido("ciano",
                "  ____                           _                                               _                \n" +
                        " |  _ \\    ___   ___            | |   __ _    ___    __ _   _ __    ___    ___  (_)   ___    __ _ \n" +
                        " | |_) |  / _ \\ / __|        _  | |  / _` |  / __|  / _` | | '__|  / _ \\  / __| | |  / __|  / _` |\n" +
                        " |  _ <  |  __/ \\__ \\  _    | |_| | | (_| | | (__  | (_| | | |    |  __/ | (__  | | | (__  | (_| |\n" +
                        " |_| \\_\\  \\___| |___/ (_)    \\___/   \\__,_|  \\___|  \\__,_| |_|     \\___|  \\___| |_|  \\___|  \\__,_|\n\n");
    }


    public String opcoesDoMenu(){
        listaDeOpcoes.add("Consultar dados dos apartamentos");
        listaDeOpcoes.add("Consultar trocas de cilindros");
        listaDeOpcoes.add("Consultar Lista de Fornecedores");
        listaDeOpcoes.add("Sair");
        boasVindas();
        do {
            System.out.println("O que deseja fazer?");
            imprimirListaDeOpcoes(listaDeOpcoes);
        } while (validarEscolha(enumerarOpcoes(listaDeOpcoes)));
        return escolha;
    }


    public boolean validarEscolha(List<String> listaDeOpcoes){
        Scanner sc = new Scanner(System.in);
        textoColorido("ciano","Informe sua opção aqui:");
        setEscolha(sc.next());
        if (!listaDeOpcoes.contains(getEscolha())){
            textoColorido("vermelho","Entrada inválida! Tente Novamente.\n");
        }
        return !listaDeOpcoes.contains(getEscolha());
    }


    public void limparTela(){
        for (int i = 0; i < 50; i++){
            System.out.println("\n");
        }
    }

    public void textoColorido (String cor, String texto){
        String corSelecionada;
        String resetCor = "\u001B[0m";
        switch (cor){
            case "vermelho": corSelecionada = "\u001B[31m"; break;
            case "amarelo": corSelecionada = "\u001B[33m"; break;
            case "cinza": corSelecionada = "\u001B[37m"; break;
            case "ciano": corSelecionada = "\u001B[36m"; break;
            default: corSelecionada = "\u001B[30m";
        }
        System.out.println(corSelecionada + texto + resetCor);
    }

    public void separador(){
        String cor = "\u001B[37m";
        String resetCor = "\u001B[0m";
        int tamanhoDoSeparador = 100;
        for (int i = 0; i < tamanhoDoSeparador; i++){
            System.out.print(cor + "-" + resetCor);
        }
        System.out.println();
    }

    public void imprimirListaDeOpcoes (List<String> listaDeOpcoes){
        int i = 1;
        for (String opcao : listaDeOpcoes){
            System.out.println(i + " - " + opcao);
            i++;
        }
    }

    public List<String> enumerarOpcoes(List<String> listaDeOpcoes){
        List<String> enumeracao = new ArrayList<>();
        listaDeOpcoes.forEach(e -> enumeracao.add(String.valueOf(listaDeOpcoes.indexOf(e))));
        return enumeracao;
    }

    public List<String> opcaoSimNao (){
        listaDeOpcoes.add("s");
        listaDeOpcoes.add("S");
        listaDeOpcoes.add("n");
        listaDeOpcoes.add("N");
        return listaDeOpcoes;
    }


    public void sairDoSistema (){
        System.out.println("Tchau! Até a próxima! :)");
    }

    public String getEscolha() {
        return escolha;
    }

    public void setEscolha(String escolha) {
        this.escolha = escolha;
    }

}
