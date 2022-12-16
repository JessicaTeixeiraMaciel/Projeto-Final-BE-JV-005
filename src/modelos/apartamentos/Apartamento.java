package modelos.apartamentos;

import interfaces.ObjetoLista;
import modelos.genericos.Objeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Apartamento extends Objeto implements Serializable, ObjetoLista {

    private static final long serialVersionUID = 1L;
    private String id;
    private String numero;
    private boolean possuiMedidor;
    private boolean estaAlugado;


    public Apartamento(Builder builder) {
        this.id = builder.id;
        this.numero = builder.numero;
        this.possuiMedidor = builder.possuiMedidor;
        this.estaAlugado = builder.estaAlugado;
    }

    public Apartamento() {

    }

    @Override
    public List lerBanco(List<String> linhaDividida) {
        List<Apartamento> lista = new ArrayList<>();
        lista.add(new Apartamento.Builder(linhaDividida.get(0), linhaDividida.get(1), Boolean.getBoolean(linhaDividida.get(2)),Boolean.getBoolean(linhaDividida.get(3))).build());
        return lista;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isPossuiMedidor() {
        return possuiMedidor;
    }

    public void setPossuiMedidor(boolean possuiMedidor) {
        this.possuiMedidor = possuiMedidor;
    }

    public boolean isEstaAlugado() {
        return estaAlugado;
    }

    public void setEstaAlugado(boolean estaAlugado) {
        this.estaAlugado = estaAlugado;
    }

    public static class Builder{
        private static final long serialVersionUID = 1L;
        private String id;
        private String numero;
        private boolean possuiMedidor;
        private boolean estaAlugado;

        public Builder (String id, String numero, boolean possuiMedidor, boolean estaAlugado){
            this.id = id;
            this.numero = numero;
            this.possuiMedidor = possuiMedidor;
            this.estaAlugado = estaAlugado;
        }

        public Apartamento build(){
            return new Apartamento(this);
        }
    }

    @Override
    public String toString() {
        return "Apartamento{" +
                "id='" + id + '\'' +
                ", numero='" + numero + '\'' +
                ", possuiMedidor=" + possuiMedidor +
                ", estaAlugado=" + estaAlugado +
                '}';
    }
}
