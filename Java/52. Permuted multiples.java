import java.util.*;
import java.math.*;

public class Test 
{	
	public static void main(String[] args)
	{
		
		for(long i = 1; i < 1000000; i++)
		{
			if(isPermutation(Long.toString(i), Long.toString(6 * i)))
				if(isPermutation(Long.toString(i), Long.toString(5 * i)))
					if(isPermutation(Long.toString(i), Long.toString(4 * i)))
						if(isPermutation(Long.toString(i), Long.toString(3 * i)))
							if(isPermutation(Long.toString(i), Long.toString(2 * i)))
								System.out.println(i);
				
		}
		
	}
	
	public static boolean isPermutation(String a, String b)
	{
		if(a.length() != b.length())
			return false;
		else
		{
			boolean valid = true;
			ArrayList<Integer> aArray = new ArrayList<Integer>();
			ArrayList<Integer> bArray = new ArrayList<Integer>();
			
			for(int i = 0; i < a.length(); i++)
			{
				aArray.add(Integer.parseInt(a.substring(i, i+1)));
				bArray.add(Integer.parseInt(b.substring(i, i+1)));
			}
			
			Collections.sort(aArray);
			Collections.sort(bArray);
			
			for(int i = 0; i < aArray.size(); i++)
			{
				if(aArray.get(i) == bArray.get(i))
					continue;
				else
					valid = false;
			}
			
			return valid;
			
		}
		
	}
}