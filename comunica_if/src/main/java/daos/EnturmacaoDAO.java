package daos;

import java.util.ArrayList;
import java.util.List;
import models.Enturmacao;

public class EnturmacaoDAO {
    private List<Enturmacao> enturmacoes = new ArrayList<>();
    public void salvar(Enturmacao e) { enturmacoes.add(e); }
    public List<Enturmacao> listar() { return enturmacoes; }
}
