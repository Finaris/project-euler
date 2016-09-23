import java.util.*;
import java.math.*;

public class Test 
{
	public static void main(String[] args)
	{
		
		BigInteger base;
		BigInteger sum = new BigInteger("0");
		
		for(int i = 1; i <= 1000; i++)
		{
			base = new BigInteger(Integer.toString(i));
			BigInteger tempAns = base.pow(i);
			sum = sum.add(tempAns);
		}
		
		String n = sum.toString();
		System.out.println(n.substring(n.length()-10,n.length()));
		
	}
}