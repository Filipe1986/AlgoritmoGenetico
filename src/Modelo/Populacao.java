package Modelo;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Populacao {

	private ArrayList<Individuo> populacao;
	private double fatorTamanho;
	private double fatorTipo;
	private int fitnessTamanho = 0;
	private int fitnessTipo = 0;
	

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
		int fitnessTamanho = 0;
		int fitnessTipo = 0;
		
		for (Individuo individuo : populacao) {
			//System.err.println("Tamanho :"+ individuo.getFitnessTamanho()+ " Tipo :" + individuo.getFitnessTipo());
			fitnessTamanho  += individuo.getFitnessTamanho();
			fitnessTipo += individuo.getFitnessTipo();
		}
		this.fitnessTamanho = fitnessTamanho / populacao.size();
		this.fitnessTipo = fitnessTipo / populacao.size();
		
	}


	public int getFitnessTamanho() {
		return fitnessTamanho;
	}


	public int getFitnessTipo() {
		return fitnessTipo;
	}


	public void cruzamento() {
		// TODO 
		//Cruza individuos
		
	}

	public void selecao() {
		// TODO
		//Remover individuos
		
	}
	
	
	
	
	
}
