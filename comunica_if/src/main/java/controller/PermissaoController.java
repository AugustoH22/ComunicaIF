
package controller;

import java.util.List;
import models.Permissao;
import daos.PermissaoDAO;

class PermissaoController {
    private PermissaoDAO dao = new PermissaoDAO();
    public void cadastrarPermissao(Permissao p) { dao.salvar(p); }
    public List<Permissao> listarPermissoes() { return dao.listar(); }
}
