
public class Disciplina {

	
	private int    id;
	private String nome;
	private String curso;
	private String  tipoSala;
	private int    maxAlunos;
	public Disciplina(int id, String nome, String curso, String tipoSala, int maxAlunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.curso = curso;
		this.tipoSala = tipoSala;
		this.maxAlunos = maxAlunos;
	}

	
	@Override
	public String toString() {

		return "Disciplina nome: "+ nome + " curso: " + curso + " tipoSala: "+ tipoSala+" Números de alunos "+ maxAlunos + "\n" ;
	}
}
