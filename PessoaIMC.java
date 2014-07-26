import java.lang.Math;

public abstract class PessoaIMC extends Pessoa {
	
	private double peso;
	private double altura;

	//Construtor
	public PessoaIMC(String nome, String dataNascimento, double peso, double altura) {
		super(nome, dataNascimento); //herda o construtor da classe Pessoa
		this.setPeso(peso);
		this.setAltura(altura);		
	}

	public void setPeso(double peso) {
		
		this.peso = peso;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	//método
	public double getPeso() {

		return this.peso;
	}

	//método
	public double getAltura() {

		return this.altura;
	}

	//método
	public double calculaIMC(double peso, double altura) {

		double calculo = (getPeso()/(Math.pow(getAltura(),2))); //
		return calculo;
	}

	//o método abstrato resultIMC() que não recebe parâmetros e retorna uma instância da classe String. (o método não é implementado nesta classe - abstrato) 
	public abstract String resultIMC();
	

	//método
	public String toString() {

		//chama o método toString da superclasse Pessoa
		return super.toString() + "\n" 
			   + "Peso: " + getPeso() + " kg\n"
			   + "Altura: " + getAltura() + " m\n";		
	}
}
