package sockets;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


public class Cliente {

    public static void main(String[] args) {
        try {
            // Indico qual o host e a porta para se conectar.
            // Se voce estah fazendo um teste local, com servidor e cliente na mesma
            // maquina, entao coloque 'localhost'. Caso contrario, coloque o IP do 
            // servidor.
            Socket socket = new Socket("localhost", 8090);
            System.out.println("Cliente conectado.");

            // Obtem o output stream e obj output stream para enviar objetos 
            OutputStream ostream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ostream);

            // Crio as mensagens a serem enviadas
            ArrayList<Mensagem> messages = new ArrayList<>();
            messages.add(new Mensagem(1, "Ola servidor."));
            messages.add(new Mensagem(2, "Esta mensagem"));
            messages.add(new Mensagem(3, "esta sendo enviada"));
            messages.add(new Mensagem(4, "a partir de seu cliente"));

            // Enviando arraylist de mensagens ao servidor
            System.out.println("Enviando mensagens ao servidor...");
            objectOutputStream.writeObject(messages);
            System.out.println("Mensagens enviadas.");

            System.out.println("Aguardando respostas do servidor...");

            // Obtem o input stream e obj input stream para ler os objetos recebidos
            InputStream istream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(istream);

            // Aguardo recebimento de mensagens
            ArrayList<Mensagem> mensagens = (ArrayList<Mensagem>) objectInputStream.readObject();
            System.out.println("Recebi: " + mensagens.size() + " mensagens do servidor.");
            System.out.println("Mensagens recebidas: ");
            mensagens.forEach((m)-> System.out.println("  " + m));        

            System.out.println("Enviando 1 unica mensagem ao servidor.");
            objectOutputStream.writeObject(messages.get(0));

            System.out.println("Fechando conexao com o servidor.");
            socket.close();
            
        }
        catch( IOException e) {
            System.err.println(e.getMessage());
        }
        catch(ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }        
    }
}
