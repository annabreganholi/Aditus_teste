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
import java.time.format.DateTimeFormatter;

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
	
	public void main(String[] args){
		//Chamar metodo count
		
	}
	
	//contador para cada dia 'util, nos dias inuteis, nao conta
	//Verifica se 'e dia 'util/inutil vendo if sab/dom depois if arraylist contains
	//Nao caindo em nenhum dos ifs, cont++
	
	public int count(Date date1, Date date2) {
		
		addHolidays();
		// Sua implementação deve vir aqui
			//For : cada dia at'e ultimo dia
			//VerifyDate
			//count
		
		return 0;
	}
	
	public void addHolidays(){
		//Roda esse metodo so quando o arraylist esta vazio
		String fileName = "./resources/holidays.txt";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String stringDate = new String();
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
		
		holidays.forEach(System.out::println);
	}


	public boolean verifyDay(Date date){
		//Date weekend? FALSE
		//Date Feriado? FALSE
		//Date util? TRUE
		return false;
	}
}
/*

*/