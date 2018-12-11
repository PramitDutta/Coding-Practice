import java.util.Stack;

public class Prefix_To_PostFix {
	public static String preToPost(String pre){
		StringBuilder p = new StringBuilder();
		Stack<String> stack = new Stack<String>();
		for(int i=0;i<pre.length();i++){
			if(pre.charAt(i)=='+' || pre.charAt(i)=='*' || pre.charAt(i)=='-' ||pre.charAt(i)=='/')
				stack.push(pre.substring(i, i+1));
			else{
				p.append(pre.substring(i, i+1));
				while(!stack.isEmpty() && stack.peek().equals("P_R")){
					stack.pop();
					p.append(stack.peek());
					stack.pop();
					
				}
				stack.push("P_R");
			}
		}
		return p.toString();
	}
	public static void main(String[] args){
		String pre = "+*AB/CD";
		System.out.println(preToPost(pre));
	}
}
