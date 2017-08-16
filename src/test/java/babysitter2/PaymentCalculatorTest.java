package babysitter2;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class PaymentCalculatorTest {

	PaymentCalculator paymentCalculator;
	
	@Test
	paymentCalculator calc = new PaymentCalculator();
	public void whenStartTimeIsBeforeFivePmStartTimeIsFalse() {
		int startTime = 16;
		assertFalse(paymentCalculator.isValidStartTime(startTime));
	}
}
