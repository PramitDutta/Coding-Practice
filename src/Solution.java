import java.util.*;
public class Solution {
	public static String reverseStr(String s, int k) {
		char[] result = s.toCharArray();
		for(int i=0;i<result.length;i+=2*k){
			int j=Math.min(result.length-1, i+k-1);
			for(int h=i;h<=(i+j)/2;h++){
				char temp=result[h];
				result[h]=result[i+j-h];
				result[i+j-h]=temp;
			}
		}
		return new String(result);
     }
	 
	
	
	
	public static void main(String[] args){
		String s = "abcdefg";
		int k=2;
		String res= reverseStr(s,k);
		System.out.println(res);
	}
 }