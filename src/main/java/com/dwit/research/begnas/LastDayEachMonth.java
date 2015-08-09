package com.dwit.research.begnas;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

public class LastDayEachMonth {

		LastDayEachMonth(String startDate, String endDate){
			
				System.out.println("Lastdate each month called.");
		}
		
		public static DateTime isDateTime(String string) {
			   DateTime value = null;
			   DateTimeParser[] parsers = {
			         DateTimeFormat.forPattern("MM/dd/yyyy").withPivotYear(1965)
			               .getParser(),
			         DateTimeFormat.forPattern("MM-dd-yyyy").getParser(),
			         DateTimeFormat.forPattern("MM/dd/yyyy").getParser()
			         
			         /*,
			         DateTimeFormat.forPattern("MM.dd.yyyy").getParser(),
			         DateTimeFormat.forPattern("yyyy-MM-dd").getParser(),
			         DateTimeFormat.forPattern("yyyy/MM/dd").getParser()*/ 
			         
			   };

			   org.joda.time.format.DateTimeFormatter formatter = new DateTimeFormatterBuilder()
			         .append(null, parsers).toFormatter();

			   try {
			      value = formatter.parseDateTime(string);
			   } catch (IllegalArgumentException e) {
			      value = null;
			   }

			   return value;
			}
}
