package daos;

import java.util.ArrayList;
import java.util.List;
import models.Curso;


public class CursoDAO {
    private List<Curso> cursos = new ArrayList<>();
    public void salvar(Curso curso) { cursos.add(curso); }
    public List<Curso> listar() { return cursos; }
}
