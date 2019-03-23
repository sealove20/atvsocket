package sockets;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private int id;
    private String nome;
    private String cpf;

    Pessoa(){};

    public Pessoa(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        String format = " %02d %s %s \n";
        return String.format(format, this.id, this.nome, this.cpf);
    }
}
