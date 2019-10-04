import java.util.ArrayList;
import java.util.Scanner;

public class PrimeiroCaracterNaoRepetido {
	public static void main(String arg[]) {
		System.out.println("Insera a string:");
		Scanner entrada = new Scanner(System.in);
		String string = entrada.nextLine();
		ArrayList<Character> array = new ArrayList<Character>();
		char letra = ' ';
		boolean existeCaracterNaoRepetido = false;
				
		if(string.length() < 1) {
			System.out.println("String vazia.");
		}else {
			for(int i = 0; i < string.length(); i++) {
				array.add(string.charAt(i));				
			}				
			
			while(array.size() > 0) {
				letra = array.get(0);
				array.remove(0);			
				if(array.contains(letra)) {
					while(array.contains(letra)) {
						array.remove(array.lastIndexOf(letra));
					}				
				}else {
					System.out.println("O primeiro caracter que não se repete é " + letra + ".");
					existeCaracterNaoRepetido = true;
					break;
				}
			}
			if(array.size() == 0 && !existeCaracterNaoRepetido) {
				System.out.println("Todos os caracteres repetem.");
			}
		}		
		entrada.close();
	}
}
