package Indian_State_Census;


import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.indianStateCensus.CSVBuilderException;
import com.indianStateCensus.CensusAnalyser;
import com.indianStateCensus.CensusAnalyserException;

import org.junit.jupiter.api.Test;

class CensusAnalyserTest {

	private static final String STATECENSUS_CSVFILE = "C:\\Users\\ADMIN\\eclipse-workspace\\Indian_State_Census\\IndianStateCensusData.csv";
	private static final String WRONG_FILE = "C:\\Users\\ADMIN\\eclipse-workspace\\Indian StateCensus\\IndiaStateCensusData.csv";
	private static final String WRONG_EXTENSION = "C:\\Users\\ADMIN\\eclipse-workspace\\Indian State Census\\IndiaStateCensusData.txt";
	private static final String CSVFILE = "C:\\Users\\ADMIN\\eclipse-workspace\\Indian State Census\\USCensusData.csv";
	private static final String STATE_CODE_CSV = "C:\\Users\\ADMIN\\eclipse-workspace\\Indian State Census\\IndiaStateCode.csv";

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

}
