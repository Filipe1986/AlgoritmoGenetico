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

	
	
}
