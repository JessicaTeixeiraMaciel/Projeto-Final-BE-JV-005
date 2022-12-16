package modelos.pessoas;

import interfaces.ObjetoLista;
import modelos.genericos.Objeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pessoa extends Objeto implements Serializable, ObjetoLista {

    private static final long serialVersionUID = 1L;
    private String id;
    private String nome;
    private String numero;
    private String email;
    private String apartamento;

    public Pessoa(Builder builder){
        this.id = builder.id;
        this.nome = builder.nome;
        this.numero = builder.numero;
        this.email = builder.email;
        this.apartamento = builder.apartamento;
    }

    public Pessoa() {

    }

    @Override
    public List lerBanco(List<String> linhaDividida) {
        List<Pessoa> lista = new ArrayList<>();
        lista.add(new Pessoa.Builder(linhaDividida.get(0), linhaDividida.get(1),linhaDividida.get(2),linhaDividida.get(3),linhaDividida.get(4)).build());
        return lista;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public static class Builder{
        private static final long serialVersionUID = 1L;
        private String id;
        private String nome;
        private String numero;
        private String email;
        private String apartamento;

        public Builder (String id, String nome, String numero, String email, String apartamento) {
            this.id = id;
            this.nome = nome;
            this.numero = numero;
            this.email = email;
            this.apartamento = apartamento;
        }

        public Pessoa build(){
            return new Pessoa(this);
        }
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", numero='" + numero + '\'' +
                ", email='" + email + '\'' +
                ", apartamento='" + apartamento + '\'' +
                '}';
    }
}
