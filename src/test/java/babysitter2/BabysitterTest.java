package babysitter2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BabysitterTest {

	Babysitter babysitter;
	

	public Babysitter underTest(int startTime, int endTime) {
		return babysitter = new Babysitter(startTime, endTime);
		
	}

	@Test
	public void whenStartTimeIsBeforeFivePmStartTimeIsFalse() {
		assertFalse(underTest(16, 18).isValidStartTime());
	}

	@Test
	public void whenStartTimeIsAtFivePmStartTimeIsValid() {
		assertTrue(underTest(17, 18).isValidStartTime());
	}

	@Test
	public void whenStartTimeIsAtSixPmStartTimeIsValid() {
		assertTrue(underTest(18, 18).isValidStartTime());
	}

	@Test
	public void whenEndTimeIsAtFourAmEndTimeIsValid() {
		assertTrue(underTest(17, 4).isValidEndTime());
	}

	@Test
	public void whenEndTimeIsAfterFourAmEndTimeIsFalse() {
		assertFalse(underTest(17, 5).isValidEndTime());
	}

	@Test
	public void whenEndTimeIsBeforeFourAmEndTimeIsValid() {
		assertTrue(underTest(17, 3).isValidEndTime());
	}

	@Test
	public void whenEndTimeIsAtElevenPmEndTimeIsValid() {
		assertTrue(underTest(17, 23).isValidEndTime());
	}

	@Test
	public void whenEndTimeIsAtTenPmEndTimeIsValid() {
		assertTrue(underTest(17, 22).isValidEndTime());
	}

	@Test
	public void whenEndTimeIsFivePmEndTimeIsFalse() {
		assertFalse(underTest(17, 17).isValidEndTime());
	}

	@Test
	public void whenEndTimeIsSixPmEndTimeIsValid() {
		assertTrue(underTest(17, 18).isValidEndTime());
	}
}
