
package daos;

import java.util.ArrayList;
import java.util.List;
import models.Mensagem;

public class MensagemDAO {
    private List<Mensagem> mensagens = new ArrayList<>();
    public void salvar(Mensagem m) { mensagens.add(m); }
    public List<Mensagem> listar() { return mensagens; }
}
