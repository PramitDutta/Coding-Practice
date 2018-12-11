
public class LongestPalindromicSubstring {
	public static String longestPalindrome(String s){
		if(s.isEmpty()) return null;
		if(s.length()==1) return s;
		
		String longest = s.substring(0, 1);
		for(int i=0;i<s.length();i++){
			//longest with center of i
			String temp = helper(s,i,i);
			if(temp.length()>longest.length()){
				longest=temp;
			}
			//longest with center of i,i+1
			temp=helper(s,i,i+1);
			if(temp.length()>longest.length()){
				longest=temp;
			}
		}
		return longest;
	}
	public static String helper(String s, int i, int j){
		while(i>=0 && j<=s.length()-1 && s.charAt(i)==s.charAt(j)){
			i--;
			j++;
		}
		return s.substring(i+1, j);
	}
	public static void main(String[] args){
		String s="forgeeksskeegfor";
		System.out.println("Longest String: " +longestPalindrome(s));
	}
}
