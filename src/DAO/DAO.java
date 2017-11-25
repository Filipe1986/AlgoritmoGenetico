package DAO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import Modelo.Disciplina;
import Modelo.Individuo;
import Modelo.Sala;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DAO {

	public static ArrayList<Sala> populaSala(String arquivoSala) {
		ArrayList<Sala> salas = new ArrayList<>();
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(arquivoSala));
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}

		Sheet planilha = workbook.getSheet(0);
		int linhas = planilha.getRows();
		salas = new ArrayList<>();
		//salas = new Sala[linhas];

		for (int i = 1; i < linhas; i++) {


			String nome = planilha.getCell(0, i).getContents();

			int capacidade = Integer.parseInt( planilha.getCell(1, i).getContents());

			String tipo = planilha.getCell(2, i).getContents();

			Sala sala = new Sala(nome, capacidade, tipo);
			//System.out.println(sala);
			salas.add(sala);
			//salas[i] = sala;
		}

		workbook.close();
		return salas;
	}

	public static ArrayList<Disciplina> populaDisciplinas(String arqvuivoDisciplina) {
		ArrayList<Disciplina> disciplinas = new ArrayList<>();
		
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(arqvuivoDisciplina));
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}

		Sheet planilha = workbook.getSheet(0);
		int linhas = planilha.getRows();
		disciplinas = new ArrayList<Disciplina>();

		for (int i = 1; i < linhas-1; i++) {

			int id = Integer.parseInt(planilha.getCell(0, i).getContents());
			

			String nome = planilha.getCell(1, i).getContents();

			String curso = planilha.getCell(2, i).getContents();

			String tipoSala = planilha.getCell(3, i).getContents();

			int maxAlunos = Integer.parseInt(planilha.getCell(4, i).getContents());

			Disciplina disciplina = new Disciplina(id, nome, curso, tipoSala, maxAlunos);
			//disciplinas[i] = disciplina;
			disciplinas.add(disciplina);
		}

		workbook.close();
		return disciplinas;
	}
	
	public static Individuo populaIndividuo(String arquivoSala, String arqvuivoDisciplina ){
		Individuo ind = new Individuo(populaSala(arquivoSala), populaDisciplinas(arqvuivoDisciplina));
		return ind;
		
	}
	
	public static Individuo populaIndividuoShuffle(String arquivoSala, String arqvuivoDisciplina ){
		Individuo ind = new Individuo(populaSala(arquivoSala),
				populaDisciplinasShuffle(arqvuivoDisciplina));
		return ind;
		
	}
	
	
	public static ArrayList<Disciplina> populaDisciplinasShuffle(String arqvuivoDisciplina) {
		ArrayList<Disciplina> disciplinas = new ArrayList<>();
		
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(arqvuivoDisciplina));
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}

		Sheet planilha = workbook.getSheet(0);
		int linhas = planilha.getRows();
		disciplinas = new ArrayList<Disciplina>();

		for (int i = 1; i < linhas-1; i++) {

			int id = Integer.parseInt(planilha.getCell(0, i).getContents());
			

			String nome = planilha.getCell(1, i).getContents();

			String curso = planilha.getCell(2, i).getContents();

			String tipoSala = planilha.getCell(3, i).getContents();

			int maxAlunos = Integer.parseInt(planilha.getCell(4, i).getContents());

			Disciplina disciplina = new Disciplina(id, nome, curso, tipoSala, maxAlunos);
			//disciplinas[i] = disciplina;
			disciplinas.add(disciplina);
		}

		workbook.close();
		Collections.shuffle(disciplinas);
		return disciplinas;
	}
	
}
