package LeetCode_hard;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsInALine {
	static class Point {
		 int x;
		 int y;
		 Point() { x = 0; y = 0; }
		 Point(int a, int b) { x = a; y = b; }
	}
	public static int maxPoints(Point[] points) {
		int max = 0;
		if (points == null || points.length == 0) return 0;
		int n = points.length;
		if (n == 1) return 1;
		for (int i = 0; i < n - 1; ++i) {
			Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
			int dup = 0, lclmax = 0;
			for (int j = i + 1; j < n; ++j) {
				int x = points[j].x - points[i].x;
				int y = points[j].y - points[i].y;
				if (x == 0 && y == 0) {
					++dup;
					continue;
				}
				int gcd = gcd(x, y);
				x /= gcd;
				y /= gcd;
				if (!map.containsKey(x)) map.put(x, new HashMap<Integer, Integer>());
				if (!map.get(x).containsKey(y)) map.get(x).put(y, 0);
				map.get(x).put(y, map.get(x).get(y) + 1);
				lclmax = Math.max(lclmax, map.get(x).get(y));
			}
			max = Math.max(max, dup + lclmax + 1);
		}
		return max; 
    }
	public static int gcd(int a, int b){
		if(b==0) return a;
		return gcd(b, a%b);
	}
	public static void main(String args[]){
		Point p1=new Point(0,0);
		Point p2=new Point(0,0);
		//Point p3=new Point(12,11);
		Point[] points = {p1,p2};
		int result = maxPoints(points);
		System.out.println(result);
	}
}
