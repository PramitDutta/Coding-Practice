import java.util.*;
public class SlidingWindowMax {
	public static int[] slidingMax(int[] nums, int k){
		if(nums==null || nums.length==0)
			return new int[0];
		int[] result = new int[nums.length-k+1];
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for(int i=0;i<nums.length;i++){
			if(!deque.isEmpty() && deque.peekFirst()==i-k)
				deque.poll();
			while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
				deque.removeLast();
			}
			deque.offer(i);
			if(i+1>=k)
				result[i+1-k]=nums[deque.peek()];
		}
		return result;
	}
	public static int[] slidingWindowMin(int[] nums, int w){
		int[] min_left=new int[nums.length];
		int[] min_right= new int[nums.length];
		min_left[0]=nums[0];
		min_right[nums.length-1]= nums[nums.length-1];
		for(int i=1;i<nums.length;i++){
			min_left[i]=(i%w==0)?nums[i]:Math.min(min_left[i-1],nums[i]);
			int j=nums.length-i-1;
			min_right[j]=(j%w==0)?nums[j]:Math.min(min_right[j+1], nums[j]);
		}
		int[] slidingMin= new int[nums.length-w+1];
		for(int i=0,j=0;i+w<=nums.length;i++){
			slidingMin[j++]=Math.min(min_right[i], min_left[i+w-1]);
		}
		return slidingMin;
		
	}
	public static void main(String[] args){
		int[] nums ={4,2,5,3,7,9};
		int[] result = slidingMax(nums,3);
		int[] min=slidingWindowMin(nums,3);
		for(int n:result){
			System.out.print(n+" ");
		}
		System.out.println("");
		for(int m:min){
			System.out.print(m+" ");
		}
	}
}
