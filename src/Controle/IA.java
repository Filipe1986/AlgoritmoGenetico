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
		
		String salaTeste = "sala1.xls";
		String disciplinaTeste = "disciplina1.xls";
		
		ArrayList< Sala> salas = DAO.populaSala(salaTeste);
		ArrayList <Disciplina> disciplinas = DAO.populaDisciplinas(disciplinaTeste);
		
		
		if(disciplinas.size() > salas.size()){
			System.err.println("Solucao impossivel pois o numero de disciplinas maior do que o de salas \n"
					+ "Buscando solucao razoavel...");
			
		}
		
		Populacao populacao = new Populacao();
		for(int i = 0; i < 16; i++){
			
			Collections.shuffle(salas);
			
			Individuo ind = DAO.populaIndividuoShuffle(salaTeste, disciplinaTeste);
			populacao.add(ind);
		}

		
		//Cruzamento - Elitista para
		SelecaoPorTorneio selecao = new SelecaoPorTorneio();
		Individuo ind = selecao.selecaoPorTorneio(populacao, 2);
		
		System.out.println(ind);
	}

}
