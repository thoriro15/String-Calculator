package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class CalculatorTest {

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testFiveNumbers() {
		assertEquals(15 , Calculator.add("1,2,3,4,5"));
	}

	@Test 
	public void testNewLineSplit() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testNegatives() throws IllegalArgumentException {
	    thrown.expect(IllegalArgumentException.class);
	    thrown.expectMessage("Negatives not allowed: -1");
	   	Calculator.add("-1,2");

	}

	@Test
	public void testManyNegatives() throws IllegalArgumentException {
	    thrown.expect(IllegalArgumentException.class);
	    thrown.expectMessage("Negatives not allowed: -1,-5");
	   	Calculator.add("-1,2,-5");

	}

	@Test
	public void biggerThanThousand() {
		assertEquals(2, Calculator.add("1001,2"));
	}

	@Test
	public void changeDelimiter() {
		assertEquals(6, Calculator.add("//;\n4;2"));
	}
}