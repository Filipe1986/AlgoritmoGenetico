package Modelo;

public class Gene {
	private Disciplina disciplina;
	private Sala sala;
	
	final private String FACULTATIVO = "F";
	final private String LABORATIRIO = "L";
	final private String COMUM = "C";

	public Gene(Disciplina disciplina, Sala sala) {
		this.disciplina = disciplina;
		this.sala = sala;
		//Número negativo mais aluno que espaço
		//Número positivo mais espaço do que aluno (Menor pior)
	}

	public int getFitnessTipo() {
		int fitnessTipo = 0;
		
		if (disciplina.getTipoSala().compareTo(sala.getTipo()) == 0) {
			fitnessTipo = 1;
			
		} else if (sala.getTipo() == LABORATIRIO  && disciplina.getTipoSala() == COMUM) {
			fitnessTipo = 3 ;
		} else if (sala.getTipo() == LABORATIRIO && disciplina.getTipoSala() == FACULTATIVO) {
			fitnessTipo = 2;
		} else if (sala.getTipo() == COMUM && disciplina.getTipoSala() == LABORATIRIO) {
			fitnessTipo = 3 ;
		} else if (sala.getTipo() == COMUM && disciplina.getTipoSala() == FACULTATIVO) {
			fitnessTipo = 3;
		}else{
			//this.fitnessTipo = Integer.MAX_VALUE;
		}
		return fitnessTipo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public int getFitnessTamanho() {
		return  disciplina.getMaxAlunos() - sala.getCapacidade();
	}

}
