import java.util.*;
import java.math.*;

public class Test 
{	
	public static void main(String[] args)
	{
	
		long counter = 8;
		long breaker = 0;
		ArrayList<Long> trunc = new ArrayList<Long>();
		
		while(true)
		{
			String check = String.valueOf(counter);
			boolean left = true, right = true;
			if(isPrime(counter))
			{
				for(int i = 1; i < check.length(); i++)									//Right
				{
					String temp = check.substring(0, check.length() - i);
					if(!isPrime(Long.parseLong(temp)))
						right = false;
				}
				if(right)
				{
					for(int i = 0; i < check.length(); i++)								//Left
					{
						String temp = check.substring(i, check.length());
						if(!isPrime(Long.parseLong(temp)))
							left = false;
					}
					if(left)
					{
						trunc.add(counter);
						breaker++;
					}
				}
			}
			if(breaker == 11)
				break;
			counter++;
		}
		
		long sum = 0;
		for(long i: trunc)
		{
			System.out.println(i);
			sum += i;
		}
		System.out.println("Sum: " + sum);
				
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