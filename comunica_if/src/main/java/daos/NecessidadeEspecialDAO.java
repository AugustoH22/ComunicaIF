
package daos;

import java.util.ArrayList;
import java.util.List;
import models.NecessidadeEspecial;

public class NecessidadeEspecialDAO {
    private List<NecessidadeEspecial> necessidades = new ArrayList<>();
    public void salvar(NecessidadeEspecial n) { necessidades.add(n); }
    public List<NecessidadeEspecial> listar() { return necessidades; }
}