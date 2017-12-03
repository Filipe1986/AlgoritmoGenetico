package Modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Populacao {

	private ArrayList<Individuo> populacao;
	

	public Populacao() {
		populacao = new ArrayList<>();
	}

	public void add(Individuo individuo) {
		if (populacao.size() <= 0 ){
			populacao = new ArrayList<>();
		}
		populacao.add(individuo);
	}

	public void avaliacao() {

		int i = 0;
		for (Individuo individuo : populacao) {
			i++;
			//
			System.out.println("ind "+  i + " fitness" + individuo.getFitnessTamanho() );
			
			//System.out.println(individuo);
			
		}
		
		
	}


	public void cruzamento() {
		// TODO 
		//Cruza individuos
		
	}

	public void selecao() {
		// TODO
		//Remover individuos
		
	}
	
	
	@Override
	public String toString() {
		String pop = "";
		for (Individuo individuo : populacao) {
			pop += individuo.toString() + "\n";
		}
		pop += "\n\n";
		
		return pop;
	}

	public ArrayList<Individuo> getPopulacao() {
		return populacao;
	}

	public Individuo getIndividuo(int i) {
		return populacao.get(i);
	}

	public void orderByFitness() {
		Collections.sort(populacao, new Comparator<Individuo>() {
		    @Override
		    public int compare(Individuo ind1, Individuo ind2) {
		        return ind1.getFitnessTamanho().compareTo(ind2.getFitnessTamanho());
		    }
		});		
		int i = 0;
		for (Individuo individuo : populacao) {
			i++;
			//
			System.out.println("ind "+  i + " fitness" + individuo.getFitnessTamanho() );
			
			//System.out.println(individuo);
			
		}
		
	}
	
	public void selecaoPorTorneio(){
		ArrayList<Individuo> proximaGeracao = new ArrayList<>();
		
		
		
		
		
		
	}
	
	public Individuo cruzamentoPorTorneio(Individuo pai, Individuo mae, int quantidadeTrocaDeGenes){
		
		Individuo[] pais = new Individuo[2];
		pais[0] = pai;
		pais[1] = mae;
		
				
		Individuo filho;
		Double moduloFitnessPai = pai.getModuloFitness();
		Double moduloFitnessMae = mae.getModuloFitness();
		int melhorIndividuo = -1;
		int piorIndividuo = -1;
		
		
		//Filho tem como base o parente mais saudável
		if (moduloFitnessPai < moduloFitnessMae ){
			melhorIndividuo = 0;
			piorIndividuo = 1;
		}else{
			melhorIndividuo = 1;
			piorIndividuo = 0;
		}
		filho = pais[melhorIndividuo];
		
		int [] posicaoPioresGenes = filho.getPioresGenes(quantidadeTrocaDeGenes); 
		
		//filho.trocaGene(posicao, disciplina);
		
		
		
		return filho;
	}
	
	

	
	
}
