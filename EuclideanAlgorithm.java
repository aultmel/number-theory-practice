import java.util.Scanner;
class EuclideanAlgorithm {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter 2 numbers:");
		int a = scnr.nextInt();
		int b = scnr.nextInt();
		System.out.print("The gcd is " + gcd(a,b));
	}
	public static int gcd(int a, int b) {
		int holder = a;
		if (a < b) {
			a = b;
			b = holder;
		}
		int r = a % b;
		int greatestCommonDivisor = 0;
		while (r != 0) {
			a = b;
			b = r;
			r = a % b;
		}
		greatestCommonDivisor = b;
		return greatestCommonDivisor;
	}
}