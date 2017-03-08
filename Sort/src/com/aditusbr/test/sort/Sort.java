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

	public void sort(int[] array) {
		//CombSort
		// Sua implementação deve vir aqui
		int gap = array.length-1;
		double shrink = 1.3;
		boolean sorted = false;
		int aux;
		
		while (!sorted){
			
			gap = (int) Math.floor(gap/shrink);
			
			if (gap > 1) sorted = false;
			else {
				gap = 1;
				sorted = true;
			}
			
			int i = 0;
			
			while ((i+gap) < array.length-1){
				if (array[i] > array[i+gap]){
					aux = array[i];
					array[i] = array[i+gap];
					array[i+gap] = aux;
					sorted = false;
				}
				
				i++;
			}
		} 
	}

}
