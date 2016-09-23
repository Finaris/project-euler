import java.util.*;
import java.math.*;

public class Test 
{	
	public static void main(String[] args)
	{
		ArrayList<Integer> circular = new ArrayList<Integer>();
		int amount = 0;
		for(int i = 1; i < 1000000; i++)
		{
			if(isPrime(i))
			{
				ArrayList<Integer> tempArray = circularPrimes(i);
				boolean test = true;
				for(int j: tempArray)
					if(!isPrime(j))
						test = false;
				if(test)
				{
					circular.add(i);
					amount++;
				}
			}
		}
		
		for(int i: circular)
			System.out.println(i);
		System.out.println("Amount: " + amount);
				
	}
	
	public static ArrayList<Integer> circularPrimes(int x)
	{
		ArrayList<Integer> tempArray = new ArrayList<Integer>();
		tempArray.add(x);
		String n = String.valueOf(x);							//123, 231, 312
		
		for(int i = 1; i < n.length(); i++)
		{
			n = n.substring(1, n.length()) + n.charAt(0);
			tempArray.add(Integer.parseInt(n));
		}
		
		return tempArray;
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