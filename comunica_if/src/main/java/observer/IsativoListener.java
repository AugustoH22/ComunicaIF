package observer;

import BD.Conexao;
import java.sql.Connection;
import java.sql.Statement;
import org.postgresql.PGConnection;
import org.postgresql.PGNotification;

public class IsativoListener extends Thread {

    private final Connection conn;
    private final Runnable callback;

    public IsativoListener(Runnable callback) {
        this.conn = Conexao.conectar();
        this.callback = callback;
    }

    @Override
    public void run() {
        
        try {
            PGConnection pgConn = conn.unwrap(PGConnection.class);
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("LISTEN isativo_alterado");

            }

            while (!Thread.interrupted()) {

                PGNotification[] notifications = pgConn.getNotifications();
                if (notifications != null) {
                    for (PGNotification notification : notifications) {
                        System.out.println("Alteração em isativo para servidor ID: " + notification.getParameter());
                        callback.run(); // você pode passar outra lógica também
                    }
                }
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

