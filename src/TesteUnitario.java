import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.Test;

public class TesteUnitario {

	@Test
	public void testFitnessPar() {
		Sala comum10 = new Sala("sala 1", 10, "C");
		Sala lab15 = new Sala("LAB 2", 15, "L");
		
		
		Disciplina DLab30 = new Disciplina(1, "TP1", "BSI", "L", 30);
		Disciplina DComum10 = new Disciplina(2, "TP2", "BSI", "C", 30);
		Disciplina DOpt15 = new Disciplina(3, "PSW", "BSI", "F", 15);
		
		Par par1 = new Par(DLab30, comum10);
		assertEquals(20, par1.getFitnessTamanho());
		assertEquals(3, par1.getFitnessTipo());
		
		Par par2 = new Par(DLab30, lab15);
		assertEquals(15, par2.getFitnessTamanho());
		assertEquals(1, par2.getFitnessTipo());
		
		
		Par par3 = new Par(DOpt15, lab15);
		assertEquals(0, par3.getFitnessTamanho());
		assertEquals(2, par3.getFitnessTipo());
		

		Par par4 = new Par(DOpt15, comum10);
		assertEquals(5, par4.getFitnessTamanho());
		assertEquals(3, par4.getFitnessTipo());
		

		assertEquals("sala 1", comum10.getNome());
		assertEquals(10, comum10.getCapacidade());
		assertEquals("C", comum10.getTipo());
		
		assertEquals("TP1", DLab30.getNome());
		assertEquals(30, DLab30.getMaxAlunos());
		assertEquals("BSI", DLab30.getCurso());
		
		
	}
	
	@Test
	public void testFitnessIndividuo(){
		
		
		Disciplina DLab30 = new Disciplina(1, "TP1", "BSI", "L", 30);
		Disciplina DComum10 = new Disciplina(2, "TP2", "BSI", "C", 10);
		Disciplina DOpt15 = new Disciplina(3, "PSW", "BSI", "F", 15);
		ArrayList<Disciplina>disciplinas = new ArrayList<>();
		
		
		
		Sala comum10 = new Sala("sala 1", 10, "C");
		Sala lab15 = new Sala("LAB 2", 15, "L");
		ArrayList<Sala> salas = new ArrayList<>();
		
		
		
		salas.add(comum10);
		//salas.add(lab15);
		
		disciplinas.add(DLab30);
		//disciplinas.add(DComum10);
		//disciplinas.add(DOpt15);
		
		Individuo individuo = new Individuo(disciplinas, salas);
		assertEquals(1, individuo.quantidadePares());
		assertEquals(20, individuo.getFitnessTamanho());
		assertEquals(3, individuo.getFitnessTipo());
		
		individuo.addPar(DLab30, comum10);
		assertEquals(2, individuo.quantidadePares());
		assertEquals(40, individuo.getFitnessTamanho());
		assertEquals(6, individuo.getFitnessTipo());
		
		individuo.addPar(DLab30, comum10);
		assertEquals(3, individuo.quantidadePares());
		assertEquals(60, individuo.getFitnessTamanho());
		assertEquals(9, individuo.getFitnessTipo());
		
		
		individuo.addPar(DComum10, comum10);
		assertEquals(4, individuo.quantidadePares());
		assertEquals(60, individuo.getFitnessTamanho());
		assertEquals(10, individuo.getFitnessTipo());
		
		individuo.addPar(DComum10, lab15);
		assertEquals(5, individuo.quantidadePares());
		assertEquals(65, individuo.getFitnessTamanho());
		assertEquals(13, individuo.getFitnessTipo());
		
		
		Populacao pop = new Populacao();
		pop.add(individuo);
		pop.avaliacao();
		assertEquals(65, pop.getFitnessTamanho());
		assertEquals(13, pop.getFitnessTipo());
		
		
		pop.add(individuo);
		pop.avaliacao();
		assertEquals(65, pop.getFitnessTamanho());
		assertEquals(13, pop.getFitnessTipo());
		

		
		
	}

}
