package Controle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import DAO.DAO;
import Modelo.Disciplina;
import Modelo.Individuo;
import Modelo.Populacao;
import Modelo.Sala;
import jxl.read.biff.BiffException;

public class IA {

	public static void main(String[] args) throws BiffException, IOException {
		
		 
		String arquivoSala = "tabela_sala.xls";
		String arqvuivoDisciplina = "tabela_disciplina.xls";
		
		ArrayList< Sala> salas = DAO.populaSala(arquivoSala);
		ArrayList <Disciplina> disciplinas = DAO.populaDisciplinas(arqvuivoDisciplina);
		
		
		if(disciplinas.size() > salas.size()){
			System.err.println("Solução impossível pois o numero de disciplinas é maior do que o de salas \n"
					+ "Buscando solução razoável...");
			
		}
		
		Populacao populacao = new Populacao();
		for(int i = 0; i < 10; i++){
			
			Collections.shuffle(salas);
			
			Individuo ind = new Individuo(salas, disciplinas);
			populacao.add(ind);
			
			
			
		}
		
		populacao.avaliacao();
		Scanner ler = new Scanner(System.in);
		int n = 1;
		while(n != 0 ){
		System.out.printf("Imprimir qual individuo? ");
		n = ler.nextInt();
		
		System.out.println(populacao.getIndividuo(n));
		
		}
		ler.close();

		//System.out.println("fitness tamanho pop : "+ populacao.getFitnessTamanho());
		//System.out.println("fitness tipo pop: "+ populacao.getFitnessTipo());
		
		//Cruzamento - Elitista para
		populacao.cruzamento();
		
		//Selecao - 
		populacao.selecao();

		
		
		//log dos resultados

	}

}
