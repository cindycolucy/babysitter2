package babysitter2;

import java.util.Scanner;

public class BabysitterPayCalculatorApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the start time in 24-hour convention, after 5pm.");

		int startTime = input.nextInt();
		
		BabysitterPayCalculator babysitter;

		if (!babysitter.isValidStartTime()) {
			System.out.println("That is not a valid start time. Try again.");
		} else if (!babysitter.isValidBedtime()) {
			System.out.println("That is not a valid bedtime. Try again.");
		} else if (!babysitter.isValidEndTime()) {
			System.out.println("That is not a valid  end time. Try again.");
		}
		babysitter.calculatePay;

	}
}
