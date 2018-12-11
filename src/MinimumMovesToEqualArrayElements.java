
public class MinimumMovesToEqualArrayElements {
	public static int minMoves2(int[] nums){
		int sum=0;
		int median = findMedian(nums);
		for(int i=0;i<nums.length;i++){
			sum+=Math.abs(nums[i]-median);
		}
		return sum;
	}
	public static int findMedian(int[] nums){
		return getKth(nums.length/2+1,nums,0,nums.length-1);
	}
	public static int getKth(int k, int[] nums, int start, int end){
		int pivot = nums[end];
		int left=start;
		int right=end;
		while(true){
			while(nums[left]<pivot && left<right) left++;
			while(nums[right]>=pivot && right >left) right--;
			if(left==right) break;
			swap(nums, left, right);
		}
		swap(nums, left, end);
		if(k==left+1) return pivot;
		else if(k<left+1) return getKth(k,nums, start, left-1);
		else return getKth(k,nums,left+1, end);
	}
	public static void swap(int[] nums, int n1, int n2){
		int temp = nums[n1];
		nums[n1]=nums[n2];
		nums[n2]= temp;
	}
	public static void main(String[] args){
		int[] array = {1,3,4,6};
		int result = minMoves2(array);
		System.out.println(result);
	}
}
