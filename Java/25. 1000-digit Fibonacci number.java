import java.util.*;
import java.math.*;

public class Test 
{
	public static void main(String[] args)
	{
		BigInteger fib1 = new BigInteger("0");
		BigInteger fib2 = new BigInteger("1");
		BigInteger fib3 = new BigInteger("0");
		int term = 1;
		
		while(isThousand(fib3) == false)
		{
			fib3 = fib2.add(fib1);
			fib1 = fib2;
			fib2 = fib3;
			term++;
		}
		
		System.out.println(term);
		
	}
	
	public static boolean isThousand(BigInteger x)
	{
		String n = x.toString();
		if(n.length() >= 1000)
			return true;
		else
			return false;
		
	}
	
}