import java.util.*;
public class TwoSum {
	public static int[] twoSum(int[] nums, int target){
		int[] result= new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(target-nums[i])){
				result[0]=i;
				result[1]=map.get(target-nums[i]);
				return result;
			}
			map.put(nums[i], i);
		}
		return result;
	}
	public static void twoSumVal(int[] nums, int target){
		int MAX=100000;
		boolean[] binmap=new boolean[MAX];
		for(int i=0;i<nums.length;++i){
			int temp=target-nums[i];
			if(temp>=0 && binmap[temp]){
				System.out.println("sol3 Pair with given sum " +
                		target + " is (" + nums[i] +
                                    ", "+temp+")");
			}
			binmap[nums[i]]=true;
		}
	}
	public static void main(String[] args){
		int[] nums = {2,7,11,3};
		int[] result=twoSum(nums,9);
		for(int n:result){
			System.out.print(n+" ");
		}
		twoSumVal(nums,18);
	}
}
