import java.util.*;
import java.math.*;

public class Test 
{
	public static void main(String[] args)
	{
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		ArrayList<Integer> newPrimes = new ArrayList<Integer>();
		String concat = "";
		
		for(int i = 0; i < 10000; i++)
		{
			if(isPrime(i))
				primes.add(i);
		}
		
		for(int i: primes)
		{
			String n = Integer.toString(i);
			if(n.length() == 4)
			{
				newPrimes.add(i);
			}
		}
		
		for(int i: newPrimes)
		{
			int a = i;
			int b = a + 3330;
			int c = b + 3330;
			
			if(isPermutation(Integer.toString(a), Integer.toString(b), Integer.toString(c)))
			{
				if(isPrime(a) && isPrime(b) && isPrime(c))
				{
					if(!(a == 1487 || b == 1487 || c == 1487))
					{
						concat = Integer.toString(a) + Integer.toString(b) + Integer.toString(c);
					}
				}
			}
		}
		
		System.out.println(concat);
		
	}	
	
	public static boolean isPermutation(String a, String b, String c)
	{
		if(a.length() != b.length() || a.length() != c.length() || b.length() != c.length())
			return false;
		else
		{
			boolean valid = true;
			ArrayList<Integer> aArray = new ArrayList<Integer>();
			ArrayList<Integer> bArray = new ArrayList<Integer>();
			ArrayList<Integer> cArray = new ArrayList<Integer>();
			
			for(int i = 0; i < a.length(); i++)
			{
				aArray.add(Integer.parseInt(a.substring(i, i+1)));
				bArray.add(Integer.parseInt(b.substring(i, i+1)));
				cArray.add(Integer.parseInt(c.substring(i, i+1)));
			}
			
			Collections.sort(aArray);
			Collections.sort(bArray);
			Collections.sort(cArray);
			
			for(int i = 0; i < aArray.size(); i++)
			{
				if(aArray.get(i) == bArray.get(i) && aArray.get(i) == cArray.get(i) && cArray.get(i) == bArray.get(i))
					continue;
				else
					valid = false;
			}
			
			return valid;
			
		}
		
	}
	
	public static boolean isPrime(int x)
	{
		if(x == 1)
			return false;
		
		else if(x == 2)
			return true;
		
		else if(x % 2 == 0)
			return false;
		
		else
		{
			for(int i = 3; i*i <= x; i+=2)
			{
				if (x % i == 0)
					return false;
			}
		}
		return true;
	}
}