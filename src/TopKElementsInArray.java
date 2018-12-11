import java.util.*;

public class TopKElementsInArray {
	
	public static int[] topK(int[] nums, int k){
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int i=0;i<k;i++){
			minHeap.offer(nums[i]);
		}
		for(int i=k;i<nums.length;i++){
			if(nums[i]>minHeap.peek()){
				minHeap.poll();
				minHeap.offer(nums[i]);
			}
		}
		
		Iterator<Integer> it = minHeap.iterator();
		List<Integer> result = new ArrayList<Integer>();
			while(it.hasNext()){
				result.add((Integer)it.next());
			}
	   
		Collections.sort(result, Collections.reverseOrder());
		
		int[] res = new int[result.size()];
		Iterator<Integer> iter = result.iterator();
		for(int i=0;i<res.length;i++){
			res[i]=iter.next().intValue();
		}
		return res;
	}
	public static void main(String[] args){
		int[] nums = {4,6,2,7,8,1,3};
		int k=2;
		int[] result = new int[k];
		result = topK(nums,k);
		for(int num: result){
			System.out.print(num+" ");
		}
	}
}
