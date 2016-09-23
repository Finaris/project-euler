import java.util.*;
import java.math.*;

public class Test 
{	
	static long highest = 0;
	
	public static void main(String[] args)
	{
	
		long n = System.nanoTime();
		permute("1");
		permute("12");
		permute("123");
		permute("1234");
		permute("12345");
		permute("123456");
		permute("1234567");
		permute("12345678");
		permute("123456789");
		System.out.println("Highest: " + highest);
		System.out.println((System.nanoTime() - n) / (Math.pow(10, 9)) + "s");
				
	}
	
	public static void permute(String n)
	{
		int length = n.length();
		char[] characters = n.toCharArray();
		boolean[] used = new boolean[length];
		StringBuffer b = new StringBuffer();
		doPermute(length, characters, used, b, 0);
	}
	
	public static void doPermute(int length, char[] characters, boolean[] used, StringBuffer b, int level)
	{
		if(level == length)
		{
			if(isPrime(Long.parseLong(b.toString())))
				if(Long.parseLong(b.toString()) > highest)
					highest = Long.parseLong(b.toString());
			return;
		}
		for(int i = 0; i < length; i++)
		{
			if(used[i])
				continue;
			
			b.append(characters[i]);
			used[i] = true;
			doPermute(length, characters, used, b, level + 1);
			used[i] = false;
			b.setLength(b.length() - 1);
		}
	}
	
	public static boolean isPrime(long x)
	{
		if(x == 1)
			return false;
		
		else if(x == 2)
			return true;
		
		else if(x % 2 == 0)
			return false;
		
		else
		{
			for(long i = 3; i*i <= x; i+=2)
			{
				if (x % i == 0)
					return false;
			}
		}
		return true;
	}
	
}