package Test;

public class PerfectNumber {
	public static boolean checkPerfect(int num) {
		if (num == 1)
			return false;
		int sum = 0;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				sum += i + num / i;
			}
		}
		sum++;
		return sum == num;
	}

	public static void main(String[] args) {
		int num = 28;
		System.out.println(checkPerfect(num));
	}
}
