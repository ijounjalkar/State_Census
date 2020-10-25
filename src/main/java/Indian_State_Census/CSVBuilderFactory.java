package Indian_State_Census;

public class CSVBuilderFactory {
	public static <E> ICSVBuilder createCSVBuilder() {
		return new OpenCSVBuilder();
	}

}
