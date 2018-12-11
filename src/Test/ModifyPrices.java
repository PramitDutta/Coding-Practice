package Test;


public class ModifyPrices {
	static int verifyItems(String[] origItems, float[] origPrices, String[] items, float[] prices){
		 int changeCount=0;
		 
		    for(int i = 0; i<items.length;i++){
		        if(prices[i] != origPrices[findIndex(origItems,items[i])]){
			            changeCount+=1;
		        }
		    }
		    return changeCount;
	}
	public static int findIndex(String[] str, String key){
		for(int i=0;i<str.length;i++){
			if(str[i].equals(key))
				return i;
		}
		return -1;
	}
	public static void main(String[] args){
		String origItems[]={"chocolate","cheese","tomato"};
		String items[]={"cheese","tomato","chocolate"};
		float origPrices[]={15.00f,300.90f,23.44f};
		float prices[]={300.90f,23.44f,10.00f};
		int result = verifyItems(origItems,origPrices,items,prices);
		System.out.println(result);
	}
	
}
