package daos;

import java.util.ArrayList;
import java.util.List;
import models.Departamento;

public class DepartamentoDAO {
    private List<Departamento> departamentos = new ArrayList<>();
    public void salvar(Departamento d) { departamentos.add(d); }
    public List<Departamento> listar() { return departamentos; }
}
