
public class RotateArray {
	public static void rotate(int[] nums, int k){
		if(nums==null||nums.length<2) return;
		k=k%nums.length;
		reverse(nums,0,nums.length-k-1);
		reverse(nums,nums.length-k,nums.length-1);
		reverse(nums,0,nums.length-1);
	}
	public static void reverse(int[] nums, int start, int end){
		int temp=0;
		while(start<end){
			temp=nums[start];
			nums[start]=nums[end];
			nums[end]=temp;
			start++;
			end--;
		}
	}
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6,7};
		rotate(nums,3);
		for(int n:nums){
			System.out.print(n+ " ");
		}
	}
}
