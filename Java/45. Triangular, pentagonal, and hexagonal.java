import java.util.*;
import java.math.*;

public class Test 
{	
	
	static ArrayList<Long> triangle = new ArrayList<Long>();
	static ArrayList<Long> pentagon = new ArrayList<Long>();
	static ArrayList<Long> hexagon = new ArrayList<Long>();
	
	public static void main(String[] args)
	{
		int cap = 1000000;
		triangleFill(cap);
		pentagonFill(cap);
		hexagonFill(cap);
		
		for(long i = 0; i < cap; i++)
		{
			long test = hexagon.get((int) i);
			if(pentagon.contains(test))
				if(triangle.contains(test))
					System.out.println(test);
		}
		
	}
	
	public static void triangleFill(int x)
	{
		long counter = 2, limit = x, tempSum = 1;
		triangle.add((long) 1);
		while(limit - 1 > 0)
		{
			tempSum += counter;
			triangle.add(tempSum);
			limit--;
			counter++;
		}
	}
	
	public static void pentagonFill(int x)
	{
		long counter = 4, limit = x, tempSum = 1;
		pentagon.add((long) 1);
		while(limit - 1 > 0)
		{
			tempSum += counter;
			pentagon.add(tempSum);
			limit--;
			counter+=3;
		}
	}
	
	public static void hexagonFill(int x)
	{
		long counter = 5, limit = x, tempSum = 1;
		hexagon.add((long) 1);
		while(limit - 1 > 0)
		{
			tempSum += counter;
			hexagon.add(tempSum);
			limit--;
			counter+=4;
		}
	}
}