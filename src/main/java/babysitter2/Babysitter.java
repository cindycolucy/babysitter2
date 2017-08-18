package babysitter2;

import java.util.Scanner;

public class Babysitter {

	public boolean isValidStartTime(int startTime) {
		
		return startTime >= 17;
	}

	public boolean isValidEndTime(int endTime) {
		
		return endTime <= 4 || endTime >= 18;
	}

}
