
public class KthSmallest {
	public static int findKthSmallest(int[] nums,int k){
		if(nums==null || nums.length==0) return Integer.MIN_VALUE;
		return findKthSmallest(nums,0,nums.length-1,k-1);
	}
	public static int findKthSmallest(int[] nums, int start, int end, int k){
		int left=start;
		int right=end;
		int pivot=start;
		while(left<=right){
			while(left<=right && nums[left]<=nums[pivot])
				left++;
			while(left<=right && nums[left]>=nums[pivot])
				right--;
			if(left<right){
				swap(nums,left,right);
				left++;
				right--;
			}
		}
		swap(nums,pivot,right);
		if(pivot==k) return nums[pivot];
		else if(pivot<k) return findKthSmallest(nums,pivot+1,end,k);
		else return findKthSmallest(nums,start, pivot-1,k);
	}
	static void swap(int[] nums, int i, int j){
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	public static void main(String args[]){
		int nums[] = {3,25,4,7,8,6,2,10,12,9,21};
		System.out.println(findKthSmallest(nums,3));
	}
}
