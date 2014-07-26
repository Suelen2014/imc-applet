public class Pessoa {

	private String nome;   //campo protegido - encapsulado
	private String dataNascimento;

	//Construtor
	public Pessoa(String nome, String dataNascimento) {
		
		this.setNome(nome);
		this.setAltura(dataNascimento);
	}

	public void setNome(String nome) {
		
		this.nome = nome;
	}

	public void setAltura(String dataNascimento) {

		this.dataNascimento = dataNascimento;
	}

	//método  
	public String getNome() {

		return this.nome;
	}

	//método 
	public String getDataNascimento() {

		return this.dataNascimento;
	}

	//método
	public String toString() { //

		return "Nome: " + getNome() + "\n" 
			   + "Data de Nascimento: " + getDataNascimento(); 
	}	
}
