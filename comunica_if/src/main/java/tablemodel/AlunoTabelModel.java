package tablemodel;

import controller.AlunoController;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.stream.Collectors;
import models.Aluno;
import models.NecessidadeEspecial;

public class AlunoTabelModel extends AbstractTableModel {

    private final List<Aluno> alunos;
    private final String[] colunas = {"Código", "Nome", "Necessidade"};

    private AlunoController ac = new AlunoController();

    public AlunoTabelModel(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public AlunoTabelModel() {
        alunos = ac.listarAlunos();
    }

    @Override
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno ac = alunos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ac.getCodigo();
            case 1:
                return ac.getNome();
            case 2:
                List<NecessidadeEspecial> necessidades = ac.getNecessidades();
                if (necessidades.isEmpty()) {
                    return "Sem necessidades cadastradas";
                } else {
                    return necessidades.stream()
                            .map(n -> n.getCodigoNecessidade()) // ou n.toString() se quiser algo diferente
                            .collect(Collectors.joining(", "));
                }
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}
