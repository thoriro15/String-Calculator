package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text == "") {
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")) {
			int[] numbers = convertNumbersToInt(splitString(text));
			validateNumbers(numbers);
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
			sum += numbers[i];
		}
		return sum;
	}

	private static String[] splitString(String text) {
		String[] numbers = text.split(",|\n");
		return numbers;
	}

	private static String negativeNumberErrorString(int[] numbers) {
		String error = "Negatives not allowed: ";

		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] < 0) {
				error += numbers[i];
				break;
			}
		}

		return error;
	}

	private static void validateNumbers(int[] numbers) {
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] < 0) {
				throw new IllegalArgumentException(negativeNumberErrorString(numbers));
			}
		}
	}
}