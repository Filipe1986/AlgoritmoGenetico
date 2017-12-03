package Controle;

import DAO.DAO;
import Modelo.Individuo;

public class TesteMutacacao {

	public static void main(String[] args) {
		Individuo ind = DAO.populaIndividuoShuffle("sala1.xls","disciplina1.xls");
		
		System.out.println(ind);
		for(int i = 0; i < 100; i++){
			ind.mutacao(31);
			System.out.println(ind);
		}
	}

}
