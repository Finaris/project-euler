import java.util.*;
import java.math.*;

public class Test 
{	
	public static void main(String[] args)
	{
	
		BigInteger baba = new BigInteger("40");
		BigInteger chacha = new BigInteger("20");
		System.out.println(combination(baba, chacha));
		
	}
	
	public static BigInteger combination(BigInteger x, BigInteger y)
	{
		return fact(x).divide(fact(y).multiply(fact(x.subtract(y))));
	}
	
	public static BigInteger fact(BigInteger x)
	{
		BigInteger temp = new BigInteger("1");
		if(x.intValue() == 1 || x.intValue() == 0)
			return temp;
		else
			return x.multiply(fact(x.subtract(temp)));
	}
	
}