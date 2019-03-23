package sockets;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class Cliente {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opc = 1;
        try {
            // Indico qual o host e a porta para se conectar.
            // Se voce estah fazendo um teste local, com servidor e cliente na mesma
            // maquina, entao coloque 'localhost'. Caso contrario, coloque o IP do 
            // servidor.
            Socket socket = new Socket("localhost", 8090);

            // Obtem o output stream e obj output stream para enviar objetos 
            OutputStream ostream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ostream);
            while(opc != 0) {
                System.out.println(" 1 - Listar os produtos\n" +
                        " 2 - Listar Pessoas\n" +
                        " 0 - Encerrar");
                opc = scan.nextInt();
                objectOutputStream.writeObject(opc);

                // Obtem o input stream e obj input stream para ler os objetos recebidos
                InputStream istream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(istream);

                // Aguardo recebimento de mensagens
                String listas = (String) objectInputStream.readObject();
                System.out.println(listas);
            }
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
