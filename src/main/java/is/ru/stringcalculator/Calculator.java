package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text == "") {
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")) {
			int[] numbers = convertNumbersToInt(splitString(text));
			return sum(numbers);
		}
		else {
			return toInt(text);
		}
	}

	private static int[] convertNumbersToInt(String[] numbers) {
		int[] intNumbers = new int[numbers.length];
		for(int i = 0; i < numbers.length; i++) {
			intNumbers[i] = toInt(numbers[i]);
		}
		return intNumbers;
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static int sum(int[] numbers) {
		int sum = 0;

		for(int i = 0; i < numbers.length; i++) {
			checkIfNegative(numbers[i]);
			sum += numbers[i];
		}
		return sum;
	}

	private static String[] splitString(String text) {
		String[] numbers = text.split(",|\n");
		return numbers;
	}

	private static void checkIfNegative(int number) {
		if(number < 0) {
			throw new IllegalArgumentException("Negatives not allowed: -1");
		}
	}
}