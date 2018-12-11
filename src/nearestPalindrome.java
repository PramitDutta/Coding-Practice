
public class nearestPalindrome {
	static int nearestPalindromicNumber(int x)
    {

        String z = String.valueOf(x);
        int mid = z.length() % 2 == 0 ? z.length() / 2 : (z.length() + 1) / 2;
        String w = z.substring(0, mid);
        int mayBe = Integer.valueOf(w + new StringBuffer(w).reverse().toString());
        double s  = 0;
        int far = Math.abs(x - mayBe);
        for (double  i = x,loop = 0; loop <=far  ; i++,loop ++)
        {
            s = Math.ceil(i);
            if (new StringBuffer(Double.toString(s)).reverse().toString().equals(Double.toString(s)))
            {
                if (Math.abs(x-s) < Math.abs (mayBe-x))
                    return (int)s;
            }
        }
        return (int)mayBe;
    }
	public static void main(String[] args){
		int number = nearestPalindromicNumber(1334);
		System.out.println(number);
	}
}
