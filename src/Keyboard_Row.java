import java.util.*;

public class Keyboard_Row {
	public static String[] findWords(String[] words){
		List<String> result = new LinkedList<>();
		String[] str = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<str.length;i++){
			for(char c:str[i].toCharArray()){
				map.put(c, i);
			}
		}
		for(String w:words){
			if(w.equals("")) continue;
			int index=map.get(w.toUpperCase().charAt(0));
			for(char c:w.toUpperCase().toCharArray()){
				if(map.get(c)!=index){
					index=-1;
					break;
				}
			}
			if(index!=-1) result.add(w);
		}
				
		return result.toArray(new String[0]);
	}
	public static void main(String[] args){
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		String[] result = findWords(words);
		for(String w:result){
			System.out.print(w+",");
		}
		
	}
}
