import java.util.*;
import java.math.*;

public class Test 
{
	public static void main(String[] args)
	{
	
		ArrayList<Integer> palindromes = new ArrayList<Integer>();
		long sum = 0;
		
		for(int i = 0; i < 1000000; i++)
		{
			if(isPalindrome(Integer.toString(i)))
				if(isPalindrome(Integer.toBinaryString(i)))
					palindromes.add(i);
					
		}
		
		for(int i: palindromes)
		{
			System.out.println(i);
			sum += i;
		}
		
		System.out.println("\n" + sum);
		
	}
	
	public static boolean isPalindrome(String n)
	{
		String part1, part2;
		boolean test = true;
		part1 = n.substring(0, n.length()/2);
		if(n.length() % 2 == 0)
		{
			part2 = n.substring(n.length()/2, n.length());
		}
		else
		{
			part2 = n.substring(n.length()/2 + 1, n.length());
		}
		for(int i = 0; i < part1.length(); i++)
		{
			if(part1.charAt(i) != part2.charAt(part2.length() - i - 1))
			{
				test = false;
				break;
			}
		}
			
		return test;
		
	}
}