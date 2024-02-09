import java.util.Scanner;
class ReducedForms {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Given an equation f(x,y) = ax^2 + bxy + cy^2, give a, b, and c:");
		System.out.println("a:");
		int num1 = scnr.nextInt();
		System.out.println("b: ");
		int num2 = scnr.nextInt();
		System.out.println("c: ");
		int num3 = scnr.nextInt();
		System.out.println("The equation is f(x,y) = " + num1 + "x^2 + " + num2 + "xy + " + num3 + "y^2.");
		int gcd = gcd(num1, num2, num3);
		System.out.println("The gcd of a, b, and c is " + gcd);
		if (gcd(num1, num2, num3) > 1) {
			num1 = num1 / gcd;
			num2 = num2 / gcd;
			num3 = num3 / gcd;
			System.out.println("This equation is not in primitive form. The primitive form of this equation is:");
			System.out.println("f(x,y) = " + num1 + "x^2 + " + num2 + "xy + " + num3 + "y^2.");
		}
		else if (gcd(num1, num2, num3) == 1) {
			System.out.println("This equation is in primitive form.");
		}
		if (Math.abs(num2) <= num1 && num1 <= num3) {
			if ((Math.abs(num2)==num1 || num1==num3) && num2 >= 0) {
				System.out.println("This equation is in reduced form.");
			}
		}
	}

	public static int gcd(int num1, int num2, int num3) {
		int[] divisors1 = new int[num1];
		int[] divisors2 = new int[num2];
		int[] divisors3 = new int[num3];
		int i = 1;
		int i1 = 0;
		while (i <= num1) {
			if ((num1 % i) == 0) {
				divisors1[i1] = i;
				i1++;
			}
			i++;
		}
		
		int j = 1;
		int j1 = 0;
		while (j <= num2) {
			if ((num2 % j) == 0) {
				divisors2[j1] = j;
				j1++;
			}
			j++;
		}


		int k = 1;
		int k1 = 0;
		while (k <= num3) {
			if ((num3 % k) == 0) {
				divisors3[k1] = k;
				k1++;
			}
			k++;
		}
		int[] sameDivisors12 = new int[Math.max(num1, num2)];
	
		for (int q = 0; q < divisors1.length; q++) {
			if (divisors1[q] != 0) {
				for (int r = 0; r < divisors2.length; r++) {
					if (divisors2[r] == divisors2[q]) {
						sameDivisors12[q] = divisors2[q];
					}
				}
			}
		}
		int[] sameDivisors123 = new int[Math.max(num1, sameDivisors12.length)];
		for (int p = 0; p < divisors3.length; p++) {
			if (divisors3[p] != 0) {
				for (int g = 0; g < sameDivisors12.length; g++) {
					if (sameDivisors12[g] == divisors3[p]) {
						sameDivisors123[p] = divisors3[p];
					}
				}
			}
		}
		int greatestCommonDivisor = 0;
		for (int w = 1; w < sameDivisors123.length; w++) {
			if (sameDivisors123[w] != 0) {
				if (sameDivisors123[w] > sameDivisors123[w+1]) {
					greatestCommonDivisor = sameDivisors123[w];
				}
			}
		}
		return greatestCommonDivisor;
	}
	
}