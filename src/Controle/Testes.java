package Controle;

import DAO.DAO;
import Modelo.Individuo;

public class Testes {

	public static void main(String[] args) {
		
		Individuo ind1 = DAO.populaIndividuo("sala1.xls", "disciplina1.xls");
		
		
		Individuo ind2 = DAO.populaIndividuo("sala1.xls", "disciplina2.xls");
		System.out.println(ind2);
		Individuo ind3 = DAO.populaIndividuo("sala2.xls", "disciplina1.xls");

		System.out.println(ind3);

	}

}
