package babysitter2;

import java.util.Scanner;

public class Babysitter {
	
	private int startTime;
	private int endTime;
	
	public Babysitter(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
//assuming midnight is cutoff for start time
	public boolean isValidStartTime() {
		
		return startTime >= 17;
	}

	public boolean isValidEndTime() {
		
		return endTime <= 4 || endTime >= 18;
	}

}
