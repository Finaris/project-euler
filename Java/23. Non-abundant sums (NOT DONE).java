import java.util.*;
import java.math.*;

public class Test 
{
	public static void main(String[] args)
	{
		
		boolean[] test = new boolean[28123];
		long sum = 0;
		
		for(int i = 0; i <= 28123; i++)
		{
			for(int j = 0; j <= 28123; j++)
			{
				if(getState(i).equals("ABUNDANT") && getState(j).equals("ABUNDANT"))
				{
					if((i + j) <= 28122)
					{
						test[i+j] = true;
					}
				}
			}
		}
		
		for(int i = 0; i <= 28123; i++)
		{
			if(!test[i])
				sum += i;
		}
		
	}
	
	public static String getState(int n)
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
		
		if(total == n)
			return "PERFECT";
		else if(total > n)
			return "ABUNDANT";
		else
			return "DEFICIENT";
	}
	
}