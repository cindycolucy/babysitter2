package babysitter2;

import static org.junit.Assert.*;

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

	@Test
	public void whenStartTimeIsAtFivePmStartTimeIsValid() {
		int startTime = 17;
		assertTrue(babysitter.isValidStartTime(startTime));
	}

	@Test
	public void whenStartTimeIsAtSixPmStartTimeIsValid() {
		int startTime = 18;
		assertTrue(babysitter.isValidStartTime(startTime));
	}

	@Test
	public void whenEndTimeIsAtFourAmEndTimeIsValid() {
		int endTime = 4;
		assertTrue(babysitter.isValidEndTime(endTime));
	}

	@Test
	public void whenEndTimeIsAfterFourAmEndTimeIsFalse() {
		int endTime = 5;
		assertFalse(babysitter.isValidEndTime(endTime));
	}

	@Test
	public void whenEndTimeIsBeforeFourAmEndTimeIsValid() {
		int endTime = 3;
		assertTrue(babysitter.isValidEndTime(endTime));
	}

	@Test
	public void whenEndTimeIsAtElevenPmEndTimeIsValid() {
		int endTime = 23;
		assertTrue(babysitter.isValidEndTime(endTime));
	}

	@Test
	public void whenEndTimeIsAtTenPmEndTimeIsValid() {
		int endTime = 22;
		assertTrue(babysitter.isValidEndTime(endTime));
	}

	@Test
	public void whenEndTimeIsFivePmEndTimeIsFalse() {
		int endTime = 17;
		assertFalse(babysitter.isValidEndTime(endTime));
	}

	@Test
	public void whenEndTimeIsSixPmEndTimeIsValid() {
		int endTime = 18;
		assertTrue(babysitter.isValidEndTime(endTime));
	}
}
