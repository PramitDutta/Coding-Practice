
public class regexMatch {
	public static boolean regexMatcher(char[] exp, char[] str, int i, int j){
		if (i == exp.length && j == str.length)
			return true;

		if ((i == exp.length && j != str.length)
				|| (i != exp.length && j == str.length))
			return false;

		if (exp[i] == '?' || exp[i] == str[j])
			return regexMatcher(exp, str, i + 1, j + 1);

		if (exp[i] == '*')
			return regexMatcher(exp, str, i + 1, j) || regexMatcher(exp, str, i, j + 1)	|| regexMatcher(exp, str, i + 1, j + 1);
		
		return false;
	}
	public static void main(String[] args){
		char[] e ={'a','b','c','*','a','c','*'};
		char[] s ={'a','b','c','e','a','c','f'};
		
		boolean result=regexMatcher(e,s,3,5);
		System.out.println(result);
	}
}
