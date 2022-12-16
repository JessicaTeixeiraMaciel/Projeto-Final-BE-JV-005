package aplicacao;

import gerenciadores.ManipularLista;
import modelos.apartamentos.Apartamento;
import modelos.menus.menuInicial.MenuInicial;
import modelos.menus.menuInicial.opcao1.SelecionarApartamento;
import modelos.pessoas.Inquilino;
import modelos.pessoas.Proprietario;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        ManipularLista manipularLista = new ManipularLista();

        Apartamento apartamento = new Apartamento();
        List<Apartamento> listaDeApartamentos = new ArrayList<>(manipularLista.criarLista("src/recursos/banco/apartamentos.txt",apartamento));

        Proprietario proprietario = new Proprietario();
        List<Proprietario> listaDeProprietarios = new ArrayList<>(manipularLista.criarLista("src/recursos/banco/proprietarios.txt",proprietario));

        Inquilino inquilino = new Inquilino();
        List<Inquilino> listaDeInquilinos = new ArrayList<>(manipularLista.criarLista("src/recursos/banco/inquilinos.txt",inquilino));

        MenuInicial menuInicial = new MenuInicial();
        String opcaoSelecionada = menuInicial.opcoesDoMenu();

        switch (opcaoSelecionada){
            case "1":
                SelecionarApartamento selecionarApartamento = new SelecionarApartamento();
                selecionarApartamento.opcoesDoMenu(listaDeApartamentos,listaDeProprietarios,listaDeInquilinos);
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
        }

    }
}
