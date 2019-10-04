import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
 
public class FrequenciaNumero {
	ArrayList<Integer> lista = new ArrayList<Integer>();
	ArrayList<Integer> resposta = new ArrayList<Integer>();
	Map<Integer, Integer> mapNumeros = new HashMap<Integer, Integer>();
	
  public static void main(String[] args) {
	int vetor [] = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
    //int vetor [] = {4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5};
	FrequenciaNumero array = new FrequenciaNumero();
	array.ordena(vetor);
    array.inserirMap();
    
    ComparatorInts compInt = new ComparatorInts(array.mapNumeros);
    
    Map<Integer, Integer> mapaOrdenado = new TreeMap(compInt);
    mapaOrdenado.putAll(array.mapNumeros);
     
		
		
    for(Integer valor : mapaOrdenado.keySet()){ 
    	//System.out.println(valor + " " + array.mapNumeros.get(valor)); 
    	int numeroLista = valor;
    	int repeticaoNumero = array.mapNumeros.get(valor);
    	for(int i = 0; i < repeticaoNumero; i++) {
    		array.resposta.add(numeroLista);
    	}
    }
		 
    
    System.out.println(array.resposta);
}
  
  public void ordena(int vetor[]){
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
      for(int i = 0; i < vetor.length; i++)
    	  this.lista.add(vetor[i]);
	}
  
  public void inserirMap() {
	  int numero = this.lista.get(0), frequencia = 1;	  
	  
	  for(int i = 1; i < this.lista.size(); i++) {
		  
		  if(numero == this.lista.get(i)) {
			  frequencia++;
		  }else {
			  this.mapNumeros.put(numero, frequencia);
			  numero = this.lista.get(i);
			  frequencia = 1;
		  }		  
	  }
	  this.mapNumeros.put(numero, frequencia);
  }
  
  
}


//------------------------------------------------
class ComparatorInts implements Comparator<Integer> {
	   
	  Map<Integer, Integer> frequencia;
	   
	  public ComparatorInts(Map<Integer, Integer> frequencia) {
	    this.frequencia= frequencia;
	  }
	   
	  @Override
	  public int compare(Integer o1, Integer o2) {
		
		if(frequencia.get(o2).compareTo(frequencia.get(o1)) == 0) {
			return frequencia.get(o2);
		}else {			
			return frequencia.get(o2).compareTo(frequencia.get(o1));
		}
	  }
	}