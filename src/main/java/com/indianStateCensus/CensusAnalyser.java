package com.indianStateCensus;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;

import CSVReader.CSVBuilderException;
import CSVReader.CSVBuilderFactory;
import CSVReader.ICSVBuilder;

public class CensusAnalyser<E> {List<CSVStateCensus> censusCSVList = null;
List<StateCodeCSV> stateCodeCSVList = null;
public int loadCSVData(String csvFile) throws CensusAnalyserException, IOException, CSVBuilderException {
	try {
		Reader reader = Files.newBufferedReader(Paths.get(csvFile));
		@SuppressWarnings("unchecked")
		ICSVBuilder<CSVStateCensus> csvBuilder = CSVBuilderFactory.createCSVBuilder();
		censusCSVList =  csvBuilder.getCSVFileList(reader, CSVStateCensus.class);
		return censusCSVList.size();
	} catch (RuntimeException e) {
		throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.INCORRECT_FILE);
	} catch (NoSuchFileException e) {
		throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.NO_FILE);
	}
}

public int loadIndianStateCode(String csvFile) throws IOException, CensusAnalyserException, CSVBuilderException {
	try {
		Reader reader = Files.newBufferedReader(Paths.get(csvFile));
		ICSVBuilder<StateCodeCSV> csvBuilder = CSVBuilderFactory.createCSVBuilder();
		stateCodeCSVList =  csvBuilder.getCSVFileList(reader, StateCodeCSV.class);
		return stateCodeCSVList.size();
	} catch (RuntimeException e) {
		throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.INCORRECT_FILE);
	} catch (NoSuchFileException e) {
		throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.NO_FILE);
	}
}

public String getStateWiseSortedCensusData() throws CensusAnalyserException {
	if(censusCSVList == null || censusCSVList.size() == 0) {
		throw new CensusAnalyserException("No Census Data", CensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
	}
	Comparator<CSVStateCensus> censusComparator = Comparator.comparing(census -> census.state);
	this.sort(censusCSVList, censusComparator);
	String sortedStateCensusJson = new Gson().toJson(censusCSVList);
	return sortedStateCensusJson;
}

private <E> void sort(List<E> cnesusList, Comparator<E> censusComparator) {
	for (int i = 0; i < cnesusList.size(); i++) {
		for (int j = 0; j < cnesusList.size() - i - 1; j++) {
			E census1 =  cnesusList.get(j);
			E census2 =  cnesusList.get(j + 1);
			if (censusComparator.compare(census1, census2) > 0) {
				cnesusList.set(j, census2);
				cnesusList.set(j + 1, census1);
			}
		}
	}
}

public String getStateCodeWiseSortedCensusData() throws CensusAnalyserException {
	if(stateCodeCSVList == null || stateCodeCSVList.size() == 0) {
		throw new CensusAnalyserException("No Census Data", CensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
	}
	Comparator<StateCodeCSV> censusComparator = Comparator.comparing(census -> census.stateCode);
	this.sort(stateCodeCSVList, censusComparator);
	String sorted = new Gson().toJson(stateCodeCSVList);
	return sorted;
}

public String getPopulationWiseSortedCensusData() throws CensusAnalyserException {
	if(censusCSVList == null || censusCSVList.size() == 0) {
		throw new CensusAnalyserException("No Census Data", CensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
	}
	Comparator<CSVStateCensus> censusComparator = Comparator.comparing(census -> census.population);
	this.sortPopulation(censusComparator);
	String sortedStateCensusJson = new Gson().toJson(censusCSVList);
	return sortedStateCensusJson;
}

private void sortPopulation(Comparator<CSVStateCensus> censusComparator) {
	for (int i = 0; i < censusCSVList.size(); i++) {
		for (int j = 0; j < censusCSVList.size() - i - 1; j++) {
			CSVStateCensus census1 =  censusCSVList.get(j);
			CSVStateCensus census2 =  censusCSVList.get(j + 1);
			if (censusComparator.compare(census1, census2) < 0) {
				censusCSVList.set(j, census2);
				censusCSVList.set(j + 1, census1);
			}
		}
	}
}		

}
