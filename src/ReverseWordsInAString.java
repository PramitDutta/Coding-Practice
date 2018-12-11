
public class ReverseWordsInAString {
	public static String reverseMe(String str){
		char []str1 = reverseString(str.toCharArray(),0, str.length());
		int startIndex = 0;
			for (int i =0; i< str1.length;i++){
				if(str1[i] == ' '){
					reverseString(str1, startIndex,(i));
					startIndex = i+1;
				}
			}
		reverseString(str1, startIndex,str1.length);
		return new String(str1);
		}

		public static char[] reverseString(char[] str, int start, int end){
			for (int i = start; i<end; i++,end--){
				char temp = str[i];
				str[i] = str[end-1];
				str[end-1] = temp;
			}
		return str;
		}

		public static void main(String[] args) {
		String result = reverseMe("I love programming");
		System.out.println(result);
		}
}
