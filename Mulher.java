public class Mulher extends PessoaIMC {

	//tem que criar o mesmo construtor pois caso contrário, dá erro de compilação pois o construtor desta classe não vai conter os mesmos argumentos da classe herdeira
	public Mulher(String nome, String dataNascimento, double peso, double altura) {

		super(nome, dataNascimento, peso, altura);
	}

	//implementação do método abstrato 
	public String resultIMC() {

		double IMC = super.calculaIMC(getPeso(), getAltura());

		if(IMC < 19) {

			return "Abaixo do peso ideal";
		} else if((IMC > 19) && (IMC < 25.8)) {

			return "Peso ideal";
		} else {

			return "Acima do peso ideal";
		}
	}
}
