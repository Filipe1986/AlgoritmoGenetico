package Controle;

import DAO.DAO;
import Modelo.Individuo;
import Modelo.Populacao;

public class teste {

	public static void main(String[] args) {

		String salaTeste = "sala2.xls";
		String disciplinaTeste = "disciplina2.xls";

		Populacao populacao = new Populacao();

		Individuo ind = DAO.populaIndividuo(salaTeste, disciplinaTeste);
		populacao.add(ind);
		
		System.out.println(ind);

	}

}
