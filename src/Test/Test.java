package Test;

import java.util.HashSet;
import java.util.Set;

public class Test {
	
	public static int arrayNesting(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int i=0;
        while(i<nums.length){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                i=nums[i];
            }
            else if(set.contains(nums[i]))
            	break;
        }
        return set.size();
    }
	public static void main(String[] args){
		int nums[] ={0,2,1};
		int res = arrayNesting(nums);
		System.out.println(res);
	}
	
}

