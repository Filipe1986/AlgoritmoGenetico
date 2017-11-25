package Teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import DAO.DAO;
import Modelo.Disciplina;
import Modelo.Individuo;
import Modelo.Gene;
import Modelo.Populacao;
import Modelo.Sala;

public class teste2 {

	@Test
	public void test() {

		Individuo ind1 = DAO.populaIndividuo("sala1.xls", "disciplina1.xls");
		
		
		Individuo ind2 = DAO.populaIndividuoShuffle("sala1.xls", "disciplina2.xls");
		System.out.println(ind2);
		System.out.println(ind2);
		Individuo ind3 = DAO.populaIndividuoShuffle("sala2.xls", "disciplina1.xls");

		System.out.println(ind3);
		/*		
		Populacao pop = new Populacao();
		pop.add(ind1);
		pop.add(ind2);
		pop.add(ind3);
		*/

	}

}
