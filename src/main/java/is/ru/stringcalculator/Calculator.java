package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text == "") {
			return 0;
		}
		else if(text.contains(",")) {
			String[] numbers = text.split(",");
			return sum(numbers);
		}
		else {
			return toInt(text);
		}
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static int sum(String[] numbers) {
		int sum = 0;

		for(int i = 0; i < numbers.length; i++) {
			sum += toInt(numbers[i]);
		}
		return sum;
	}
}