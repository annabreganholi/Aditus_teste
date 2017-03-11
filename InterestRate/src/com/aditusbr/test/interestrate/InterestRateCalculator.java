package com.aditusbr.test.interestrate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	private int year = 252;
	private Map<Date, Double> cdi = new HashMap<>();
	private Calendar calendar = Calendar.getInstance();
	
	public double getPeriodRate(double anualRate, int days) {
		double periodInterest = 0.0;
		double period = (double) days/this.year;
		
		periodInterest = Math.pow(( 1 + anualRate), period) - 1;
		
		return periodInterest;
	}

	public double getPeriodRate(Date date1, Date date2) {
		// Sua implementação deve vir aqui
		Double interest = 0.0;
		Double periodInterest = 0.0;
		
		if(cdi.isEmpty()){
			addCdi();
		}
		
		
		while (date1.compareTo(date2) < 0){
						
			if (cdi.containsKey(getZeroTimeDate(date1))){
				interest = getPeriodRate(cdi.get(getZeroTimeDate(date1))/100, 1);
				
				
				if (periodInterest == 0.0){
					
					periodInterest = 1 + interest ;
					
				} else {
					
				periodInterest = periodInterest * (1 + interest);
								
				}
			}
			
			calendar.setTime(date1);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			date1 = calendar.getTime();
			
		}
		

		return periodInterest -1;
	}
	
	public void addCdi(){
		//Roda esse metodo so quando o mapa esta vazio
		String fileName = "./resources/cdi.txt";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			
			stream.forEach(s ->{
				try {
					cdi.put(dateFormat.parse(s.split(";")[0]), Double.parseDouble(s.split(";")[1]));
				} catch (ParseException e) {
					System.out.println("Parse error");
					e.printStackTrace();
				}
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	public static Date getZeroTimeDate(Date date) {
	    Date resetedDate = date;
	    Calendar calendar = Calendar.getInstance();

	    calendar.setTime( date );
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    
	    
	    resetedDate = calendar.getTime();

	    return resetedDate;
	}
	
}
