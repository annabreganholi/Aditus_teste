package com.aditusbr.test.businessdays;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
	
	/**
	 * M�todo de implementa��o principal do teste
	 * Recebe como par�metros duas datas
	 * Verifica quais dos dias s�o �teis, e faz a contagem destes.
	 * O m�todo inclui o �ltimo dia do per�odo, e exclui o primeiro.
	 * @param date1
	 * @param date2
	 * @return
	 */
	public int count(Date date1, Date date2) {

		if(this.holidays.isEmpty())	addHolidays();
		int counter = 0;
		Date aux = date1;
		
		while (aux.compareTo(date2) < 0) {	
			//Dia ++;
			this.calendar.setTime(aux);
			this.calendar.add(Calendar.DAY_OF_MONTH, 1);
			aux = this.calendar.getTime();
			//Verifica se � dia �til:
			if (verifyDay(aux)) {
				counter++;
			}
		}
		
		return counter;
	}
	
	/**
	 * M�todo que faz a leitura e inser��o dos dados do arquivo "holidays.txt"
	 * e os insere no arraylist "holidays"
	 */
	public void addHolidays() {
		
		String fileName = "./resources/holidays.txt";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(s ->
			{
				try {
					holidays.add(dateFormat.parse(s));
				} 
				catch (ParseException e) {
					System.out.println("Parse error");
					e.printStackTrace();
				}
			});
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este m�todo faz a confer�ncia se uma data caiu(cai) em um dia �til
	 * Ele recebe como par�metro a data, e retorna true, se for dia �til e false caso contr�rio
	 * @param date
	 * @return
	 */
	public boolean verifyDay(Date date)
	{
		this.calendar.setTime(date);
		if(this.holidays.contains(getZeroTimeDate(date))) {
			return false;
		}
		else if (this.calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || 
				this.calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Este m�todo faz o "reset" do hor�rio, para que seja poss�vel comparar
	 * os dois objetos Date futuramente
	 * O m�todo recebe a data, e retorna a data com seus valores de 
	 * hora, minuto, segundos e milisegundos resetados para zero
	 * @param date
	 * @return
	 */	
	public static Date getZeroTimeDate(Date date) {
	    Calendar calendar = Calendar.getInstance();

	    calendar.setTime( date );
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);

	    return calendar.getTime();
	}
}