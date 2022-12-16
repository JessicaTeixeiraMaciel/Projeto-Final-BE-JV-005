package modelos.menus.menuInicial.opcao1;

import modelos.apartamentos.Apartamento;
import modelos.menus.menuInicial.MenuInicial;
import modelos.pessoas.Inquilino;
import modelos.pessoas.Proprietario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SelecionarApartamento extends MenuInicial {

    public void opcoesDoMenu(List<Apartamento> listaDeApartamentos, List<Proprietario> listaDeProprietarios, List<Inquilino> listaDeInquilinos) {
        limparTela();
        var numerosDosApartamentos = listaDeApartamentos.stream().map(Apartamento::getNumero);

        System.out.println(numerosDosApartamentos);

        do {
            textoColorido("amarelo","CONSULTAR DADOS DOS APARTAMENTOS");
            System.out.print("Insira o número do apartamento que deseja consultar (");
            System.out.println(numerosDosApartamentos.toString().replace("[","").replace("]","") + ")");
            System.out.println("Ou digite 'v' para voltar ao menu anterior.");
        } while (validarEscolha(numerosDosApartamentos.collect(Collectors.toList())));
        irParaOpcaoSelecionada(listaDeApartamentos,listaDeProprietarios,listaDeInquilinos);
    }

    @Override
    public boolean validarEscolha(List<String> listaDeOpcoes) {
        listaDeOpcoes.add("V");
        listaDeOpcoes.add("v");
        Scanner sc = new Scanner(System.in);
        textoColorido("ciano","Informe sua opção aqui:" );
        setEscolha(sc.next());
        if (!listaDeOpcoes.contains(getEscolha())){
            textoColorido("vermelho","Entrada inválida! Tente Novamente.\n");
        }
        return !listaDeOpcoes.contains(getEscolha());
    }


    public void irParaOpcaoSelecionada(List<Apartamento> listaDeApartamentos, List<Proprietario> listaDeProprietarios, List<Inquilino> listaDeInquilinos) {

        if (getEscolha().equals("V") || getEscolha().equals("v")){
            MenuInicial menuInicial = new MenuInicial();
            menuInicial.opcoesDoMenu();
        } else {
            limparTela();
            Apartamento apartamentoSelecionado = listaDeApartamentos.stream().filter(e -> e.getNumero().contains(getEscolha())).findFirst().orElseThrow();

//            MenuConsultarDadosDoApartamento menuConsultarDadosDoApartamento = new MenuConsultarDadosDoApartamento();
//            menuConsultarDadosDoApartamento.exibirDadosDoApartamento(apartamentoSelecionado, listaDeProprietarios,listaDeApartamentos,listaDeInquilinos,listaDeCilindros);
        }
    }

}
