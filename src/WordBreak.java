import java.util.*;

public class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {
		int len=s.length();
		boolean[] dp = new boolean[len+1];
		
		dp[0]=true;
		for(int i=1;i<=len;i++){
			for(int j=0;j<i;j++){
				if(dp[j] && wordDict.contains(s.substring(j, i))){
					dp[i]=true;
					break;
				}
			}
		}
		return dp[len];
	}
	public static void main(String[] args){
		String s="leetcode";
		List<String> wordDict =new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		boolean result = wordBreak(s,wordDict);
		System.out.println(result);
	}
}
