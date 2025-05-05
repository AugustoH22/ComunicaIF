package daos;

import java.util.ArrayList;
import java.util.List;
import models.HistoricoRestrito;


public class HistoricoRestritoDAO {
    private List<HistoricoRestrito> historicos = new ArrayList<>();
    public void salvar(HistoricoRestrito h) { historicos.add(h); }
    public List<HistoricoRestrito> listar() { return historicos; }
}
