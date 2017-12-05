package Modelo;

public class Disciplina {

	
	private int posicao;
	private String nome;
	private String curso;
	private String  tipoSala;
	private int    maxAlunos;
	
	public Disciplina( String nome, String curso, String tipoSala, int maxAlunos) {
		//this.posicao = posicao;
		this.nome = nome;
		this.curso = curso;
		this.tipoSala = tipoSala;
		this.maxAlunos = maxAlunos;
	}

	
	public int getPosicao() {
		return posicao;
	}


	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}


	@Override
	public String toString() {

		return "posicao "+  posicao + " " + nome + " / Numeros de alunos "+ maxAlunos + " / curso: " + curso + " / tipoSala: "+ tipoSala  ;
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
