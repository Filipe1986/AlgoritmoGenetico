
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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	public String getTipoSala() {
		return tipoSala;
	}


	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}


	public int getMaxAlunos() {
		return maxAlunos;
	}


	public void setMaxAlunos(int maxAlunos) {
		this.maxAlunos = maxAlunos;
	}
	
	
}
