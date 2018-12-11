package Amazon;

public class CountPrimes {
	public static int countPrime(int n) {
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (notPrime[i] == false) {
				count++;
				for (int j = 2; i * j < n; j++) {
					notPrime[i * j] = true;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int n = 10;
		int result = countPrime(n);
		System.out.print(result);
	}
}
