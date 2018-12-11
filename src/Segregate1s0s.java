
public class Segregate1s0s {
	public static void segregate(int[] nums){
		if(nums==null || nums.length==0) return;
		int index=0;
		for(int n:nums){
			if(n!=0)
				nums[index++]=n;
		}
		while(index<nums.length){
			nums[index++]=0;
		}
	}
	public static void segre(int[] nums){
		if(nums==null || nums.length==0) return;
		int index=0;
		for(int n:nums){
			if(n==0){
				nums[index++]=0;
			}
		}
			while(index<nums.length){
				nums[index++]=1;
			}
	}
	public static void main(String[] args){
		int[] arr={1,0,1,1,0,0,0,1,1,1,0};
		int[] arr2={1,0,1,1,0,0,0,1,1,1,0};
		segregate(arr);
		for(int n:arr){
			System.out.print(n+" ");
		}
		System.out.println(" ");
		segre(arr2);
		for(int m:arr2){
			System.out.print(m+" ");
		}
	}
}
