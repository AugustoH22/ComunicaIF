package daos;

import java.util.ArrayList;
import java.util.List;
import models.Permissao;

public class PermissaoDAO {
    private List<Permissao> permissoes = new ArrayList<>();
    public void salvar(Permissao p) { permissoes.add(p); }
    public List<Permissao> listar() { return permissoes; }
}
