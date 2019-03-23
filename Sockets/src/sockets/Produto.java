package sockets;

import java.io.Serializable;

public class Produto implements Serializable {

    private int id;
    private String nome;
    private double preco;

    Produto() {}

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        String format = "%02d %s %.2f \n";
        return String.format(format, this.id, this.nome, this.preco);
    }
}
