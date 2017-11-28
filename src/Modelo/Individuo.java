package Modelo;

import java.util.ArrayList;


public class Individuo{

	private ArrayList<Gene> genes;




	public Individuo(ArrayList<Sala> salas, ArrayList<Disciplina> disciplinas) {
		this.genes = new ArrayList<>();

		// Mais disciplina do que sala
		if (disciplinas.size() >= salas.size()) {
			for (int i = 0; i < salas.size(); i++) {
				genes.add(new Gene(disciplinas.get(i), salas.get(i)));
			}
			for (int i = salas.size(); i < disciplinas.size(); i++) {

				genes.add(new Gene(disciplinas.get(i), new Sala("-", 0, "-")));
			}
			// Mais sala do que disciplina
		} else {
			for (int i = 0; i < disciplinas.size(); i++) {
				genes.add(new Gene(disciplinas.get(i), salas.get(i)));
			}
			for (int i = disciplinas.size(); i < salas.size(); i++) {
				// System.out.println("Salas sem disciplinas");
				genes.add(new Gene(new Disciplina("-", "-", "-", 0), salas.get(i)));
			}
		}

	}


	public int getTotalSalas() {
		int totalSalas = 0;
		for (Gene gene : genes) {
			if(!gene.getSala().getNome().equals("-")){
				totalSalas++;
			}
		}
		return totalSalas;
	}

	public int getTotalDisciplinas() {
		
		int totalDisciplinas = 0;
		for (Gene gene : genes) {
			if(!gene.getDisciplina().getNome().equals("-")){
				totalDisciplinas++;
			}
		}
		return totalDisciplinas;
	
	}
	
	public void addPar(Disciplina disciplina, Sala sala) {
		this.genes.add(new Gene(disciplina, sala));

	}

	@Override
	public String toString() {
		String toString = "";
		for (Gene gene : genes) {
			toString += gene.toString();
		}
		toString += "\n--------------------------------------------------------------------------";
		return toString;
	}

	public int getFitnessTipo() {

		return calculaFitnessTipo();
	}

	private int calculaFitnessTipo() {
		int total = 0;
		for (int i = 0; i < genes.size(); i++) {

			total += genes.get(i).getFitnessTipo();
		}
		return total;

	}

	public Double getFitnessTamanho() {
		Double punicao = genes.size() + 1.0;
		
		for (int i = 0; i < genes.size(); i++) {
			double fitnessGene = genes.get(i).getFitnessTamanho();

			if(fitnessGene > 0){
				//System.out.println("Faltando espaço em sala");
				//Mais grave, valor deve ser maior
				punicao *= fitnessGene;
				punicao = punicao/4;
			}else if(fitnessGene < 0){
				//System.out.println("Sobrando espaço em sala");
				
				punicao *= fitnessGene;
				punicao = punicao/15;
			}else {
				punicao *= 0.2;
			}
			
			//System.out.println(fitnessGene);
		}
		return punicao;
	}

	public int quantidadePares() {
		return genes.size();
	}

	public void analisaIndividuo() {

		for (Gene gene : genes) {
			System.out.println(gene.getDisciplina().getNome());

		}

	}

	public Gene getPiorGene() {
		Gene pior = genes.get(0);

		for (Gene gene : genes) {
			if (pior.getFitnessTamanho() < gene.getFitnessTamanho()) {
				pior = gene;
			}
		}

		return pior;
	}

}
