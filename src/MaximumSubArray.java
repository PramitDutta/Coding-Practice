
public class MaximumSubArray {
	public static int maxSubArray(int[] nums) {
        int maxSumSoFar=Integer.MIN_VALUE;
        int tempStart=0;
        int tempSum=0;
        int start=0, end=0, sum=0;
        for(int i=0;i<nums.length;i++){
        	tempSum=tempSum+nums[i];
        	if(tempSum>maxSumSoFar){
        		maxSumSoFar=tempSum;
        		start=tempStart;
        		end=i;
        		sum=maxSumSoFar;
        	}
        	if(tempSum<0){
        		tempSum=0;
        		tempStart=i+1;
        	}
        }
        for(int i=start;i<=end;i++){
        	System.out.print(nums[i]+" ");
        }
        System.out.println("");
        return sum;
    }
	public static void main(String[] args){
		int[] array ={-2,1,-3,4,-1,2,1,-5,4};
		int result=maxSubArray(array);
		System.out.println(result);
	}
}
