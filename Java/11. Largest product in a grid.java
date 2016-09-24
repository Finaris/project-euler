import java.util.*;
import java.io.IOException;
import java.math.*;
import java.nio.charset.*;
import java.nio.file.*;

public class Test 
{	
	
	static int[][] grid = new int[20][20];
	static List<String> fileArray;
	static long largestProduct = 0;
	
	public static void main(String[] args) throws IOException
	{
		
		Path path = Paths.get("chacha.txt");
		Charset cs = StandardCharsets.US_ASCII;
		fileArray = Files.readAllLines(path, cs);
		for(int i = 0; i < 20; i++)
		{
			String[] tempArray = fileArray.get(i).split(" ");
			for(int j = 0; j < 20; j++)
			{
				grid[i][j] = Integer.parseInt(tempArray[j]);
			}
		}
		
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 17; j++)
			{
				long tempProduct = 1;
				for(int k = 0; k < 4; k++)
				{
					tempProduct *= grid[i][j+k];
				}
				if(tempProduct > largestProduct)
					largestProduct = tempProduct;
			}
		}
		
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 17; j++)
			{
				long tempProduct = 1;
				for(int k = 0; k < 4; k++)
				{
					tempProduct *= grid[j+k][i];
				}
				if(tempProduct > largestProduct)
					largestProduct = tempProduct;
			}
		}
		
		for(int i = 0; i < 17; i++)
		{
			for(int j = 0; j < 17; j++)
			{
				long tempProduct = 1;
				for(int k = 0; k < 4; k++)
				{
					tempProduct *= grid[i+k][j+k];
				}
				if(tempProduct > largestProduct)
					largestProduct = tempProduct;
			}
		}
		
		for(int i = 19; i > 3; i--)
		{
			for(int j = 0; j < 17; j++)
			{
				long tempProduct = 1;
				for(int k = 0; k < 4; k++)
				{
					tempProduct *= grid[i-k][j+k];
				}
				if(tempProduct > largestProduct)
					largestProduct = tempProduct;
			}
		}
		
		System.out.println(largestProduct);
	
	}
}
