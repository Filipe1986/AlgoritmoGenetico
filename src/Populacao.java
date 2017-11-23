import java.lang.reflect.Array;
import java.util.ArrayList;

public class Populacao {

	ArrayList<Individuo> populacao;
	
	

	public Populacao() {
		populacao = new ArrayList<>();
	}



	public void add(Individuo individuo) {
		if (populacao.size() <= 0 ){
			populacao = new ArrayList<>();
		}
		populacao.add(individuo);
	}



	public void avaliacao() {
		// TODO
		// avalicao dos pares
		
	}



	public void cruzamento() {
		// TODO 
		//Cruza individuos
		
	}



	public void selecao() {
		// TODO
		//Remover individuos
		
	}
	
	
	
	
	
}
