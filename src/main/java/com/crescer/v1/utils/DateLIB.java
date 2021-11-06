package com.crescer.v1.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateLIB {

	public static Integer diffYears(Date dataAnt, Date dataPost) {
		Calendar dateAnt = new GregorianCalendar(); 
		Calendar datePost = new GregorianCalendar(); 

		dateAnt.setTime(dataAnt); 
		datePost.setTime(dataPost); 
		
		return datePost.get(Calendar.YEAR) - dateAnt.get(Calendar.YEAR); 
	}

	public static Integer diffDays(Date dataAnt, Date dataPost) {
		Calendar dateAnt = new GregorianCalendar(); 
		Calendar datePost = new GregorianCalendar(); 

		dateAnt.setTime(dataAnt); 
		datePost.setTime(dataPost); 
		
		return datePost.get(Calendar.DATE) - dateAnt.get(Calendar.DATE); 
	}

	public static Integer diffMonths(Date dataAnt, Date dataPost) {
		Calendar dateAnt = new GregorianCalendar(); 
		Calendar datePost = new GregorianCalendar(); 

		dateAnt.setTime(dataAnt); 
		datePost.setTime(dataPost); 
		
		return datePost.get(Calendar.MONTH) - dateAnt.get(Calendar.MONTH); 
	}
	
	
}
