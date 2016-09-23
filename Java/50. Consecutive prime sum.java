import java.util.*;
import java.math.*;

public class Test 
{
	public static void main(String[] args)
	{
		long limit = 1000000;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		long tempSum = 0, highestPrime = 0, counter = 0;
		
		for(int i = 1; i < limit; i++)
		{
			if(isPrime(i))
				primes.add(i);
		}
		
		for (int i = 0; i < primes.size(); i++) 
		{
			tempSum = 0;
			long internalCounter = 0;
			for(int j = 0; i + j < primes.size(); j++)
			{
				tempSum += primes.get(i+j);
				internalCounter++;
				if(tempSum > limit)
					break;
				if(isPrime(tempSum) && internalCounter > counter)
				{
					
					highestPrime = tempSum;
					counter = internalCounter;
				}
			}
		}
		
		System.out.println(highestPrime + "\t" + counter);
		
	}	
	
	public static boolean isPrime(long x)
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