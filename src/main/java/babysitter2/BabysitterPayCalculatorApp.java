package babysitter2;

import java.util.Scanner;

public class BabysitterPayCalculatorApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		BabysitterPayCalculator babysitter;

		System.out.println("Enter the start time in 24-hour convention, after 5pm.");

		int startTime = input.nextInt();

		System.out.println("Enter the bedtime in 24-hour convention, before midnight.");

		int bedTime = input.nextInt();

		System.out.println("Enter the end time in 24-hour convention, before 4am.");

		int endTime = input.nextInt();

		babysitter = new BabysitterPayCalculator(startTime, bedTime, endTime);

		System.out.println("The payment is $" + babysitter.calculatePay());

		input.close();

	}

}
