package Teste;


import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Test;

import Modelo.Disciplina;
import Modelo.Individuo;
import Modelo.Gene;
import Modelo.Populacao;
import Modelo.Sala;

public class TesteUnitario {

	@Test
	public void testFitnessPar() {
		Sala comum10 = new Sala("sala 1", 10, "C");
		Sala lab15 = new Sala("LAB 2", 15, "L");
		
		
		Disciplina DLab30 = new Disciplina(1, "TP1", "BSI", "L", 30);
		Disciplina DComum10 = new Disciplina(2, "TP2", "BSI", "C", 10);
		Disciplina DOpt15 = new Disciplina(3, "PSW", "BSI", "F", 15);
		
		Gene gene1 = new Gene(DLab30, comum10);
		assertEquals(20, gene1.getFitnessTamanho());
		assertEquals(3, gene1.getFitnessTipo());
		
		Gene gene2 = new Gene(DLab30, lab15);
		assertEquals(15, gene2.getFitnessTamanho());
		assertEquals(1, gene2.getFitnessTipo());
		
		
		Gene gene3 = new Gene(DOpt15, lab15);
		assertEquals(0, gene3.getFitnessTamanho());
		assertEquals(2, gene3.getFitnessTipo());
		

		Gene gene4 = new Gene(DOpt15, comum10);
		assertEquals(5, gene4.getFitnessTamanho());
		assertEquals(3, gene4.getFitnessTipo());
		

		assertEquals("sala 1", comum10.getNome());
		assertEquals(10, comum10.getCapacidade());
		assertEquals("C", comum10.getTipo());
		
		assertEquals("TP1", DLab30.getNome());
		assertEquals(30, DLab30.getMaxAlunos());
		assertEquals("BSI", DLab30.getCurso());
		
		
	}


}
