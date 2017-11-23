import java.util.ArrayList;

public class Individuo {

	private ArrayList<Par> pares;


	public Individuo(ArrayList<Disciplina> disciplinas, ArrayList<Sala> salas) {
		this.pares = new ArrayList<>();
		
		// Mais disciplina do que sala
		if (disciplinas.size() > salas.size()) {
			for (int i = 0; i < salas.size(); i++) {
				pares.add(new Par(disciplinas.get(i), salas.get(i)));

			}
			for (int i = salas.size(); i < disciplinas.size(); i++) {
				pares.add(new Par(disciplinas.get(i), new Sala("-", 0, "-")));
			}
			// Mais sala do que disciplina
		} else {
			for (int i = 0; i < disciplinas.size(); i++) {
				pares.add(new Par(disciplinas.get(i), salas.get(i)));
			}
			for (int i = disciplinas.size(); i < salas.size(); i++) {
				pares.add(new Par(new Disciplina(0, "-", "-", "-", 0), salas.get(i)));
			}
		}

	}

	public void addPar(Disciplina disciplina, Sala sala) {
		this.pares.add(new Par(disciplina, sala));

	}

	@Override
	public String toString() {
		String toString = null;
		for (Par par : pares) {
			toString += par.getDisciplina().toString() + "\n " + par.getSala().toString();
		}
		return toString;
	}

	public int getFitnessTipo() {
		
		return calculaFitnessTipo();
	}

	private int calculaFitnessTipo() {
		int total = 0;
		for (int i = 0; i < pares.size(); i++) {
			
			total += pares.get(i).getFitnessTipo();
		}
		return total;

	}

	public int getFitnessTamanho() {
		return calculaFitnessTamanho();
	}

	private int calculaFitnessTamanho() {
		int total = 0;
		for (int i = 0; i < pares.size(); i++) {
			total += pares.get(i).getFitnessTamanho();
		}
		return  total;
	}

	public Object quantidadePares() {
		
		return pares.size();
	}

}
