import java.util.*;

public class Median_DataStream {
	PriorityQueue<Integer> maxHeap; // lower half
	PriorityQueue<Integer> minHeap; // higher half
	
	public Median_DataStream(){
		maxHeap= new PriorityQueue<Integer>(Collections.reverseOrder());
		minHeap= new PriorityQueue<Integer>();
	}
	public void addNum(int num){
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		if(maxHeap.size() < minHeap.size()){
			maxHeap.offer(minHeap.poll());
		}
	}
	public double findMedian(){
		if(maxHeap.size()==minHeap.size()){
			return (double)(maxHeap.peek()+minHeap.peek())/2;
		}
		else{
			return maxHeap.peek();
		}
	}
	public static void main(String[] args){
		Median_DataStream a = new Median_DataStream();
		for(int i=1;i<=10;i++){
			a.addNum(i);
			System.out.println("After adding " +i+ " Median is " + a.findMedian());
		}
	}
}
