import java.util.*;

public class test1 {
	public static int count(int[] nums){
		int[] sum = new int[nums.length];
		sum[0]=nums[0];
		for(int i=1; i<nums.length;i++){
			if(nums[i]==1) sum[i]=sum[i-1]+nums[i];
			else sum[i]=0;
		}
		int max=0;
		for(int n:sum){
			if(max<n){
				max=n;
			}
		}
		return max;
	}
	public static void main(String[] args){
		int[] arr={0,1,0,1,1,1};
		int res= count(arr);
		System.out.print(res);
	}

}
