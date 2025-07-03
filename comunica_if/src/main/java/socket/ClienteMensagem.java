
package socket;


import models.Mensagem;

import java.io.*;
import java.net.*;

public class ClienteMensagem {
    
    private Socket socket;
    private ObjectOutputStream saida;
    private ObjectInputStream entrada;

    public ClienteMensagem(String usuario) throws IOException, ClassNotFoundException {
        this.socket = new Socket("localhost", 8080);
        this.saida = new ObjectOutputStream(socket.getOutputStream());
        this.entrada = new ObjectInputStream(socket.getInputStream());

        // envia o nome do usuário
        saida.writeObject(usuario);
        saida.flush();

        // escuta mensagens recebidas
        new Thread(() -> {
            try {
                while (true) {
                    Mensagem m = (Mensagem) entrada.readObject();
                    System.out.println("Nova mensagem de " + m.getRemetente()+ ": " + m.getTexto());
                }
            } catch (Exception e) {
                System.out.println("Desconectado ou erro: " + e.getMessage());
            }
        }).start();
    }

    public ClienteMensagem(){
        
    }
    public void enviarMensagem(Mensagem mensagem) throws IOException {
        saida.writeObject(mensagem);
        saida.flush();
    }
}