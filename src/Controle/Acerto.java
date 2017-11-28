package Controle;

import java.util.ArrayList;
import java.util.Scanner;

import Modelo.Disciplina;
import Modelo.Individuo;
import Modelo.Populacao;
import Modelo.Sala;

public class Acerto {
	public static void main(String[] args) {
		ArrayList<Sala> salas = new ArrayList<>();
		salas.add(new Sala("NOME1 ", 2, "L"));
		ArrayList<Disciplina> disciplinas = new ArrayList<>();
		
		
		disciplinas.add(new Disciplina("D1", "BSI", "L", 5));
		Individuo ind = new Individuo(salas, disciplinas );
		

		Populacao pop = new Populacao();
		
		for(int i = 0; i < 100; i++){
			
			pop.add(ind);
			//pop.avaliacao();
		}
		//pop.add(ind);
		
		
		
		pop.avaliacao();
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
