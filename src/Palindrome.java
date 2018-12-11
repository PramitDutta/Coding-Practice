
public class Palindrome {
	public static boolean isPalindrome(int number){
		int palindrome=number;
		int reverse=0;
		while(palindrome!=0){
			int remainder=palindrome%10;
			reverse=reverse*10+remainder;
			palindrome/=10;
		}
		
		if(number==reverse)
			return true;
		else
			return false;
	}
	public static void main(String[] args){
		int num=121;
		boolean result = isPalindrome(num);
		System.out.println(result);
	}
}
