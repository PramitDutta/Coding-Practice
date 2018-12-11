
public class SuperUglyNumber {

	public static int[] superUgly(int n, int primes[]){
		int[] times = new int[primes.length];
		int[] result = new int[n];
		result[0]=1;
		
		for(int i=1;i<n;i++){
			int min = Integer.MAX_VALUE;
			for(int j=0;j<primes.length;j++){
				min= Math.min(min, primes[j]*result[times[j]]);
			}
			result[i]=min;
			
			for(int j=0;j<times.length;j++){
				if(result[times[j]]*primes[j]==min){
					times[j]++;
				}
			}
		}
		return result;
		
	}
	public static void main(String[] args){
		int n=6;
		int[] primes = {2,5};
		int[] result = superUgly(n, primes);
		for(int num:result){System.out.println(num);}
		
	}
}
