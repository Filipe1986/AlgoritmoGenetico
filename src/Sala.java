
public class Sala {
	
	private String nome;
	private int capacidade;
	private String tipo;
	
	public Sala(String nome, int capacidade, String tipo) {

		this.nome = nome;
		this.capacidade = capacidade;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		
		return nome + "- Capacidade: " + capacidade + " tipo: "+ tipo + "\n" ;
	}
	
}
