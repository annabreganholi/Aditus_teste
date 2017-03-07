package com.aditusbr.test.interestrate;

import java.util.Date;

/**
 * O objetivo deste exercício é conhecer um pouco como são calculados valores de
 * taxas de juros na economia brasileira. Nele serão implementados dois métodos:
 * 
 * No primeiro, o método receberá uma taxa de juros anualizada (equivalente ao
 * período de 1 ano) e um número de dias úteis e terá que devolver a taxa de
 * juros equivalente a esse período.
 *
 * No segundo, o método receberá duas datas como parâmetro e deverá ler as taxas
 * divulgadas para cada um dos dias do período (as taxas são divulgadas
 * anualizadas e em valor percentual), convertê-las para taxas diárias e
 * acumulá-las para chegar na taxa equivalente do período requisitado.
 * 
 * O arquivo com as taxas é o "/resources/cdi.txt" e cada linha possui uma data
 * no formato "yyyy-mm-dd" e a taxa equivalente a este dia, separados por ponto
 * e vírgula.
 * 
 * Para os cálculos, assuma que um ano possui 252 dias úteis e que o sistema
 * econômico brasileiro utiliza juros compostos. Se achar útil, é permitido
 * chamar um método dentro da implementação do outro.
 * 
 * Sinta-se livre para adicionar construtores/métodos auxiliares nesta classe se
 * achar que isso pode ajudar/simplificar sua implementação, mas em hipótese
 * alguma faça modificações na classe de testes.
 */
public class InterestRateCalculator {

	public double getPeriodRate(double anualRate, int days) {
		// Sua implementação deve vir aqui

		return 0;
	}

	public double getPeriodRate(Date date1, Date date2) {
		// Sua implementação deve vir aqui

		return 0;
	}
}
