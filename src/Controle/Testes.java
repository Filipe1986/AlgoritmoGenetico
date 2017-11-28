package Controle;

import java.util.Scanner;

import DAO.DAO;
import Modelo.Individuo;
import Modelo.Populacao;

public class Testes {

	public static void main(String[] args) {


		//Perfeito
		Individuo ind = DAO.populaIndividuo("sala1.xls", "disciplina1.xls");
		Individuo ind1 = DAO.populaIndividuo("sala1.xls", "disciplina2.xls");
		//Pior possivel
		Individuo ind2 = DAO.populaIndividuo("sala1.xls", "disciplina3.xls");
		Individuo ind3 = DAO.populaIndividuo("sala1.xls", "disciplina4.xls");
		
		
		Populacao pop = new Populacao();
		
		pop.add(ind);
		pop.add(ind1);
		pop.add(ind2);
		pop.add(ind3);
		pop.avaliacao();
		Scanner ler = new Scanner(System.in);
		int n = 0;
		while(n != 200 ){
		System.out.printf("Informe um número para a tabuada: ");
		n = ler.nextInt();
		
		System.out.println(pop.getIndividuo(n));
		
		}
		ler.close();
		

	}

}
