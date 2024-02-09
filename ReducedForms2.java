import java.util.Scanner;
class ReducedForms2 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter a discriminant between -32768 and 0 (not inclusive):");
		int d = scnr.nextInt();
		while (d <= -32768 || d >= 0) {
			System.out.println("Please stay between -32768 and 0:");
			d = scnr.nextInt();
		}
		System.out.println("The reduced forms of this discriminant are: ");
		double sqrtOf = -d / 3;
		int aLessThan = (int)Math.pow(sqrtOf, 0.5);
		int[] valuesOfA = new int[aLessThan];
		for (int k = 0; k < valuesOfA.length; k++) {
			valuesOfA[k] = k + 1;
		}
		int a = 0;
		int b = 0;
		int c = 0;
		for (int i = 0; i < valuesOfA.length; i++) {
			for (int j = 1 - valuesOfA[i]; j <= valuesOfA[i]; j++) {
				a = valuesOfA[i];
				b = j;
				int e = (b*b) - d;
				int f = 4*a;
				if (e % f == 0) {
					c = e / f;
					if (gcd(gcd(a,b),c)==1) {
						if (isReduced(a,b,c)) {
							System.out.println(a + "x^2 + " + b + "xy + " + c + "y^2.");
						}
					}
				}
			}
		}
	}
	
	
	
	public static int gcd(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		int greatestCommonDivisor = 0;
		if (a == 0) {
			greatestCommonDivisor = b;
		}
		if (b == 0) {
			greatestCommonDivisor = a;
		}
		else {
			int holder = a;
			if (a < b) {
				a = b;
				b = holder;
			}
			int r = a % b;
			while (r != 0) {
				a = b;
				b = r;
				r = a % b;
			}
			greatestCommonDivisor = b;
		}	
		return greatestCommonDivisor;
	}
	public static void reducingForms(int a, int b, int c) {
		int gcdab = gcd(a,b);
		int gcdabc = gcd(gcdab, c);
		if (gcdabc != 1) {
			a /= gcdabc;
			b /= gcdabc;
			c /= gcdabc;
		}
		int d = b*b - 4*a*c;
		if (d < 0 && a > 0) {
			if (a > c) {
				int a1 = a;
				a = c;
				c = a1;
			}
		}
	}
	public static boolean isReduced(int a, int b, int c) {
		if (Math.abs(b)<= a && a <= c) {
			if (Math.abs(b)==a || a==c) {
				if (b >= 0) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		else {
			return false;
		}
		return true;
	}
}