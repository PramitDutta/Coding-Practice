import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortbyFrequency {
	public static void sortByFreq(int a[]){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<a.length;i++){
			if(map.get(a[i])==null)
				map.put(a[i], 1);
			else
				map.put(a[i], map.get(a[i])+1);
		}
		
		List list = new LinkedList(map.entrySet());
		Collections.sort(list,new Comparator(){
			@Override
            public int compare(Object obj1, Object obj2) {
               return ((Comparable) ((Map.Entry) (obj1)).getValue())
                  .compareTo(((Map.Entry) (obj2)).getValue());
            }
		});
		 int count=0;
	       
	       /* Place the elements in to the array based on frequency */
	       for (Iterator it = list.iterator(); it.hasNext();) {
	            Map.Entry entry = (Map.Entry) it.next();
	            
	            int key = (int)entry.getKey();
	            int val = (int)entry.getValue();
	            
	            for(int i=0; i < val; i++){
	                a[count] = key;
	                count++;
	            }            
	       } 
	}
	public static void main(String args[]){
        int a[] = {5,4,3,2,1,0,5,3,2,4,1,2,3,5};
        
        System.out.println("Before Sorting");
        for(int i=0; i<a.length; i++){
            System.out.print(a[i] +" ");
        }
        
        sortByFreq(a);
        
        System.out.println("\nAfter Sorting");
        for(int i=0; i<a.length; i++){
            System.out.print(a[i] +" ");
        }
    }
}
