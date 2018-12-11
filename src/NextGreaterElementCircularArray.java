
public class NextGreaterElementCircularArray {
	public static int[] nextGreater(int[] nums){
		int max=Integer.MIN_VALUE;
		for(int num:nums){
			max=Math.max(max, num);
		}
		int n=nums.length;
		int[] result = new int[n];
		int[] temp = new int[n*2];
		for(int i=0;i<n*2;i++){
			temp[i]=nums[i%n];
		}
		for(int i=0;i<n;i++){
			result[i]=-1;
			if(nums[i]==max) continue;
			for(int j=i+1;j<n*2;j++){
				if(temp[j]>nums[i]){
					result[i]=temp[j];
					break;
				}
			}
		}
		return result;
		
	}
	public static void main(String[] args){
		int[] array={1,2,1};
		int[] result = nextGreater(array);
		for(int i:result){
			System.out.print(i+" ");
		}
	}
}
