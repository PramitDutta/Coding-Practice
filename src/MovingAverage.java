import java.util.*;

public class MovingAverage {
	LinkedList<Integer> queue;
	int size;
	int sum;
	
	public MovingAverage(int size){
		this.size=size;
		this.queue=new LinkedList<Integer>();
		this.sum=0;
	}
	
	public double next(int val){
		if(queue.size()>this.size){
			sum=sum-queue.poll();
		}
		queue.offer(val);
		sum=sum+val;
		return (double) sum/queue.size();
	}
	public static void main(String[] args) {

		int windowsize = 3;
		MovingAverage m = new MovingAverage(windowsize);

		for (int i = 1; i < 20; i++) {
			System.out.println("After Adding " + i + " to the queue: {" + m.queue.toString() + "}; Average is:  " + m.next(i));

		}
	}
}
