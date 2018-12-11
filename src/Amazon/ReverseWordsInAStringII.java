package Amazon;

public class ReverseWordsInAStringII {
	public static String reverseWords(String s){
		char[] str = s.toCharArray();
		int i=0;
		for(int j=0;j<str.length;j++){
			if(str[j]==' '){
				reverse(str,i,j-1);
				i=j+1;
			}
		}
		reverse(str,i,str.length-1);
		
		reverse(str,0,str.length-1);
		return new String(str);
	}
	private static void reverse(char[] s, int left, int right){
		while(left<right){
			char temp = s[left];
			s[left]=s[right];
			s[right]=temp;
			left++; right--;
		}
	}
	public static void main(String[] args){
		String s = "the sky is blue";
		System.out.println(reverseWords(s));
		
	}
}
