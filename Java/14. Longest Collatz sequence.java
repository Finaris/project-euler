import java.util.*;
import java.math.*;

public class Test 
{
	
	public static void main(String[] args)
	{
	
		long longestChain = 1, longestNumber = 1, MAX = 1000000;
		
		for(int i = 1; i < MAX; i++)
		{
			long chain = 1, q = i;
			while(q != 1)
			{
				if(q % 2 == 0)
				{
					q /= 2;
					chain++;
				}
				else
				{
					q = (q*3) + 1;
					chain ++;
				}
			}
			if(chain > longestChain)
			{
				longestNumber = i;
				longestChain = chain;
			}
		}
		
		System.out.println(longestNumber + "   " + longestChain);
		
	}
}