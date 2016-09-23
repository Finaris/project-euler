import java.util.*;


public class Test 
{

	public static void main(String[] args)
	{

		boolean[] prime = new boolean[1000001];
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for(int i = 2; i < 1000000; i++)
		{
			prime[i] = true;
		}
		
		for(int i = 2; i*i <= 1000000; i++)
		{
			if(prime[i])
			{
				for(int j = i; i*j <= 1000000; j++)
				{
					prime[i*j] = false;
				}
			}
		}
		
		for(int i = 0; i < 1000000; i++)
		{
			if (prime[i])
			{
				primes.add(i);
			}
		}
		
		System.out.println(primes.get(10000));
		
	}
}
