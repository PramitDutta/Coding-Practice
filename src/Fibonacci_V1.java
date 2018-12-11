
public class Fibonacci_V1 {
 
	public static void fib(int n, int x){
        int [] a= new int[x];
        for(int i=0;i<n;i++){
            a[i]=1;
        }
        for(int i=n;i<x; i++){
            a[i]=a[i-1] + a[i-2] + a[i-3];
        }

        for(int i=0;i<x;i++)
            System.out.print(a[i] + " ");
    }
	public static void main(String[] args){
		fib(5,8);
	}
}
