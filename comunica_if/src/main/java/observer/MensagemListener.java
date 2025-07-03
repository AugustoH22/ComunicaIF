
package observer;

import BD.Conexao;
import java.sql.Connection;
import java.sql.Statement;
import org.postgresql.PGConnection;
import org.postgresql.PGNotification;

public class MensagemListener extends Thread {

    private final Connection conn;
    private final Runnable callback;

    public MensagemListener(Runnable callback) {
        this.conn = Conexao.conectar();
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
            PGConnection pgConn = conn.unwrap(PGConnection.class);
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("LISTEN nova_mensagem");
            }

            while (!Thread.interrupted()) {
                PGNotification[] notifications = pgConn.getNotifications();
                if (notifications != null) {
                    for (PGNotification notification : notifications) {
                        // Quando recebe nova mensagem, executa a função passada
                        callback.run();
                    }
                }
                Thread.sleep(1000); // intervalo de verificação
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
