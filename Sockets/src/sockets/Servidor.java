package sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args)  {
        try {
            // Especifique a porta em que ficara ouvindo
            ServerSocket ss = new ServerSocket(8090);
            System.out.println("Servidor aguardando por conexoes...");
            // Bloqueia ateh que alguém conecte ao servidor
            Socket socket = ss.accept(); 
            // Nesse ponto alguem jah conectou, entao imprimimos os dados da conexao
            System.out.println("Conectado. Cliente: " + socket);

            // Obtem o input stream e obj input stream para ler os objetos recebidos
            InputStream istream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(istream);

            // Aguardo recebimento de mensagens
            System.out.println("Aguardando mensagens do cliente...");
            ArrayList<Mensagem> mensagens = (ArrayList<Mensagem>) objectInputStream.readObject();
            System.out.println("Recebi: " + mensagens.size() + " mensagens de: " + socket);
            System.out.println("Mensagens recebidas: ");
            mensagens.forEach((m)-> System.out.println("  " + m));

            // Obtem o output stream e obj output stream para enviar objetos 
            OutputStream ostream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ostream);

            // Vou alterar as mensagens e envia-las novamente ao cliente
            mensagens.forEach((m)-> m.setTexto( 
                    m.getTexto() + " [alterado pelo servidor]"  ));
            objectOutputStream.writeObject(mensagens);
            
            // Vou esperar para receber uma unica mensagem
            Mensagem m = (Mensagem) objectInputStream.readObject();
            System.out.println("Mensagem recebida: " + m);

            // Fecho a conexao com o cliente e fecho a porta do servidor
            ss.close(); // Termino a conexao
            System.out.println("Conexao com " + socket + " terminada.");
            socket.close(); // Fecho a porta
            System.out.println("Servidor desligado.");
            
        }
        catch( IOException e) {
            System.err.println(e.getMessage());
        }
        catch(ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}