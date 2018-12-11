package Amazon;

/*
 * The least steps we need to eventually finish this process is determined by the peak of abs(cnt) and the max of "gain/lose" array. 
 *  Some other example:
machines: [0,3,0]; gain/lose array: [-1,2,-1]; max = 2, cnt = 0, -1, 1, 0, its abs peak is 1. So result is 2.
machines: [1,0,5]; gain/lose array: [-1,-2,3]; max = 3, cnt = 0, -1, -3, 0, its abs peak is 3. So result is 3.*/
public class SuperWashingMachines {
	public int findMinMoves(int[] machines) {
		int total = 0;
		for (int i : machines)
			total += i;
		if (total % machines.length != 0)
			return -1;
		int avg = total / machines.length;
		int cnt = 0, max = 0;
		for (int load : machines) {
			cnt += load - avg;
			max = Math.max(Math.max(max, Math.abs(cnt)), load - avg);
		}
		return max;
	}
}
