import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DAO {

	public static ArrayList<Sala> populaSala(ArrayList<Sala> salas) {

		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File("tabela_sala1.xls"));
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}

		Sheet planilha = workbook.getSheet(0);
		int linhas = planilha.getRows();
		salas = new ArrayList<>();
		//salas = new Sala[linhas];

		System.out.println("Leitura da planilha de salas:\n nuúmero de linhas " + linhas);
		for (int i = 1; i < linhas-2; i++) {


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

	public static ArrayList<Disciplina> populaDisciplinas(ArrayList<Disciplina> disciplinas) {

		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File("tabela_disciplina.xls"));
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}

		Sheet planilha = workbook.getSheet(0);
		int linhas = planilha.getRows();
		disciplinas = new ArrayList<Disciplina>();

		for (int i = 1; i < linhas; i++) {

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
}
