package com.aditusbr.test.interestrate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * O objetivo deste exerc√≠cio √© conhecer um pouco como s√£o calculados valores de
 * taxas de juros na economia brasileira. Nele ser√£o implementados dois m√©todos:
 * 
 * No primeiro, o m√©todo receber√° uma taxa de juros anualizada (equivalente ao
 * per√≠odo de 1 ano) e um n√∫mero de dias √∫teis e ter√° que devolver a taxa de
 * juros equivalente a esse per√≠odo.
 *
 * No segundo, o m√©todo receber√° duas datas como par√¢metro e dever√° ler as taxas
 * divulgadas para cada um dos dias do per√≠odo (as taxas s√£o divulgadas
 * anualizadas e em valor percentual), convert√™-las para taxas di√°rias e
 * acumul√°-las para chegar na taxa equivalente do per√≠odo requisitado.
 * 
 * O arquivo com as taxas √© o "/resources/cdi.txt" e cada linha possui uma data
 * no formato "yyyy-mm-dd" e a taxa equivalente a este dia, separados por ponto
 * e v√≠rgula.
 * 
 * Para os c√°lculos, assuma que um ano possui 252 dias √∫teis e que o sistema
 * econ√¥mico brasileiro utiliza juros compostos. Se achar √∫til, √© permitido
 * chamar um m√©todo dentro da implementa√ß√£o do outro.
 * 
 * Sinta-se livre para adicionar construtores/m√©todos auxiliares nesta classe se
 * achar que isso pode ajudar/simplificar sua implementa√ß√£o, mas em hip√≥tese
 * alguma fa√ßa modifica√ß√µes na classe de testes.
 */


public class InterestRateCalculator {
	
	private int year = 252;
	private Map<Date, Double> cdi = new HashMap<>();
	private Calendar calendar = Calendar.getInstance();
	
	/**
	 * MÈtodo de implementaÁ„o principal para o primeiro teste
	 * … usado a fÛrmula (1 + taxaAnual ) ^ (diasDoPerÌodo/dias⁄teisAno) - 1;
	 * O mÈtodo retorna o valor do juros equivalente ‡ aquele perÌodo.
	 * @param anualRate
	 * @param days
	 * @return
	 */
	public double getPeriodRate(double anualRate, int days) {
		
		double period = (double) days/this.year;
		return Math.pow(( 1 + anualRate), period) - 1;
		
	}
	/**
	 * MÈtodo de ImplementaÁ„o principal do segundo teste
	 * Dado um perÌodo de dias, ele retorna o juros acumulado do perÌodo de dias.
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public double getPeriodRate(Date date1, Date date2) {
		Double interest = 0.0;
		Double periodInterest = 0.0;
		
		if(this.cdi.isEmpty())	{ //Adiciona as datas + taxasJuros em um mapa. Apenas se o mapa est· vazio.
			addCdi();
		}
		
		while (date1.compareTo(date2) < 0) {
						
			if (this.cdi.containsKey(getZeroTimeDate(date1))) {
				interest = getPeriodRate(this.cdi.get(getZeroTimeDate(date1))/100, 1);
				
				if (periodInterest == 0.0){
					periodInterest = 1 + interest ;
				} 
				else {
					periodInterest = periodInterest * (1 + interest);
				}
			}
			//Incrementa um dia
			this.calendar.setTime(date1);
			this.calendar.add(Calendar.DAY_OF_MONTH, 1);
			date1 = this.calendar.getTime();
		}
		
		return periodInterest -1;
	}
	
	/**
	 * MÈtodo que faz a leitura e inserÁ„o dos dados do arquivo "cdi.txt"
	 * e os insere no mapa "cdi"
	 */
	public void addCdi()
	{
		//Roda esse metodo so quando o mapa esta vazio
		String fileName = "./resources/cdi.txt";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))){			
			stream.forEach(s -> 
			{
				try {
					this.cdi.put(dateFormat.parse(s.split(";")[0]), Double.parseDouble(s.split(";")[1]));
				} 
				catch (ParseException e){
					System.out.println("Parse error");
					e.printStackTrace();
				}
			});
		} 
		catch (IOException e){
			e.printStackTrace();
		}		
	}
	
	/**
	 * Este mÈtodo faz o "reset" do hor·rio, para que seja possÌvel comparar
	 * os dois objetos Date futuramente
	 * O mÈtodo recebe a data, e retorna a data com seus valores de 
	 * hora, minuto, segundos e milisegundos resetados para zero
	 * @param date
	 * @return
	 */
	public static Date getZeroTimeDate(Date date){
		
	    Calendar calendar = Calendar.getInstance();

	    calendar.setTime( date );
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);

	    return calendar.getTime();
	}
	
}
