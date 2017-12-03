package Modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


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
				//System.out.println("Faltando espaÃ§o em sala");
				//Mais grave, valor deve ser maior
				punicao *= fitnessGene;
				punicao = punicao/4;
			}else if(fitnessGene < 0){
				//System.out.println("Sobrando espaÃ§o em sala");
				
				punicao *= fitnessGene;
				punicao = punicao/15;
			}else {
				punicao *= 0.2;
			}
			
			//System.out.println(fitnessGene);
		}
		return punicao;
	}

	public int quantidadeGenes() {
		return genes.size();
	}

	public void analisaIndividuo() {

		for (Gene gene : genes) {
			System.out.println(gene.getDisciplina().getNome());

		}

	}

	public Gene getGeneMenosAdaptado() {
		Gene pior = genes.get(0);

		for (Gene gene : genes) {
			if (pior.getFitnessTamanho() < gene.getFitnessTamanho()) {
				pior = gene;
			}
		}

		return pior;
	}
	
	public void mutacao(int quantidadeMutacacoes){
		Random random = new Random();
		
		for(int i = 0; i < quantidadeMutacacoes; i++){
			
			int posicaoGene = random.nextInt(genes.size());
			int posicaoGene2 = random.nextInt(genes.size());
			
			Disciplina disciplina1 = genes.get(posicaoGene).getDisciplina();
			genes.get(posicaoGene).setDisciplina(genes.get(posicaoGene2).getDisciplina());
			genes.get(posicaoGene2).setDisciplina(disciplina1);			
		}
		
	}


	public Double getModuloFitness() {
		
		return Math.abs(getFitnessTamanho());

	}
	
	public void trocaGene(int posicao , Disciplina disciplina){
		
		Disciplina disciplinaTroca = genes.get(posicao).getDisciplina();
		genes.get(posicao).setDisciplina(disciplina);
		for (Gene gene : genes) {
			if (gene.getDisciplina().getNome().equals(disciplina.getNome())){
				gene.setDisciplina(disciplinaTroca);
			}
		}
		
		
		
		
	}


	public int[] getPioresGenes(int quantidadeTrocaDeGenes) {
		
		

		//ArrayList<Integer> posicaoPioresGenes = new ArrayList<>();
		
		int [] posicaoPioresGenes = new int[quantidadeTrocaDeGenes];
		
		ArrayList<Gene> piores = this.genes;
		
		Collections.sort(piores, new Comparator<Gene>() {
		    @Override
		    public int compare(Gene gene1, Gene gene2) {
		    	
		    	return 0;
		    	//Faltando ajeitar a comparação dos genes, para ordenar e pegar as piores posicoes
				//return ind1.getFitnessTamanho().compareTo(ind2.getFitnessTamanho());
		    }
		});	
		
		for (Gene gene : piores) {
			for(int i = 0; i < quantidadeTrocaDeGenes; i++){
				if (posicaoPioresGenes[i] < gene.getFitnessModulo())
				posicaoPioresGenes[i]= 0;
				
			}
		}
		
		
		return null;
	}

}
