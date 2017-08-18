package babysitter2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BabysitterPayCalculatorTest {

	BabysitterPayCalculator babysitter;

	public BabysitterPayCalculator underTest(int startTime, int endTime) {
		return babysitter = new BabysitterPayCalculator(startTime, endTime);
	}

	public BabysitterPayCalculator underTest(int startTime, int bedTime, int endTime) {
		return babysitter = new BabysitterPayCalculator(startTime, bedTime, endTime);
	}

	// startTime Tests
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
	// endTime Tests

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

	//calculate pay
	@Test
	public void whenStartTimeIsFivePmAndBedTimeIsEightPmAndEndTimeIsEightPmShouldReturnThirtySixDollars() {
		int response = underTest(17, 20, 20).calculateFromStartToBedtime();
		assertEquals(36, response);
	}
	
	@Test
	public void whenStartTimeIsSixPmAndBedTimeIsEightPmAndEndTimeIsEightPmShouldReturnTwentyFourDollars() {
		int response = underTest(18, 20, 20).calculatePay();
		assertEquals(24, response);
	}
	@Test
	public void whenStartTimeIsSixPmAndBedTimeIsEightPmAndEndTimeIsNinePmShouldReturnThirtyTwoDollars() {
		int response = underTest(18, 20, 21).calculatePay();
		assertEquals(32, response);
	}
	@Test
	public void whenStartTimeIsSixPmAndBedTimeIsEightPmAndEndTimeIsTenPmShouldReturnFortyDollars() {
		int response = underTest(18, 20, 22).calculatePay();
		assertEquals(40, response);
	}
	@Test
	public void shouldReturnThirtyTwoFromMidnightToTwoAm() {
		int response = underTest(18, 20, 2).calculateFromMidnightToEndTime();
		assertEquals(32, response);
	}
	@Test
	public void whenStartTimeIsSixPmAndBedTimeIsEightPmAndEndTimeIsOneAmShouldReturnSeventyTwoDollars() {
		int response = underTest(18, 20, 1).calculatePay();
		assertEquals(72, response);
	}
	
	//assuming bedtime is always before midnight
	@Test
	public void whenBedTimeIsEightIsValid() {
		assertTrue(underTest(18, 20, 1).isValidBedtime());
	}
	public void whenBedTimeIsElevenIsValid() {
		assertTrue(underTest(18, 23, 1).isValidBedtime());
	}
	public void whenBedTimeIsMidnightIsNotValid() {
		assertFalse(underTest(18, 0, 1).isValidBedtime());
	}
	
}
