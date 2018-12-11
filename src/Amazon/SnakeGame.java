package Amazon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SnakeGame {
	// 2D position info is encoded to 1D and stored as two copies
	Set<Integer> set; // this is for fast loop up for body eating case
	Deque<Integer> body; // updating tail
	int[][] food;
	int i;
	int width;
	int height;
	int p = 23; // use a prime number to compute hashcode

	public SnakeGame(int width, int height, int[][] food) {
		this.width = width;
		this.height = height;
		this.food = food;
		i = 0;
		set = new HashSet<>();
		set.add(0); // initially at [0][0]
		body = new ArrayDeque<>();
		body.offerLast(0);
	}

	public int move(String direction) {
		int head = body.peekLast();
		int hr = head % p;
		int hc = head / p;
		switch (direction) {
		case "U":
			hr--;
			break;
		case "D":
			hr++;
			break;
		case "L":
			hc--;
			break;
		case "R":
			hc++;
			break;
		}

		if (i < food.length && hr == food[i][0] && hc == food[i][1]) {
			i++;
		} else {
			int first = body.pollFirst();
			set.remove(first);
		}

		int newHead = hc * p + hr;
		if (hr < 0 || hr >= height || hc < 0 || hc >= width || set.contains(newHead)) {
			return -1;
		}
		body.offerLast(newHead);
		set.add(newHead);
		return set.size() - 1;
	}
}
