import java.util.;


public class Test 
{

	public static void main(String[] args)
	{
		
		ArrayListInteger palindromes = new ArrayListInteger();
		
		for(int i = 100; i  1000; i++)
		{
			for(int j = 100; j  1000; j++)
			{
				if(isPalindrome(Integer.toString(ij)))
				{
					palindromes.add(ij);
				}
			}
		}
		
		System.out.println(Collections.max(palindromes));
		
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