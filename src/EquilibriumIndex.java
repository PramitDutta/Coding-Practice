
public class EquilibriumIndex {
	public static int equiIndex(int[] array){
		int sum=0;
		int leftSum=0;
		for(int i=0;i<array.length;i++){
			sum+=array[i];
		}
		for(int j=0;j<array.length;j++){
			sum-=array[j];
			if(leftSum==sum)
				return j;
			leftSum+=array[j];
		}
		return -1;
	}
	public static void main(String[] args){
		int[] arr={-7, 1, 5, 2, -4, 3, 0};
		System.out.println(equiIndex(arr));
	}
}
