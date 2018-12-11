package DynamicProgramming;

public class RangeSumQuery_Immutable {
	int[] nums;
	public RangeSumQuery_Immutable(int[] nums){
		for(int i=1;i<nums.length;i++){
			nums[i]=nums[i]+nums[i-1];
		}
		this.nums=nums;
	}
	public int sumRange(int i, int j){
		if(i==0) return nums[j];
		return nums[j]-nums[i-1];
		
	}
	public static void main(String[] args){
		int[] nums = {-2, 0, 3, -5, 2, -1};
		RangeSumQuery_Immutable a = new RangeSumQuery_Immutable(nums);
		int result = a.sumRange(1, 4);
		System.out.println(result);
	}
}
