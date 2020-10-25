package com.indianStateCensus;

public class CSVBuilderFactory {
	public static <E> ICSVBuilder createCSVBuilder() {
		return new OpenCSVBuilder();
	}

}
