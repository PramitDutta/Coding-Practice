package LeetCode_hard;

public class SmallestRectangleEnclosingBlackPixels {
	public static int minArea(char[][] image, int x, int y){
		if(image==null || image.length==0 || image[0].length==0) return 0;
		int m=image.length;
		int n=image[0].length;
		int left = searchColumns(image,0,y,0,m,"min");
		int right = searchColumns(image,y+1,n,0,m,"max");
		int top = searchRows(image,0,x,left,right,"min");
		int bottom = searchRows(image,x+1,m,left,right,"max");
		
		return (right-left)*(bottom-top);
	}
	public static int searchRows(char[][] image,int i, int j, int left, int right, String def){
		while(i!=j){
			int k=left,mid=(i+j)/2;
			while(k<right && image[mid][k]=='0')k++;
			if(k<right && def.equals("min") || k>=right && def.equals("max")){
				j=mid;
			}
			else{
				i=mid+1;
			}
		}
		return i;
	}
	public static int searchColumns(char[][] image,int i, int j, int top, int bottom, String def){
		while(i!=j){
			int k=top,mid=(i+j)/2;
			while(k<bottom && image[k][mid]=='0')++k;
			if(k<bottom && def.equals("min") || k>=bottom && def.equals("max")){
				j=mid;
			}
			else{
				i=mid+1;
			}
		}
		return i;
	}
	public static void main(String[] args){
		char[][] image ={{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};
		System.out.println(minArea(image,0,2));
	}
}
