/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import models.Mensagem;
/**
 *
 * @author pedro
 */
public class ServidorMensagem {
    private static ConcurrentHashMap<String, ObjectOutputStream> clientes = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(8080);
        System.out.println("Servidor iniciado na porta 8080...");

        while (true) {
            Socket socket = servidor.accept();
            new Thread(new ClienteHandler(socket)).start();
        }
    }

    static class ClienteHandler implements Runnable {
        private Socket socket;

        public ClienteHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
                 ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream())) {

                // Lê o nome do usuário na conexão inicial
                String usuario = (String) entrada.readObject();
                clientes.put(usuario, saida);

                System.out.println("Usuário conectado: " + usuario);

                while (true) {
                    Mensagem mensagem = (Mensagem) entrada.readObject();
                    ObjectOutputStream destino = clientes.get(mensagem.getCodServidorDestinatario());

                    if (destino != null) {
                        destino.writeObject(mensagem);
                        destino.flush();
                    }
                }

            } catch (Exception e) {
                System.out.println("Cliente desconectado: " + socket.getInetAddress());
            }
        }
    }
}
