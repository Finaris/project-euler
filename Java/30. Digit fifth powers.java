import java.util.*;
import java.math.*;

public class Test 
{
	public static void main(String[] args)
	{
		
		long cap = 236196;
		int power = 5;
		int sum = 0;
		ArrayList<Long> fifth = new ArrayList<Long>();
		
		for(int i = 2; i <= cap; i++)
		{
		
			String n = Integer.toString(i);
			long o = Long.parseLong(n.substring(0,1));
			if(n.length() == 1)											//One Digit Numbers
			{
				long tempAns = (long) Math.pow(o,power);
				if(tempAns == i)
					fifth.add((long) i);
			}
			else if(n.length() == 2)									//Two Digit Numbers
			{
				long tw = Long.parseLong(n.substring(1,2));
				long tempAns = (long) Math.pow(o,power) + (long) Math.pow(tw,power);
				if(tempAns == i)
					fifth.add((long) i);
			}
			else if(n.length() == 3)									//Three Digit Numbers
			{
				long tw = Long.parseLong(n.substring(1,2));
				long thr = Long.parseLong(n.substring(2,3));
				long tempAns = (long) Math.pow(o,power) + (long) Math.pow(tw,power) + (long) Math.pow(thr,power);
				if(tempAns == i)
					fifth.add((long) i);
			}
			else if(n.length() == 4)									//Four Digit Numbers
			{
				long t = Long.parseLong(n.substring(1,2));
				long thr = Long.parseLong(n.substring(2,3));
				long f = Long.parseLong(n.substring(3,4));
				long tempAns = (long) Math.pow(o,power) + (long) Math.pow(t,power) + (long) Math.pow(thr,power) + (long) Math.pow(f,power);
				if(tempAns == i)
					fifth.add((long) i);
			}
			else if(n.length() == 5)									//Five Digit Numbers
			{
				long t = Long.parseLong(n.substring(1,2));
				long thr = Long.parseLong(n.substring(2,3));
				long f = Long.parseLong(n.substring(3,4));
				long fi = Long.parseLong(n.substring(4,5));
				long tempAns = (long) Math.pow(o,power) + (long) Math.pow(t,power) + (long) Math.pow(thr,power) + (long) Math.pow(f,power) + (long) Math.pow(fi,power);
				if(tempAns == i)
					fifth.add((long) i);
			}
			else														//Six Digit Numbers
			{
				long t = Long.parseLong(n.substring(1,2));
				long thr = Long.parseLong(n.substring(2,3));
				long f = Long.parseLong(n.substring(3,4));
				long fi = Long.parseLong(n.substring(4,5));
				long s = Long.parseLong(n.substring(5,6));
				long tempAns = (long) Math.pow(o,power) + (long) Math.pow(t,power) + (long) Math.pow(thr,power) + (long) Math.pow(f,power) + (long) Math.pow(fi,power) + + (long) Math.pow(s,power);
				if(tempAns == i)
					fifth.add((long) i);
			}
			
		}
		
		for(long i: fifth)
			sum += i;
		
		System.out.println(sum);
	}	
}