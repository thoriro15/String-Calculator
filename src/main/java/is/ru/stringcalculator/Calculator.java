package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text == "") {
			return 0;
		}
		else {
			int[] numbers = convertNumbersToInt(splitString(text));
			validateNumbers(numbers);
			return sum(numbers);
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
		String[] numbers;
		if(text.startsWith("//")) {
			String delimiter = Character.toString(text.charAt(2));
			String substringText = text.substring(text.indexOf("\n")+1, text.length());
			numbers = substringText.split(delimiter);
		}
		else {
			numbers = text.split(",|\n");
		}
		return numbers;
	}

	private static String negativeNumberErrorString(int[] numbers) {
		String error = "Negatives not allowed: ";
		int negativeCount = 0;
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] < 0) {
				if(negativeCount == 0) {
					error += numbers[i];
					negativeCount++;
				}
				else {
					error += ("," + numbers[i]);
					negativeCount++;
				}
				
			}
		}

		return error;
	}

	private static void validateNumbers(int[] numbers) {
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] < 0) {
				throw new IllegalArgumentException(negativeNumberErrorString(numbers));
			}
			else if(numbers[i] > 1000) {
				numbers[i] = 0;
			}
		}
	}
}