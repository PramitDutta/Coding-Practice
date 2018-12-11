package LeetCode_Easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		int squareSum, remainder;
		while (set.add(n)) {
			squareSum = 0;
			while (n > 0) {
				remainder = n % 10;
				squareSum += remainder * remainder;
				n /= 10;
			}
			if (squareSum == 1)
				return true;
			else
				n = squareSum;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(120));
	}
}
