package com.aditusbr.test.sort;

/**
 * O objetivo deste exercÃ­cio Ã© ser capaz de implementar um algoritmo de
 * ordenaÃ§Ã£o que receba um array de inteiros e o deixe ordenado de forma
 * crescente. O algoritmo a ser utilizado fica a cargo do implementador.
 * 
 * Obviamente nÃ£o vale chamar a funÃ§Ã£o de ordenaÃ§Ã£o existente na API do Java.
 * 
 * Sinta-se livre para adicionar construtores/mÃ©todos auxiliares nesta classe se
 * achar que isso pode ajudar/simplificar sua implementaÃ§Ã£o, mas em hipÃ³tese
 * alguma faÃ§a modificaÃ§Ãµes na classe de testes.
 */


public class Sort {
	/**
	 * Método de implementação principal do teste
	 * Esse método recebe um array, e deve ordená-lo.
	 * Método de ordenação utilizado:
	 * QuickSort (Melhor: nlogn Média:nlogn Pior:n^2 Memória:logn)
	 * 
	 * Responsabilidade de ordenação foi passada ao método "quickSort"
	 * Que recursivamente faz a ordenação do array
	 * @param array
	 */
	public void sort(int[] array) 	{
		if (array.length >= 1) { //Se length do array é zero ou 1 nada precisa ser feito
			quickSort(array, 0, array.length-1);
		}	
	}
	
	/**
	 * Método recursivo do quickSort
	 * @param array
	 * @param i
	 * @param j
	 */
	public void quickSort(int array[], int i, int j) {
	      int partition = partition(array, i, j);
	      
	      if (i < partition - 1) {
	    	  quickSort(array, i, partition - 1);
	      }
	      if (partition < j) {
	    	  quickSort(array, partition, j);
	      }
	}
	
	/**
	 * Método de partição do quickSort
	 * Esse método faz a escolha do pivot, particionando o array
	 * Faz a comparação dos elementos, e finaliza com todos os elementos
	 * anteriores ao pivot sendo menores ou iguais a ele, e os sucessores, maiores que o pivot.
	 * o Retorno do método é a posição do pivot
	 * @param array
	 * @param i
	 * @param j
	 * @return
	 */
	public int partition(int array[], int i, int j)	{
	      int aux;
	      int pivot = array[(i + j) / 2];

	      while (i <= j) {
	    	  while (array[i] < pivot) {
	    		  i++;
	    	  }
	          while (array[j] > pivot) {
	        	  j--;
	          }
	          if (i <= j) {
	        	  //Troca elementos
	        	  aux = array[i];
	        	  array[i] = array[j];
	        	  array[j] = aux;
	        	  
	        	  j--;
	        	  i++;
	          }
	      }	    
	      return i;
	}
}
