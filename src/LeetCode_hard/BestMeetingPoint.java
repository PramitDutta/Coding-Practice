package LeetCode_hard;

import java.util.ArrayList;
import java.util.Collections;

//This problem is converted to find the median value on x-axis and y-axis.
//Manhattan Distance is to be calculated
public class BestMeetingPoint {
	public static int minTotalDistance(int[][] grid){
		int m=grid.length;
		int n=grid[0].length;
		
		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<Integer> cols = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]==1){
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		int sum=0;
		for(Integer i:rows){
			sum+=Math.abs(i-rows.get(rows.size()/2));
		}
		Collections.sort(cols);// 
		for(Integer i:cols){
			sum+=Math.abs(i-cols.get(cols.size()/2));
		}
		
		return sum;
	}
	
	public static void main(String[] args){
		int[][] grid = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		int minDistance = minTotalDistance(grid);
		System.out.println(minDistance);
	}
}
