package Amazon;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathMaze {
	  public static final int ROW = 9;
	  public static final int COL = 10;
	  static int[] rowNum = new int[] { -1, 0, 0, 1 };
	  static int[] colNum = new int[] { 0, -1, 1, 0 };
	  
	  static class Point {
			public Point(int row, int col) {
			    this.x = row;
			    this.y = col;
			}

			int x;
			int y;
		    }
	  static class QueueNode {
			public QueueNode(Point src, int d) {
			    this.pt = src;
			    this.dist = d;
			}

			Point pt; // The coordinates of a cell
			int dist; // cell's distance of from the source
		    }
	  public static boolean isValid(int row, int col){
		  return (((row >= 0) && (row < ROW)) && ((col >= 0) && (col < COL)));
	  }
	  public static int BFSMax(int[][] mat, Point src, Point dest){
		  if((mat[src.x][src.y]==0)||(mat[dest.x][dest.y]==0))
			  return Integer.MAX_VALUE;
		  boolean[][] visited = new boolean[ROW][COL];
		  visited[src.x][src.y]=true;
		  
		  Queue<QueueNode>q = new ArrayDeque<QueueNode>();
		  QueueNode s=new QueueNode(src,0);
		  q.add(s);
		  
		  while(!q.isEmpty()){
			  QueueNode curr=q.peek();
			  Point pt=curr.pt;
			  
			  if(pt.x==dest.x && pt.y==dest.y)
				  return curr.dist;
			  
			  q.poll();
			  for(int i=0;i<4;i++){
				  int row = pt.x+rowNum[i];
				  int col = pt.y+colNum[i];
				  if(isValid(row,col) && mat[row][col]==1 && !visited[row][col]){
					  visited[row][col]=true;
					  QueueNode adjCell =new QueueNode(new Point(row,col),curr.dist+1);
					  q.add(adjCell);
				  }
			  }
		  }
		  return Integer.MAX_VALUE;
	  }
	  public static void main(String[] args){
		  int[][] mat = new int[][] { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };
		Point src = new Point(0,0);
		Point dest = new Point(3,4);
		int distance = BFSMax(mat, src, dest);
		System.out.println(distance);
	  }
}
