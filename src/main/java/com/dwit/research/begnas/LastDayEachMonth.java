package com.dwit.research.begnas;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

public class LastDayEachMonth {

		LastDayEachMonth(String startDate, String endDate){				
				if(isDateTime(startDate) == null){
					System.err.println("Please enter a valid start date.");
					return;
				}
				
				if(isDateTime(endDate) == null){
					System.err.println("Please enter a valid end date.");
					return;
				}
			
				List<DateTime> lastDays = getLastDayOfEachMonth(isDateTime(startDate), isDateTime(endDate));
				
				for(DateTime dates: lastDays){
					System.out.println("Last day of month " +dates.getMonthOfYear()+" in year " +dates.getYear()+" is " +dates.toString("MM-dd-YYYY"));
				}
								
		}
		
		public static DateTime isDateTime(String string) {
			   
			   DateTime value = null;
			   DateTimeParser[] parsers = {
			         DateTimeFormat.forPattern("MM/dd/yyyy").withPivotYear(1965)
			               .getParser(),
			         DateTimeFormat.forPattern("MM-dd-yyyy").getParser()			         
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
		
		
		public ArrayList<DateTime> getLastDayOfEachMonth(DateTime startDate, DateTime endDate) {

			ArrayList<DateTime> returnList = new ArrayList<DateTime>();
						
			try{
				
				if(startDate != null && endDate !=null){
					int months = Months.monthsBetween(startDate, endDate).getMonths();
					
				

					DateTime incomingEndDate = endDate.dayOfMonth()
							.withMaximumValue(); // read end month

					
					if(DateTimeComparator.getDateOnlyInstance().compare(
									incomingEndDate, endDate) == 0){
						returnList.add(endDate);
					}

					
				    for (int i = 0; i < months; i++) { 
				      DateTime requiredDate = endDate.minusMonths(1).dayOfMonth().withMaximumValue(); 
				      endDate = endDate.minusMonths(1); 
				      returnList.add(requiredDate); 
				    }				
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return returnList;
		}
		
		
}
