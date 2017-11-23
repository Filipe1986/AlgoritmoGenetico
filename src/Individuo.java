import java.util.ArrayList;

public class Individuo {

	ArrayList<Par> pares;

	public Individuo(ArrayList<Disciplina> disciplinas, ArrayList<Sala> salas ) {
		pares = new ArrayList<>();
		//Mais disciplina do que sala
		if(disciplinas.size() > salas.size()){
			for(int i = 0; i < salas.size(); i++){
				pares.add(new Par(disciplinas.get(i), salas.get(i)));
			}
			for(int i = salas.size(); i < disciplinas.size(); i++){
				pares.add(new Par(disciplinas.get(i), new Sala("-", 0, "-") ));
			}
			//Mais sala do que disciplina
		}else{
			for(int i = 0; i < disciplinas.size(); i++){
				pares.add(new Par(disciplinas.get(i), salas.get(i)));
			}
			for(int i = disciplinas.size(); i < salas.size(); i++){
				pares.add(new Par(new Disciplina(0, "-", "-", "-", 0), salas.get(i)));
			}
		}
		
	}

	public void addPar(Disciplina disciplina, Sala sala){
		pares.add(new Par(disciplina, sala));
		
	}
	
	@Override
	public String toString() {
		String toString = null;
		for (Par par : pares) {
			toString += par.getDisciplina().toString() + "\n "+ par.getSala().toString();
		}
		return toString;
	}
	
	
}
