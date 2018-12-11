package Amazon;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobScheduling {
	public static class Job {
		int start, finish, profit;

		Job(int start, int finish, int profit) {
			this.start = start;
			this.finish = finish;
			this.profit = profit;
		}
	}

	public static class JobComparator implements Comparator<Job> {
		@Override
		public int compare(Job a, Job b) {
			return a.finish < b.finish ? -1 : a.finish == b.finish ? 0 : 1;
		}
	}

	static public int binarySearch(Job jobs[], int index) {
		// index is the index of the current job
		int low = 0, high = index - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (jobs[mid].finish <= jobs[index].start) {
				if (jobs[mid + 1].finish <= jobs[index].start)
					low = mid + 1;
				else
					return mid;
			} else
				high = mid - 1;
		}
		return -1;
	}

	public static int schedule(Job jobs[]) {
		Arrays.sort(jobs, new JobComparator());

		int n = jobs.length;
		int[] table = new int[n];
		table[0] = jobs[0].profit;

		for (int i = 1; i < n; i++) {
			int inclProf = jobs[i].profit;
			int latest = binarySearch(jobs, i);
			if (latest != -1)
				inclProf += table[latest];

			table[i] = Math.max(inclProf, table[i - 1]);
		}
		return table[n - 1];
	}

	public static void main(String[] args) {
		Job jobs[] = { new Job(1, 2, 50), new Job(3, 5, 20), new Job(6, 19, 100), new Job(2, 100, 200) };

		System.out.println("Optimal profit is " + schedule(jobs));
	}
}
