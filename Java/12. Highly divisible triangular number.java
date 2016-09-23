import java.util.*;
import java.math.*;

public class Test 
{	
	public static void main(String[] args)
	{
		
		long counter = 2, tempNum = 1;
		while(true)
		{
			if(numOfFactors(tempNum) >= 500)
				break;
			tempNum += counter;
			counter++;
		}
		
		System.out.println(tempNum);
		
	}
	
	public static int numOfFactors(long x)
	{
		int factors = 0;
		for(long i = 1; i <= Math.sqrt(x); i++)
		{
			if(x % i == 0)
				factors += 2;
		}
		if(x % Math.sqrt(x) == 0)
			factors--;
		return factors;
	}
}