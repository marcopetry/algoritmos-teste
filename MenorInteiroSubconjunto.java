
public class MenorInteiroSubconjunto {
	
	public static void main(String arg []) {
		
		int vetor [] = {1, 2, 3, 4, 5, 6};
		//int vetor [] = {1, 3, 6, 10, 11, 15};
		//int vetor [] = {1, 1, 1, 1};
		//int vetor [] = {1, 1, 3, 4};
		//int vetor [] = {1, 2, 5, 10, 20, 40};
		int menorInteiro = 1;
		
		for(int i = 0; i < vetor.length; i++) {
			if(vetor[i] > menorInteiro)
				break;
			else
				menorInteiro += vetor[i];
		}
		System.out.println("O menor inteiro impossível de formar no conjunto é: " + menorInteiro + ".");
	}
	
}
