package daos;

import java.util.ArrayList;
import java.util.List;
import models.Servidor;

public class ServidorDAO {
    private List<Servidor> servidores = new ArrayList<>();
    public void salvar(Servidor s) { servidores.add(s); }
    public List<Servidor> listar() { return servidores; }
}
