package Controle;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSpinnerUI;

import Modelo.Disciplina;
import Modelo.Individuo;
import Modelo.Populacao;

public class SelecaoPorTorneio {
	
	
	public Individuo selecaoPorTorneio(Populacao pop, int quantidadeCruzamento){
		
		//System.out.println("Entrou no Selecao por torneio");
		pop = selecaoPorTorneioPop(pop, quantidadeCruzamento);
		
		return pop.getIndividuo(0);
	}
	
	
	public Populacao selecaoPorTorneioPop(Populacao populacao, int quantidadeCruzamento){

		//System.out.println("Entrou no selecao por torneio pop");
		ArrayList<Individuo> proximaGeracao = new ArrayList<>();
		Individuo pai = null;
		Individuo mae = null;
		Individuo filho = null;
		ArrayList<Individuo> pop  = populacao.getPopulacao();
		if(pop.size() == 1){
			return populacao;
		}
		
		for (int i = 0; i < pop.size()/2; i++) {
			pai = pop.get(i);
			mae = pop.get((pop.size()-1) - i);
			
			System.out.println("Pai");
			System.out.println(pai);
			System.out.println("Mae");
			System.out.println(mae);
			
			
			filho = cruzamentoPorTorneio(pai, mae, quantidadeCruzamento);
			System.out.println("Filho apos o cruzamento\n" + filho);
			proximaGeracao.add(filho); 
		}
		populacao = new Populacao(proximaGeracao);
		return selecaoPorTorneioPop(populacao, quantidadeCruzamento);

		
	}
	
	
	
	public Individuo cruzamentoPorTorneio(Individuo pai, Individuo mae, int quantidadeTrocaDeGenes){
		
		//System.out.println("Entrou no cruzemento por torneio");
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
			System.out.println("Pai");
			melhorIndividuo = 0;
			piorIndividuo = 1;
		}else{
			System.out.println("Mae");
			melhorIndividuo = 1;
			piorIndividuo = 0;
		}
		filho = pais[melhorIndividuo];
		
		int [] posicaoPioresGenes = filho.getPioresGenes(quantidadeTrocaDeGenes); 
		
		
		for(int i = 0; i < posicaoPioresGenes.length; i++){
			System.out.println("Localizacao dos piores genes no melhor individuo" + posicaoPioresGenes[i]);
			Disciplina disciplina = pais[piorIndividuo].getDisciplinaPorPosicao(posicaoPioresGenes[i]);
			filho.trocaGene(posicaoPioresGenes[i], disciplina);
		}
		if(filho.getModuloFitness() < pais[melhorIndividuo].getModuloFitness() ){
			return filho;
		}else{
			return pais[melhorIndividuo];
		}
	}
	
	

}
