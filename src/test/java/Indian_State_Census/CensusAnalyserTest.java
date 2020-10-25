package Indian_State_Census;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.indianStateCensus.CSVBuilderException;
import com.indianStateCensus.CSVStateCensus;
import com.indianStateCensus.CensusAnalyser;
import com.indianStateCensus.CensusAnalyserException;
import com.indianStateCensus.StateCodeCSV;

import org.junit.jupiter.api.Test;

class CensusAnalyserTest {

	private static final String STATECENSUS_CSVFILE = "C:\\Users\\adity\\eclipse-workspace\\Indian State Census\\IndiaStateCensusData.csv";
	private static final String WRONG_FILE = "C:\\Users\\adity\\eclipse-workspace\\Indian StateCensus\\IndiaStateCensusData.csv";
	private static final String WRONG_EXTENSION = "C:\\Users\\adity\\eclipse-workspace\\Indian State Census\\IndiaStateCensusData.txt";
	private static final String CSVFILE = "C:\\Users\\adity\\eclipse-workspace\\Indian State Census\\USCensusData.csv";
	private static final String STATE_CODE_CSV = "C:\\Users\\adity\\eclipse-workspace\\Indian State Census\\IndiaStateCode.csv";

	/**
	 * UC1TestCase1
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException 
	 */
	@Test
	public void givenCSVFile_IfMatchNumberOfRecords_ShouldReturnTrue() throws IOException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		int count = 0;
		try {
			count = analyser.loadCSVData(STATECENSUS_CSVFILE);
			System.out.println(count);
		} catch (CensusAnalyserException e) {}
		assertEquals(29, count);
	}

	/**
	 * UC1TestCase2
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException 
	 */
	@Test
	public void givenCSVFile_IfWrongFile_ShouldThrowError() throws IOException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		try {
			int count = analyser.loadCSVData(WRONG_FILE);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.NO_FILE, e.type);
		}
	}

	/**
	 * UC1TestCase3
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException 
	 */
	@Test
	public void givenCSVFile_WhenFileCorrect_ButExtensionIncorrect_ShouldThrowError() throws IOException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		try {
			int count = analyser.loadCSVData(WRONG_EXTENSION);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.NO_FILE, e.type);
		}
	}

	/**
	 * UC1TestCase4
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException 
	 */
	@Test
	public void givenCSVFile_WhenFileCorrect_ButDelimiterIncorrect_ShouldThrowError() throws IOException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		try {
			int count = analyser.loadCSVData(STATECENSUS_CSVFILE);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE, e.type);
		}
	}

	/**
	 * UC1TestCase5
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException 
	 */
	@Test
	public void givenCSVFile_WhenFileCorrect_ButHeaderIncorrect_ShouldThrowError() throws IOException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		try {
			int count = analyser.loadCSVData(CSVFILE);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE, e.type);
		}
	}

	/**UC2TestCase1
	 * @throws IOException
	 * @throws CSVBuilderException 
	 */
	@Test
	public void givenStateFile_IfMatchNumberOfRecords_ShouldReturnTrue() throws IOException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		try {
			int count = analyser.loadIndianStateCode(STATE_CODE_CSV);
			System.out.println(count);
			assertEquals(37, count);
		} catch (CensusAnalyserException e) {}
	}
	/**
	 * UC2TestCase2
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException 
	 */
	@Test
	public void givenStateFile_IfWrongFile_ShouldThrowError() throws IOException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		try {
			int count = analyser.loadIndianStateCode(WRONG_FILE);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.NO_FILE, e.type);
		}
	}

	/**
	 * UC2TestCase3
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException 
	 */
	@Test
	public void givenStateFile_WhenFileCorrect_ButExtensionIncorrect_ShouldThrowError() throws IOException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		try {
			int count = analyser.loadIndianStateCode(WRONG_EXTENSION);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.NO_FILE, e.type);
		}
	}

	/**
	 * UC2TestCase4
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException 
	 */
	@Test
	public void givenStateFile_WhenFileCorrect_ButDelimiterIncorrect_ShouldThrowError() throws IOException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		try {
			int count = analyser.loadIndianStateCode(CSVFILE);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE, e.type);
		}
	}

	/**
	 * UC2TestCase5
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException 
	 */
	@Test
	public void givenStateFile_WhenFileCorrect_ButHeaderIncorrect_ShouldThrowError() throws IOException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		try {
			int count = analyser.loadIndianStateCode(CSVFILE);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE, e.type);
		}
	}
	/**
	 * TestCase for Usecase3 for sorting CSV file data
	 * 
	 * @throws IOException
	 * @throws CensusAnalyserException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenIndianCensusData_WhenSortedOnState_ShouldReturnSortedResult()
			throws IOException, CensusAnalyserException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		analyser.loadCSVData(STATECENSUS_CSVFILE);
		String sortedCensusData = analyser.getStateWiseSortedCensusData();
		CSVStateCensus[] censusCSV = new Gson().fromJson(sortedCensusData, CSVStateCensus[].class);
		assertEquals("Andhra Pradesh", censusCSV[0].state);
	}

	/**
	 * TestCase for Usecase3 for sorting CSV file data
	 * 
	 * @throws IOException
	 * @throws CensusAnalyserException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenIndianCensusData_WhenSortedOnState_ShouldReturnSortedResultForLastState()
			throws IOException, CensusAnalyserException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		analyser.loadCSVData(STATECENSUS_CSVFILE);
		String sortedCensusData = analyser.getStateWiseSortedCensusData();
		CSVStateCensus[] censusCSV = new Gson().fromJson(sortedCensusData, CSVStateCensus[].class);
		assertEquals("West Bengal", censusCSV[censusCSV.length - 1].state);
	}
	/**
	 * TestCase for Usecase4 Sorting StateCode CSV File data
	 * 
	 * @throws IOException
	 * @throws CensusAnalyserException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenIndianCensusData_WhenSortedOnStateCode_ShouldReturnSortedResultForLastState()
			throws IOException, CensusAnalyserException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		analyser.loadIndianStateCode(STATE_CODE_CSV);
		String sortedCensusData = analyser.getStateCodeWiseSortedCensusData();
		StateCodeCSV[] censusCSV = new Gson().fromJson(sortedCensusData, StateCodeCSV[].class);
		assertEquals("West Bengal", censusCSV[censusCSV.length - 1].state);
	}
	@Test
	public void givenIndianCensusData_WhenSortedOnStatePopulation_ShouldReturnSortedResult()
			throws IOException, CensusAnalyserException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		analyser.loadCSVData(STATECENSUS_CSVFILE);
		String sortedCensusData = analyser.getPopulationWiseSortedCensusData();
		CSVStateCensus[] censusCSV = new Gson().fromJson(sortedCensusData, CSVStateCensus[].class);
		assertEquals("Uttar Pradesh", censusCSV[0].state);
	}
	@Test
	public void givenIndianCensusData_WhenSortedOnStatePopulation_ShouldReturnSortedResultForLast()
			throws IOException, CensusAnalyserException, CSVBuilderException {
		CensusAnalyser analyser = new CensusAnalyser();
		analyser.loadCSVData(STATECENSUS_CSVFILE);
		String sortedCensusData = analyser.getPopulationWiseSortedCensusData();
		CSVStateCensus[] censusCSV = new Gson().fromJson(sortedCensusData, CSVStateCensus[].class);
		assertEquals("Sikkim", censusCSV[censusCSV.length - 1].state);
	}

}
