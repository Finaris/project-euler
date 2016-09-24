import java.util.*;
import java.io.IOException;
import java.math.*;
import java.nio.charset.*;
import java.nio.file.*;

public class Test 
{	
	static ArrayList<Long> triangle = new ArrayList<Long>();
	static long counter = 0;
	
	public static void main(String[] args) throws IOException
	{
	
		Path path = Paths.get("words.txt");
		Charset cs= StandardCharsets.US_ASCII;
		List<String> fileArray = Files.readAllLines(path, cs);
		String words = fileArray.get(0);
		words = words.replace("\"", "");
		String[] collection = words.split(",");
		triangleFill(2500);
		
		for(String i: collection)
		{
			long tempScore = 0;
			for(int j = 0; j < i.length(); j++)
			{
				tempScore += score(i.charAt(j));				
			}
			if(triangle.contains(tempScore))
			{
				counter++;
			}
		}
		
		System.out.println(counter);
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
	
	public static int score(char a)
	{
		if(a == 'A')
			return 1;
		else if(a == 'B')
			return 2;
		else if(a == 'C')
			return 3;
		else if(a == 'D')
			return 4;
		else if(a == 'E')
			return 5;
		else if(a == 'F')
			return 6;
		else if(a == 'G')
			return 7;
		else if(a == 'H')
			return 8;
		else if(a == 'I')
			return 9;
		else if(a == 'J')
			return 10;
		else if(a == 'K')
			return 11;
		else if(a == 'L')
			return 12;
		else if(a == 'M')
			return 13;
		else if(a == 'N')
			return 14;
		else if(a == 'O')
			return 15;
		else if(a == 'P')
			return 16;
		else if(a == 'Q')
			return 17;
		else if(a == 'R')
			return 18;
		else if(a == 'S')
			return 19;
		else if(a == 'T')
			return 20;
		else if(a == 'U')
			return 21;
		else if(a == 'V')
			return 22;
		else if(a == 'W')
			return 23;
		else if(a == 'X')
			return 24;
		else if(a == 'Y')
			return 25;
		else if(a == 'Z')
			return 26;
		else
			return 0;
	}
}
