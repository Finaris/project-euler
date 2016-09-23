import java.math.BigInteger;
import java.util.*;


public class Test 
{
	
	public static void main(String[] args)
	{
	
		BigInteger base, power;
		int sum = 0;
		
		base = new BigInteger("2");
		power = base.pow(1000);
		
		String n = power.toString();
		
		for (int i = 0; i < n.length(); i++) 
		{
			sum += Integer.parseInt(n.substring(i, i + 1));
		}
		System.out.println(sum);
		
	}
}