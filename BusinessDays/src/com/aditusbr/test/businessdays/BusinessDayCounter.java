package com.aditusbr.test.businessdays;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * O objetivo deste exercício é ser capaz de implementar um método que seja
 * capaz de determinar quantos dias úteis existem entre duas datas (exclusive a
 * primeira, inclusive a segunda).
 * 
 * Além de descontar dias de fim de semana, a classe deve ser capaz de
 * considerar a existência de feriados no período e não contá-los como dias
 * úteis também.
 * 
 * A lista dos feriados do período utilizado nos testes estará disponível no
 * arquivo "/resources/holidays.txt" com uma data de feriado por linha no
 * formato "dd/mm/yyyy", sua classe deverá ser capaz de ler e interpretar esse
 * arquivo e utilizar essa informação na implementação.
 * 
 * Sinta-se livre para adicionar construtores/métodos auxiliares nesta classe se
 * achar que isso pode ajudar/simplificar sua implementação, mas em hipótese
 * alguma faça modificações na classe de testes.
 */
public class BusinessDayCounter {

	private ArrayList<Date> holidays = new ArrayList<>();
	private Calendar calendar = Calendar.getInstance();
	
	public int count(Date date1, Date date2) {
		// Sua implementação deve vir aqui
		//For : cada dia at� ultimo dia
		//VerifyDate
		//count
		if(holidays.isEmpty())	addHolidays();
		int counter = 0;
		
		while (getZeroTimeDate(date1).compareTo(getZeroTimeDate(date2)) < 0){
			date1 = new Date(date1.getTime() + TimeUnit.DAYS.toMillis(1)); //Add a day
			if (verifyDay(date1)) counter++;
		}
		
		return counter;
	}
	
	public void addHolidays(){
		//Roda esse metodo so quando o arraylist esta vazio
		String fileName = "./resources/holidays.txt";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			
			stream.forEach(s ->{
				try {
					holidays.add(dateFormat.parse(s));
				} catch (ParseException e) {
					System.out.println("Parse error");
					e.printStackTrace();
				}
				});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	public boolean verifyDay(Date date){
		
		calendar.setTime(date);
		
		if(holidays.contains(getZeroTimeDate(date)))return false;
		else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || 
				calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) return false;
		else return true;
		//Date weekend? FALSE
		//Date Feriado? FALSE
		//Date util? TRUE
		//return false;
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