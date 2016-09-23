import java.util.*;
import java.math.*;

public class Test 
{	
	
	static ArrayList<ArrayList<Integer>> triples = new ArrayList<ArrayList<Integer>>();
	static int[] sums = new int[1010];
	static ArrayList<Integer> maxSums = new ArrayList<Integer>();
	
	public static void main(String[] args)
	{
	
		for(int i = 1; i <= 1000; i++)
		{
			for(int j = i; j <= 1000; j++)
			{
				double hyp = Math.pow(i, 2) + Math.pow(j, 2);
				if(Math.sqrt(hyp) == Math.round(Math.sqrt(hyp)))
				{
					if((i + j + (int)Math.sqrt(hyp)) <= 1000)
					{
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(i);
						temp.add(j);
						temp.add((int)Math.sqrt(hyp));
						triples.add(temp);
					}
				}
					
			}
		}
		
		for(ArrayList<Integer> temp: triples)
		{
			int sum = 0;
			for(int i: temp)
			{
				sum += i;
			}
			sums[sum] += 1;
		}
		
		for(int i = 0; i < sums.length; i++)
		{
			if(!(sums[i] == 0))
			{
				maxSums.add(sums[i]);
			}
		}
		
		Collections.sort(maxSums);
		for(int i = 0; i < sums.length; i++)
		{
			if(maxSums.get(maxSums.size() - 1) == sums[i])
				System.out.println(i);
		}
				
	}
}