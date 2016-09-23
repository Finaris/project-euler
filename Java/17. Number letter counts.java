import java.util.*;
import java.math.*;

public class Test 
{	
	public static void main(String[] args)
	{
		
		int[] ones = {0, 3, 3, 5, 4, 4, 3, 5, 5, 4};
		int[] tens = {0, 0, 6, 6, 5, 5, 5, 7, 6, 6};
		int[] hundreds = {0, 13, 13, 15, 14, 14, 13, 15, 15, 14};
		int[] ten = {3, 6, 6, 8, 8, 7, 7, 9, 8, 8};
		long sum = 0;
		
		for(int h = 0; h < 10; h++)
			for(int t = 0; t < 10; t++)
				for(int o = 0; o < 10; o++)
				{
					if(t == 1)
					{
						sum += hundreds[h];
						sum += ten[o];
					}
					else
					{
						if(t == 0 && o == 0 && h != 0)
							sum += hundreds[h] - 3;
						else
							sum += hundreds[h];
						sum += tens[t];
						sum += ones[o];
					}
				}
		
		System.out.println(sum + 11);
	}
}