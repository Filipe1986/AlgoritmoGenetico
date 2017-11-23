
public class Par {
	private Disciplina disciplina;
	private Sala sala;
	private int fitnessTamanho;
	private int fitnessTipo;
	final private String FACULTATIVO = "F";
	final private String LABORATIRIO = "L";
	final private String COMUM = "C";

	public Par(Disciplina disciplina, Sala sala) {
		this.disciplina = disciplina;
		this.sala = sala;
		this.fitnessTamanho = Math.abs(disciplina.getMaxAlunos() - sala.getCapacidade());

		punicaoTipo();
		punicaoTamanho();

	}

	private void punicaoTamanho() {
		int diferenca = disciplina.getMaxAlunos() - sala.getCapacidade();
		fitnessTamanho = Math.abs(diferenca);

	}

	private void punicaoTipo() {

		if (disciplina.getTipoSala().compareTo(sala.getTipo()) == 0) {
			this.fitnessTipo = 1;
			
		} else if (sala.getTipo() == LABORATIRIO  && disciplina.getTipoSala() == COMUM) {
			this.fitnessTipo = 3 ;
		} else if (sala.getTipo() == LABORATIRIO && disciplina.getTipoSala() == FACULTATIVO) {
			this.fitnessTipo = 2;
		} else if (sala.getTipo() == COMUM && disciplina.getTipoSala() == LABORATIRIO) {
			this.fitnessTipo = 3 ;
		} else if (sala.getTipo() == COMUM && disciplina.getTipoSala() == FACULTATIVO) {
			this.fitnessTipo = 3;
		}else{
			//this.fitnessTipo = Integer.MAX_VALUE;
		}
		
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
		return fitnessTamanho;
	}

	public int getFitnessTipo() {
		return fitnessTipo;
	}

}
