import java.util.*;

public class Test 
{
	public static void main(String[] args)
	{
		
		int eightNine = 0;
		
		for (long i = 10000000; i > 0; i--)
		{
			long check = i;
			int flag = 0;
			while(flag == 0)
			{
				check = calc(check);
				if((check == 89) || (check == 1))
					flag = 1;
			}
			if(check == 89)
				eightNine++;
		}
		System.out.println(eightNine);
	}
	
	public static long calc(long x)
	{
		long baba = 0;
		String n = Long.toString(x);
		for(int i = 0; i < n.length(); i++)
		{
			baba += Math.pow(Long.parseLong(n.substring(i, i+1)), 2);
		}
		return baba;
	}
}
