package Controle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import DAO.DAO;
import Modelo.Disciplina;
import Modelo.Individuo;
import Modelo.Populacao;
import Modelo.Sala;
import jxl.read.biff.BiffException;

public class IA {

	public static void main(String[] args) throws BiffException, IOException {
		
		
		//Leitor excel
		 
		ArrayList <Disciplina> disciplinas = null;
		ArrayList< Sala> salas = null;
		String arquivoSala = "tabela_sala.xls";
		salas = DAO.populaSala(arquivoSala);
		String arqvuivoDisciplina = "tabela_disciplina.xls";
		disciplinas = DAO.populaDisciplinas(arqvuivoDisciplina);
		
		if(disciplinas.size() > salas.size()){
			System.err.println("Solução impossível pois o numero de disciplinas é maior do que o de salas \n"
					+ "Buscando solução razoável...");
			
		}
		
		//Criacao populacao
		Populacao populacao = new Populacao();
		for(int i = 0; i < 1; i++){
			Collections.shuffle(disciplinas);
			
			Individuo ind = new Individuo(salas, disciplinas);
			
			
			populacao.add(ind);
			populacao.avaliacao();

			
		}
		
		

		//Avaliacao das populacoes - Penalizacao por violacao
		populacao.avaliacao();
		System.out.println("fitness tamanho pop : "+ populacao.getFitnessTamanho());
		System.out.println("fitness tipo pop: "+ populacao.getFitnessTipo());
		
		//Cruzamento - Elitista para
		populacao.cruzamento();
		
		//Selecao - 
		populacao.selecao();

		
		
		//log dos resultados

	}

}
