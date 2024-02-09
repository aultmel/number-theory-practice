import java.util.Scanner;
class HelloWorldApp {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Hello world!");
		System.out.println("Enter a number:");
		int test1 = scnr.nextInt();
		double double1 = Math.pow(test1, 0.5);
		double double2 = double1 + 1;
		System.out.println("The square root of " + test1 + " is between " + (int)double1 + " and " + (int)double2);
	}
}