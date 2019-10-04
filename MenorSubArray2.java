import java.util.ArrayList;
import java.util.Scanner;

public class MenorSubArray2 {
	ArrayList<Integer> vetor = new ArrayList();
	int soma = 0;
	
	public static void main(String args []) {
		MenorSubArray2 resposta = new MenorSubArray2();
		//int array [] = {};
		int array [] = {1, 4, 45, 6, 0, 19};
		//int array [] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
		//int array [] = {1, 2, 4};
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o número que deseja consultar:");
		int numero = scanner.nextInt();
		int auxiliar;
		
		resposta.ordenaInicia(array);
		
		if(array.length < 1) {
			System.out.println("Array de entrada vazio.");
		}else {
			if(resposta.soma <= numero) {
				System.out.println("Impossível. A soma do array todo é menor que " + numero + ".");
			}else {
				for(int i = resposta.vetor.size() - 1; i >= 0; i--) {
					auxiliar = resposta.vetor.get(i);
					if(resposta.somaVetor(resposta.vetor) - auxiliar > numero) {
						resposta.vetor.remove(i);
					}				
				}
				System.out.println("O menor subarray possível com a menor soma é: " + resposta.vetor);
			}			
		}
	}
	
	//ordena crescente
	public void ordenaInicia(int vetor[]){
        boolean troca = true;
        int aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
            }
        }
        for(int i = 0; i < vetor.length; i++) {
        	if(vetor[i] == 0)
        		continue;
        	this.vetor.add(vetor[i]);
        	this.soma += vetor[i];
        }        
	}
	
	public int somaVetor(ArrayList<Integer> vetor) {
		int soma = 0;
		for(int i = 0; i < vetor.size(); i++)
			soma += vetor.get(i);
		return soma;
	}
	
}
