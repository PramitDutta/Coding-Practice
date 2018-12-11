package Amazon;

public class ComplexNumberMultiplication {
	public static String complexNumMult(String a, String b) {
		String result = "";
		String[] A = a.split("\\+");
		String[] B = b.split("\\+");
		int a1 = Integer.parseInt(A[0]);
		int a2 = Integer.parseInt(A[1].replace("i", ""));
		int b1 = Integer.parseInt(B[0]);
		int b2 = Integer.parseInt(B[1].replace("i", ""));
		int a1b1 = a1 * b1;
		int a2b2 = a2 * b2;
		int a1b2 = a1 * b2;
		int a2b1 = a2 * b1;

		String integerPart = a1b1 + (-1) * a2b2 + "";
		String complexPart = a1b2 + a2b1 + "i";

		result = integerPart + "+" + complexPart;
		return result;
	}

	public static void main(String[] args) {
		String a = "1+1i";
		String b = "1+1i";
		System.out.println(complexNumMult(a, b));
	}
}
