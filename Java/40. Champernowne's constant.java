import java.util.*;
import java.math.*;

public class Test 
{	
	public static void main(String[] args)
	{
	
		String n = "";
		long ans = 1;
		long storage = 0;
		for(long i = 1; n.length() < 100000; i++)
		{
			n = n + Long.toString(i);
			storage = i;
		}
		long d1 = Long.parseLong(n.substring(0, 1));
		long d10 = Long.parseLong(n.substring(9, 10));
		long d100 = Long.parseLong(n.substring(99, 100));
		long d1000 = Long.parseLong(n.substring(999, 1000));
		long d10000 = Long.parseLong(n.substring(9999, 10000));
		long d100000 = Long.parseLong(n.substring(99999, 100000));
		
		long store = 1000000 - n.length();
		long baba = 99999 - storage;
		store -= (5 * baba);
		store -= (6 * 85185);
		System.out.println(99999+85185);
		System.out.println(store);
		
		long d1000000 = 1;
		
		ans = d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000;
		System.out.println(ans);
	}
}