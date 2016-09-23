import java.util.*;
import java.math.*;

public class Test 
{
	static BigInteger one = new BigInteger("1");
	
	public static void main(String[] args)
	{
		
		long sum = 0;
		BigInteger test = new BigInteger("100");
		String ans = fact(test).toString();
		
		for (int i = 0; i < ans.length(); i++) 
		{
			sum += Long.parseLong(ans.substring(i, i+1));
		}
		
		System.out.println(sum);
		
	}
	
	public static BigInteger fact(BigInteger x)
	{
		if(x.intValue() == 1)
			return one;
		else;
			return x.multiply(fact(x.subtract(one)));
	}
	
}