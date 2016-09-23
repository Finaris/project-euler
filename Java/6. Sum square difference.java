import java.util.*;


public class Test 
{

	public static void main(String[] args)
	{
		int sum1 = 0;
		int sum2 = 0;
		int difference = 0;
		
		for(int i = 1; i <= 100; i++)
		{
			sum1 += (i * i);
		}
		
		for(int i = 1; i <= 100; i++)
		{
			sum2 += i;
		}

		difference = (sum2 * sum2) - sum1;
		System.out.println(difference);
		
		
	}
}
