import java.util.*;
import java.math.*;

public class Test 
{
	public static void main(String[] args)
	{
	
		ArrayList<Long> digitFactorials = new ArrayList<Long>();
		long cap = factorial(9);
		long sum = 0;
		
		for(long i = 3; i <= cap; i++)
		{
			if(isDigitFactorial(i))
				digitFactorials.add(i);
		}
		
		for(long i: digitFactorials)
		{
			System.out.println(i);
			sum += i;
		}
		
		System.out.println("\n" + sum);
		
	}
	
	public static boolean isDigitFactorial(long x)
	{
		
		String n = Long.toString(x);
		int length = n.length();
		int sum = 0;
		
		for(int i = 0; i < length; i++)
		{
			sum += factorial(Long.parseLong(n.substring(i, i+1)));
		}
		
		if(sum == x)
			return true;
		else
			return false;

	}
	
	public static long factorial(long x)
	{
		if(x == 1 || x == 0)
			return 1;
		else
			return x * factorial(x-1);
	}
}