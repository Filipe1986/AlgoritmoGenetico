package Controle;

import java.util.Scanner;

import DAO.DAO;
import Modelo.Individuo;
import Modelo.Populacao;

public class Verificacao2 {

	public static void main(String[] args) {
		Populacao pop = new Populacao();
		Individuo ind = DAO.populaIndividuo("tabela_sala.xls", "tabela_disciplina2.xls");
		pop.add(ind);
		//pop.orderByFitness();
		
		for (int i = 0; i < 5; i++) {
			ind = DAO.populaIndividuoShuffle("tabela_sala.xls", "tabela_disciplina2.xls");
			pop.add(ind);
			//pop.avaliacao();
		}
		
		pop.orderByFitness();
		
		
		Scanner ler = new Scanner(System.in);
		int n = 0;
		while(n != 200 ){
		System.out.printf("Valor de entrada: ");
		n = ler.nextInt()-1;
		
		System.out.println(pop.getIndividuo(n));
		
		}
		ler.close();
		

	}
}
