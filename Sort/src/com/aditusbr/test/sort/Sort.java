package com.aditusbr.test.sort;

/**
 * O objetivo deste exercício é ser capaz de implementar um algoritmo de
 * ordenação que receba um array de inteiros e o deixe ordenado de forma
 * crescente. O algoritmo a ser utilizado fica a cargo do implementador.
 * 
 * Obviamente não vale chamar a função de ordenação existente na API do Java.
 * 
 * Sinta-se livre para adicionar construtores/métodos auxiliares nesta classe se
 * achar que isso pode ajudar/simplificar sua implementação, mas em hipótese
 * alguma faça modificações na classe de testes.
 */


public class Sort {
	/**
	 * M�todo de implementa��o principal do teste
	 * Esse m�todo recebe um array, e deve orden�-lo.
	 * M�todo de ordena��o utilizado:
	 * QuickSort (Melhor: nlogn M�dia:nlogn Pior:n^2 Mem�ria:logn)
	 * 
	 * Responsabilidade de ordena��o foi passada ao m�todo "quickSort"
	 * Que recursivamente faz a ordena��o do array
	 * @param array
	 */
	public void sort(int[] array) 	{
		if (array.length >= 1) { //Se length do array � zero ou 1 nada precisa ser feito
			quickSort(array, 0, array.length-1);
		}	
	}
	
	/**
	 * M�todo recursivo do quickSort
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
	 * M�todo de parti��o do quickSort
	 * Esse m�todo faz a escolha do pivot, particionando o array
	 * Faz a compara��o dos elementos, e finaliza com todos os elementos
	 * anteriores ao pivot sendo menores ou iguais a ele, e os sucessores, maiores que o pivot.
	 * o Retorno do m�todo � a posi��o do pivot
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
