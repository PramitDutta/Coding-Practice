
public class SumExceptSelf {
	public static int[] productExceptSelf(int[] nums){
		int n=nums.length;
		int[] res = new int[n];
		res[0]=0;
		for (int i = 1; i < n; i++) {
		   res[i] = res[i - 1] + nums[i - 1];
		}
		int right=0;
		for(int i=n-1;i>=0;i--){
			res[i]+=right;
			right+=nums[i];
		}
		return res;
	}
	public static void main(String[] args){
		int[] array = {1,2,3,4};
		int[] result = productExceptSelf(array);
		for(int num:result){
			System.out.print(num +" ");
		}
	}
}
