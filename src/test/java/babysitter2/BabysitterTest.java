package babysitter2;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class BabysitterTest {

	Babysitter babysitter;

	@Before
	public void setup() {
		babysitter = new Babysitter();
	}

	@Test
	public void whenStartTimeIsBeforeFivePmStartTimeIsFalse() {
		int startTime = 16;
		assertFalse(babysitter.isValidStartTime(startTime));
	}
}