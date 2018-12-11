import java.util.*;

public class Leetcode_Test {
	public static String[] relativeRanks(int[] nums){
		int[][] pair =new int[nums.length][2];
		for(int i=0;i<nums.length;i++){
			pair[i][0]=nums[i];
			pair[i][1]=i;
		}
		Arrays.sort(pair,(a,b)->(b[0]-a[0])); // What does this do..
		String[] result = new String[nums.length];
		for(int i=0;i<nums.length;i++){
			if(i==0){
				result[pair[i][1]]="Gold Medal";
			}
			else if(i==1){
				result[pair[i][1]]="Silver Medal";
			}
			else if(i==2){
				result[pair[i][1]]="Bronze Medal";
			}
			else{
				result[pair[i][1]]=(i+1)+"";
			}
		}
		return result;
	}
	public static void main(String[] args){
		int[] nums = {10,3,8,9,4};
		String[] result = relativeRanks(nums);
		for(String s: result){
			System.out.print(s+ " ");
		}
	}
}
