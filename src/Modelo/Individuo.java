package Modelo;
import java.util.ArrayList;
import java.util.Collections;

public class Individuo {

	private ArrayList<Gene> pares;


	public Individuo(ArrayList<Sala> salas, ArrayList<Disciplina> disciplinas) {
		this.pares = new ArrayList<>();
		
		// Mais disciplina do que sala
		if (disciplinas.size() > salas.size()) {
			for (int i = 0; i < salas.size(); i++) {
				pares.add(new Gene(disciplinas.get(i), salas.get(i)));
			}
			for (int i = salas.size(); i < disciplinas.size(); i++) {
				
				pares.add(new Gene(disciplinas.get(i), new Sala("-", 0, "-")));
			}
			// Mais sala do que disciplina
		} else {
			for (int i = 0; i < disciplinas.size(); i++) {
				pares.add(new Gene(disciplinas.get(i), salas.get(i)));
			}
			for (int i = disciplinas.size(); i < salas.size(); i++) {
				System.out.println("Salas sem disciplinas");
				pares.add(new Gene(new Disciplina(0, "-", "-", "-", 0), salas.get(i)));
			}
		}

	}

	public void addPar(Disciplina disciplina, Sala sala) {
		this.pares.add(new Gene(disciplina, sala));

	}

	@Override
	public String toString() {
		String toString = "";
		for (Gene par : pares) {
			toString += par.getSala().toString()+"\n"+  par.getDisciplina().toString()+ "\n\n";
		}
		toString += "\n--------------------------------------------------------------------------";
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

	public int quantidadePares() {
		return pares.size();
	}
	
	public void analisaIndividuo(){
		int numeroDeSalas;
		int numeroDeSalasComuns;
		int numeroDeLabs;
		int numeroDeDisciplinas;
		int numeroDeDisciplinasComum;
		int numeroDeDisciplinasLab;
		int numeroDeDisciplinasFacultativas;
		int totalAluno;
		int totalVagas;
		
		
		
		for (Gene par : pares) {
			System.out.println(par.getDisciplina().getNome());
			
		}
		
		System.out.println("Número total de salas ");
		System.out.println("Número total de salas comuns");
		System.out.println("Número total de salas de laboratorio");
		System.out.println("Capacidade total de todas as salas");
		System.out.println("Número total de disciplinas");
		System.out.println("Número total de disciplinas que necessitam de laboratorio ");
		System.out.println("Número total de disciplinas que tem preferencia por laboratorio");
		System.out.println("Número total de disciplinas em salas comum ");
		System.out.println("Soma de todos os alunos");
		

	}

	

}
