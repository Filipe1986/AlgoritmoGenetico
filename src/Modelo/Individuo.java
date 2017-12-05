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
				disciplinas.get(i).setPosicao(i);
				genes.add(new Gene(disciplinas.get(i), salas.get(i)));
			}
			for (int i = salas.size(); i < disciplinas.size(); i++) {
				disciplinas.get(i).setPosicao(i);
				genes.add(new Gene(disciplinas.get(i), new Sala(i , "-", 0, "-")));
			}
			// Mais sala do que disciplina
		} else {
			for (int i = 0; i < disciplinas.size(); i++) {
				disciplinas.get(i).setPosicao(i);
				genes.add(new Gene(disciplinas.get(i), salas.get(i)));
			}
			for (int i = disciplinas.size(); i < salas.size(); i++) {
				disciplinas.get(i).setPosicao(i);
				genes.add(new Gene(new Disciplina( "-", "-", "-", 0), salas.get(i)));
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
		toString+= getFitnessTamanho();
		toString += "\n--------------------------------------------------------------------------";
		
		return toString;
	}

	private int getFitnessTipo() {

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
				//System.out.println("Faltando espacao em sala");
				//Mais grave, valor deve ser maior
				punicao *= fitnessGene;
				punicao = punicao/4;
			}else if(fitnessGene < 0){
				//System.out.println("Sobrando espaco em sala");
				
				punicao *= fitnessGene;
				punicao = punicao/15;
			}else {
				punicao *= 0.2;
			}
			
		
		}
		System.out.println("punicao" + punicao);
		return punicao;
	}

	public int quantidadeGenes() {
		return genes.size();
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
	
	public void trocaGene(int posicao , Disciplina disciplinaNova){
		
		Disciplina disciplinaAntiga = genes.get(posicao).getDisciplina();
		System.out.println("Entrou no troca gene");
		
		System.out.println("Disciplina antiga " + disciplinaAntiga);
		System.out.println("Disciplina nova " + disciplinaNova);
		
		
		for (Gene gene : genes) {
			if (gene.getDisciplina().getNome().equals(disciplinaNova.getNome())){
				//Troca a disciplina local do gene ruim de posicao
				gene.setDisciplina(disciplinaAntiga);
				//Setta a disciplina do gene ruim no bom
				genes.get(posicao).setDisciplina(disciplinaNova);
				
			}
		}	
	}


	public int[] getPioresGenes(int quantidadeTrocaDeGenes) {
		
		
		ArrayList<Gene> piores = (ArrayList<Gene>) this.genes.clone();
		
		
		
		
		Collections.sort(piores, new Comparator<Gene>() {
		    @Override
		    public int compare(Gene gene1, Gene gene2) {
		    	return gene1.getFitnessDouble().compareTo(gene2.getFitnessDouble());

		    }
		});	

		int [] posicaoPioresGenes = new int[quantidadeTrocaDeGenes];
		for(int i = 0; i < quantidadeTrocaDeGenes/2; i++){
			//System.out.println("piores " + piores.get(i).getDisciplina().getPosicao());
			posicaoPioresGenes[i] = piores.get(i).getDisciplina().getPosicao();
		}
		
		for(int i = quantidadeTrocaDeGenes/2; i < quantidadeTrocaDeGenes; i++){
			//System.out.println("Outra ponta" + piores.get(i).getDisciplina().getPosicao());
			
			posicaoPioresGenes[i] = piores.get(piores.size() - i).getDisciplina().getPosicao();
		}
		
		return posicaoPioresGenes;
	}


	public Disciplina getDisciplinaPorPosicao(int i) {
		return genes.get(i).getDisciplina();
	}

}
