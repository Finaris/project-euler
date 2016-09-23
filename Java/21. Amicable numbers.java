import java.util.*;
import java.math.*;

public class Test 
{
	public static void main(String[] args)
	{
		
		int[] factorSums = new int[10000];
		ArrayList<Integer> amicable = new ArrayList<Integer>();
		int sum = 0;
		factorSums[0] = 0;
	
		for(int i = 1; i < factorSums.length; i++)
		{
			factorSums[i] = sum(i);
		}

		for(int i = 0; i < factorSums.length; i++)
		{
			for(int j = 0; j < factorSums.length; j++)
			{
				if (factorSums[i] == j)
				{
					if(factorSums[j] == i)
					{
						if(i != j)
						{
							amicable.add(i);
						}
					}
				}
					
			}
		}
		
		for(int i: amicable)
			sum += i;
		
		System.out.println(sum);
		
	}
	
	public static int sum(int n)
	{
		
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int total = 0;
		
		for(int i = 1; i < n; i++)
		{
			if(n % i == 0)
				factors.add(i);
		}
		
		for(int i: factors)
			total += i;
		
		return total;
	}
}