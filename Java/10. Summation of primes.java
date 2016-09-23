import java.util.*;


public class Test 
{

	public static void main(String[] args)
	{

		long sum = 0;
		
		for(int i = 1; i < 2000000; i++)
		{
			if(isPrime(i))
			{
				sum += i;
			}
		}
		
		System.out.println(sum);
		
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