package sockets;

import java.io.Serializable;

// IMPORTANTE
// Implemente a interface Serializable para que o java 
// entenda que sua classe eh serializaval para que 
// possa enviar sua instancia via socket.

public class Mensagem implements Serializable{
    
    private int id;
    private String texto;

    public Mensagem(int id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        String format = "[ %02d %s ]";
        return String.format(format, this.id, this.texto);
    }
    
}