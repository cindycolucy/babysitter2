package babysitter2;

import java.util.Scanner;

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
//assuming midnight is cutoff for start time
	public boolean isValidStartTime() {
		
		return startTime >= 17;
	}

	public boolean isValidEndTime() {
		
		return endTime <= 4 || endTime >= 18;
	}
	public int calculatePay() {
		return calculateFromStartToBedtime() + calculateFromBedtimeToEndTimeLessThanMidnight();
	}
	public int calculateFromStartToBedtime() {
		return (bedTime-startTime)*12;
	}
	public int calculateFromBedtimeToEndTimeLessThanMidnight() {
		return (endTime-bedTime)*8;
	}
	public int calculateFromMidnightToEndTime() {
		return (endTime-0)*16;
	}

}
