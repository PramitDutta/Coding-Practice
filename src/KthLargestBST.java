import java.util.*;
public class KthLargestBST {
	
	public static int kthLargest(TreeNode root, int k) {
	     Stack<TreeNode> stack = new Stack<>();
	     while(root != null || !stack.isEmpty()) {
	         while(root != null) {
	             stack.push(root);    
	             root = root.right;   
	         } 
	         root = stack.pop();
	         if(--k == 0) break;
	         root = root.left;
	     }
	     return root.val;
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
		 	
		int result = kthLargest(d,2);
		System.out.println(result);
	}
}
