package sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args)  {
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1, "Café",10.32));
        produtos.add(new Produto(2, "Arroz", 9.20));
        produtos.add(new Produto(3, "Soja", 32.30));
        produtos.add(new Produto(4, "Milho", 23.89));

        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa(1, "Jéssica","123.123.123.12"));
        pessoas.add(new Pessoa(2, "Karen", "321.321.312.32"));
        pessoas.add(new Pessoa(3, "Leão", "102.102.102.32"));
        pessoas.add(new Pessoa(4, "Luiz", "020.020.020.21"));
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
            int opc = (int) objectInputStream.readObject();

            // Obtem o output stream e obj output stream para enviar objetos 


            // Vou alterar as mensagens e envia-las novamente ao cliente
            while (opc != 0) {
                OutputStream ostream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(ostream);
                if (opc == 1) {
                    String msg = "Lista de produtos\n";
                    for (Produto produto : produtos)
                        msg += produto;
                    objectOutputStream.writeObject(msg);
                } else if (opc == 2) {
                    String msg = "Lista de pessoas\n";
                    for (Pessoa pessoa : pessoas)
                        msg += pessoa;
                    objectOutputStream.writeObject(msg);
                } else if (opc == 0) {
                    // Fecho a conexao com o cliente e fecho a porta do servidor
                    ss.close(); // Termino a conexao
                    System.out.println("Conexao com " + socket + " terminada.");
                    socket.close(); // Fecho a porta
                    System.out.println("Servidor desligado.");
                }
             opc = (int) objectInputStream.readObject();

            }

        }
        catch( IOException e) {
            System.err.println(e.getMessage());
        }
        catch(ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}