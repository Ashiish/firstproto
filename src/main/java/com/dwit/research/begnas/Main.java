package com.dwit.research.begnas;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {

	public static void main(String[] args) {
		
		Options options = constructBasicOptions();
		
		try{
			
			CommandLineParser parser = new BasicParser();
			CommandLine cmd = parser.parse(options, args);
			
			String startDate = cmd.getOptionValue("s");
			String endDate = cmd.getOptionValue("e");
			
			Boolean isLastDay = cmd.hasOption("l");
			
		//	Boolean testClass = cmd.hasOption("t");			
			
			if(isLastDay){
				if (startDate == null || startDate.isEmpty()) {
					System.err.println("Please enter start date.");
					HelpFormatter helpFormatter = new HelpFormatter();
					helpFormatter.printHelp("Main", options);
					return;
				}
				
				if (endDate == null || startDate.isEmpty()) {
					System.err.println("Please enter end date.");
					HelpFormatter helpFormatter = new HelpFormatter();
					helpFormatter.printHelp("Main", options);
					return;
				}
								
				new LastDayEachMonth(startDate, endDate);
			}else{
				System.err.println("Please choose an option.");
				HelpFormatter helpFormatter = new HelpFormatter();
				helpFormatter.printHelp("Main", options);
				return;
			}
		} catch (MissingArgumentException e) {
			HelpFormatter helpFormatter = new HelpFormatter();
			helpFormatter.printHelp("Main", options);
		} catch (ParseException e) {
			HelpFormatter helpFormatter = new HelpFormatter();
			helpFormatter.printHelp("Main", options);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static Options constructBasicOptions() {
		final Options basicOptions = new Options();
		basicOptions
				.addOption("s", "start-date",true,
						"Specify start date")
				.addOption("e", "end-date", true,
						"Specify end date.")
				.addOption("l", "lastDay", false, "Specify to get last date of each month between dates.");

		return basicOptions;
	}
}


