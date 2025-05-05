package daos;

import java.util.ArrayList;
import java.util.List;
import models.*;

public class TurmaDAO {
    
    private List<Turma> turmas = new ArrayList<>();
    public void salvar(Turma t) { turmas.add(t); }
    public List<Turma> listar() { return turmas; }
}
