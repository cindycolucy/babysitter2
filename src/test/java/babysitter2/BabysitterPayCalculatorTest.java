package babysitter2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BabysitterPayCalculatorTest {

	private static final int TIME_1_AM = 1;
	private static final int TIME_8_PM = 20;
	private static final int TIME_5_PM = 17;
	private static final int TIME_6_PM = 18;

	public BabysitterPayCalculator createUnderTest(int startTime, int endTime) {
		return new BabysitterPayCalculator(startTime, endTime);
	}

	public BabysitterPayCalculator createUnderTest(int startTime, int bedTime, int endTime) {
		return new BabysitterPayCalculator(startTime, bedTime, endTime);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void shouldNotAllowStartTimeBefore5Pm() {
		
		int time4Pm = 16;
		int time11Pm = 23;
		BabysitterPayCalculator underTest = createUnderTest(time4Pm, time11Pm);
		underTest.calculatePay();
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void shouldNotAllowEndTimeAfter4Am() {
		
		int time4Pm = 16;
		int time5Am = 5;
		BabysitterPayCalculator underTest = createUnderTest(time4Pm, time5Am);
		underTest.calculatePay();
	}
	
	// startTime Tests
	@Test
	public void whenStartTimeIsBeforeFivePmStartTimeIsNotValid() {
		int time4Pm = 16;
		assertFalse(createUnderTest(time4Pm, TIME_6_PM).isValidStartTime());
	}

	@Test
	public void whenStartTimeIsAtFivePmStartTimeIsValid() {
		assertTrue(createUnderTest(TIME_5_PM, TIME_6_PM).isValidStartTime());
	}

	@Test
	public void whenStartTimeIsAtSixPmStartTimeIsValid() {
		assertTrue(createUnderTest(TIME_6_PM, TIME_6_PM).isValidStartTime());
	}

	// endTime Tests
	@Test
	public void whenEndTimeIsAtFourAmEndTimeIsValid() {
		int time4Am = 4;
		assertTrue(createUnderTest(TIME_5_PM, time4Am).isValidEndTime());
	}

	@Test
	public void whenEndTimeIsAfterFourAmEndTimeIsNotValid() {
		int time5Am = 5;
		assertFalse(createUnderTest(TIME_5_PM, time5Am).isValidEndTime());
	}

	@Test
	public void whenEndTimeIsBeforeFourAmEndTimeIsValid() {
		int time3Am = 3;
		assertTrue(createUnderTest(TIME_5_PM, time3Am).isValidEndTime());
	}

	@Test
	public void whenEndTimeIsAtElevenPmEndTimeIsValid() {
		int time11Pm = 23;
		assertTrue(createUnderTest(TIME_5_PM, time11Pm).isValidEndTime());
	}

	@Test
	public void whenEndTimeIsAtTenPmEndTimeIsValid() {
		int time10Pm = 22;
		assertTrue(createUnderTest(TIME_5_PM, time10Pm).isValidEndTime());
	}

	@Test
	public void whenEndTimeIsFivePmEndTimeIsNotValid() {
		assertFalse(createUnderTest(TIME_5_PM, TIME_5_PM).isValidEndTime());
	}

	@Test
	public void whenEndTimeIsSixPmEndTimeIsValid() {
		assertTrue(createUnderTest(TIME_5_PM, TIME_6_PM).isValidEndTime());
	}

	// calculate pay Tests
	@Test
	public void whenStartTimeIsFivePmAndBedTimeIsEightPmAndEndTimeIsEightPmShouldReturnThirtySixDollars() {
		int response = createUnderTest(TIME_5_PM, TIME_8_PM, TIME_8_PM).calculateFromStartToBedtime();
		assertEquals(36, response);
	}

	@Test
	public void whenStartTimeIsSixPmAndBedTimeIsEightPmAndEndTimeIsEightPmShouldReturnTwentyFourDollars() {
		int response = createUnderTest(TIME_6_PM, TIME_8_PM, TIME_8_PM).calculatePay();
		assertEquals(24, response);
	}

	@Test
	public void whenStartTimeIsSixPmAndBedTimeIsEightPmAndEndTimeIsNinePmShouldReturnThirtyTwoDollars() {
		int time9Pm = 21;
		int response = createUnderTest(TIME_6_PM, TIME_8_PM, time9Pm).calculatePay();
		assertEquals(32, response);
	}

	@Test
	public void whenStartTimeIsSixPmAndBedTimeIsEightPmAndEndTimeIsTenPmShouldReturnFortyDollars() {
		int time10Pm = 22;
		int response = createUnderTest(TIME_6_PM, TIME_8_PM, time10Pm).calculatePay();
		assertEquals(40, response);
	}

	@Test
	public void shouldReturnThirtyTwoFromMidnightToTwoAm() {
		int time2Am = 2;
		int response = createUnderTest(TIME_6_PM, TIME_8_PM, time2Am).calculateFromMidnightToEndTime();
		assertEquals(32, response);
	}

	@Test
	public void whenStartTimeIsSixPmAndBedTimeIsEightPmAndEndTimeIsOneAmShouldReturnSeventyTwoDollars() {
		int response = createUnderTest(TIME_6_PM, TIME_8_PM, TIME_1_AM).calculatePay();
		assertEquals(72, response);
	}

	// bedtime Tests
	// assuming bedtime is supposed to be before midnight
	@Test
	public void whenBedTimeIsEightPmIsValid() {
		assertTrue(createUnderTest(TIME_6_PM, TIME_8_PM, TIME_1_AM).isValidBedtime());
	}

	@Test
	public void whenBedTimeIsElevenPmIsValid() {
		int time11Pm = 23;
		assertTrue(createUnderTest(TIME_6_PM, time11Pm, TIME_1_AM).isValidBedtime());
	}

	@Test
	public void whenBedTimeIsMidnightIsNotValid() {
		int timeMidnight = 0;
		assertFalse(createUnderTest(TIME_6_PM, timeMidnight, TIME_1_AM).isValidBedtime());
	}

	@Test
	public void whenBedTimeIsOneAmIsNotValid() {
		assertFalse(createUnderTest(TIME_6_PM, TIME_1_AM, TIME_1_AM).isValidBedtime());
	}

}
