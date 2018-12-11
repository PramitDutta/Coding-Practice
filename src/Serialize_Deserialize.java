import java.util.*;
public class Serialize_Deserialize {
	public static String serialize(TreeNode root){
		StringBuilder sb = new StringBuilder();
		if(root==null) return null;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode temp=stack.pop();
			sb.append(temp.val).append(",");
			if(temp.right!=null) stack.push(temp.right);
			if(temp.left!=null)stack.push(temp.left);
		}
		return sb.toString();
	}
	public static TreeNode deserialize(String s){
		if(s.equals("null")) return null;
		String[] nodes = s.split(",");
		Queue<Integer> queue = new LinkedList<Integer>();
		for(String n:nodes){
			queue.offer(Integer.parseInt(n));
		}
		return getNode(queue);
	}
	private static TreeNode getNode(Queue<Integer> queue){
		if(queue.isEmpty()) return null;
		TreeNode root = new TreeNode(queue.poll());
		Queue<Integer> smallerQueue = new LinkedList<>();
		while(!queue.isEmpty() && queue.peek()<root.val){
			smallerQueue.offer(queue.poll());
		}
		root.left=getNode(smallerQueue);
		root.right=getNode(queue);
		return root;
	}
	public static void main(String[] args){
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		d.left=b;
		d.right=f;
		b.left=a;
		b.right=c;
		f.left=e;
		f.right=g;
		String out = serialize(d);
		System.out.println(out);
		deserialize(out);
 	
	}
}
