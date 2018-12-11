
public class LCSubstring {
	public static String LCS(String a, String b){
		StringBuilder sb = new StringBuilder();
		if(a==null ||a.isEmpty() ||b==null ||b.isEmpty())
			return "";
		String str1=a.toLowerCase();
		String str2=b.toLowerCase();
		
		int[][]num =new int[str1.length()][str2.length()];
		int maxLen=0;
		int lastSubBegin =0;
		for(int i=0; i<str1.length();i++){
			for(int j=0;j<str2.length();j++){
				if(str1.charAt(i)==str2.charAt(j)){
					if(i==0 || j==0){
						num[i][j]=1;
					}
					else{
						num[i][j]=1+num[i-1][j-1];
					}
					if(num[i][j]>maxLen)
						maxLen=num[i][j];
					int thisSubBegin = i-num[i][j]+1;
					if(lastSubBegin == thisSubBegin)
						sb.append(str1.charAt(i));
					else{
						lastSubBegin=thisSubBegin;
						sb=new StringBuilder();
						sb.append(str1.substring(lastSubBegin, i+1));
					}
				}
			}
		}
		return sb.toString();
		
	}
	public static void main(String[] args){
		String a ="GeeksforGeeks";
		String b ="GeeksILove";
		String result = LCS(a,b);
		System.out.println(result);
		
	}
}
