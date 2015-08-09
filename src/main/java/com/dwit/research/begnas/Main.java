/**
 * 
 */
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
		System.out.println( "Hello World!" );
		
		Options options = constructBasicOptions();
		
		try{
			
			CommandLineParser parser = new BasicParser();
			CommandLine cmd = parser.parse(options, args);
			
			String startDate = cmd.getOptionValue("s");
			String endDate = cmd.getOptionValue("e");
			
			if (startDate == null) {
				System.err.println("Please enter start date.");
				HelpFormatter helpFormatter = new HelpFormatter();
				helpFormatter.printHelp("LastDayEachMonth", options);
				return;
			}
			
			if (endDate == null) {
				System.err.println("Please enter end date.");
				HelpFormatter helpFormatter = new HelpFormatter();
				helpFormatter.printHelp("LastDayEachMonth", options);
				return;
			}
			
			System.out.println("Start date :" + startDate);
			System.out.println("End date :" + endDate);
				

		} catch (MissingArgumentException e) {
			HelpFormatter helpFormatter = new HelpFormatter();
			helpFormatter.printHelp("LastDateEachMonth", options);
		} catch (ParseException e) {
			HelpFormatter helpFormatter = new HelpFormatter();
			helpFormatter.printHelp("LastDateEachMonth", options);			
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
						"Specify end date.");

		return basicOptions;
	}


}


