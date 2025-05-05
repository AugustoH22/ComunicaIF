package daos;

import java.util.ArrayList;
import java.util.List;
import models.Aluno;


public class AlunoDAO {
    private List<Aluno> alunos = new ArrayList<>();
    public void salvar(Aluno aluno) { alunos.add(aluno); }
    public List<Aluno> listar() { return alunos; }
}
