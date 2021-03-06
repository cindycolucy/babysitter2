package babysitter2;

public class BabysitterPayCalculator {

	private int startTime;
	private int bedTime;
	private int endTime;

	public BabysitterPayCalculator(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public BabysitterPayCalculator(int startTime, int bedTime, int endTime) {
		this.startTime = startTime;
		this.bedTime = bedTime;
		this.endTime = endTime;

	}

	// assuming midnight is cutoff for start time
	public boolean isValidStartTime() {
		return startTime >= 17;
	}

	public boolean isValidBedtime() {
		return bedTime >= 17 && bedTime <= 23;
	}

	public boolean isValidEndTime() {
		return endTime <= 4 || endTime >= 18;
	}

	public int calculatePay() {
		
		if(!isValidStartTime()) {
			throw new UnsupportedOperationException("bad start time");
		}
		
		if(!isValidEndTime()) {
			throw new UnsupportedOperationException("bad end time");
		}
		
		int pay = 0;
		if (endTime <= 4) {
			pay = calculateFromStartToBedtime() + calculateFromBedtimeToMidnight() + calculateFromMidnightToEndTime();
		} else {
			pay = calculateFromStartToBedtime() + calculateFromBedtimeToEndTimeLessThanMidnight();
		}
		return pay;
	}

	public int calculateFromStartToBedtime() {
		return (bedTime - startTime) * 12;
	}

	private int calculateFromBedtimeToMidnight() {
		return (24 - bedTime) * 8;
	}

	private int calculateFromBedtimeToEndTimeLessThanMidnight() {
		return (endTime - bedTime) * 8;
	}

	public int calculateFromMidnightToEndTime() {
		return (endTime - 0) * 16;
	}

}
