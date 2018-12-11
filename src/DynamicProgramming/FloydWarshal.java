package DynamicProgramming;

public class FloydWarshal {
	final static int V=4;
	static void floydWarshal(int[][] graph){
		int dist[][] = new int[V][V];
		int i,j,k;
		
		for(i=0;i<V;i++){
			for(j=0;j<V;j++){
				dist[i][j]=graph[i][j];
			}
		}
		
		for(k=0;k<V;k++)
			for(i=0;i<V;i++)
				for(j=0;j<V;j++){
					if(dist[i][j]>dist[i][k]+dist[k][j]){
						dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
		
		for(i=0;i<V;i++){
			for(j=0;j<V;j++){
				if(dist[i][j]==-1){
					System.out.print("INF");
				}
				else{
					System.out.print(dist[i][j]+ " ");
				}
			}
			System.out.println();
		}
		
				
	}
	
	public static void main(String args[]){
		int graph[][] = { {0,   5,  -1, 10},
                {-1, 0,   3, -1},
                {-1, -1, 0,   1},
                {-1, -1, -1, 0}
              };
		floydWarshal(graph);
	}
}
