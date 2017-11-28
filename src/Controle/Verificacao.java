package Controle;

import DAO.DAO;
import Modelo.Individuo;
import Modelo.Populacao;

public class Verificacao {

	public static void main(String[] args) {
		Populacao pop = new Populacao();
		Individuo ind = DAO.populaIndividuo("sala1.xls", "disciplina1.xls");
		pop.add(ind);
		pop.orderByFitness();
		
		for (int i = 0; i < 127; i++) {
			ind = DAO.populaIndividuoShuffle("sala1.xls", "disciplina1.xls");
			pop.add(ind);
			//pop.avaliacao();
			
			
			
		}
		
		pop.orderByFitness();
		

	}
}
