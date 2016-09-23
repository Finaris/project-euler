import java.util.*;
import java.io.IOException;
import java.math.*;
import java.nio.charset.*;
import java.nio.file.*;

public class Test 
{	
	public static void main(String[] args) throws IOException
	{
		long score = 0;
		Path path = Paths.get("C:\\Users\\Joey\\Desktop\\names.txt");
		Charset characters = StandardCharsets.US_ASCII;
		List<String> names = Files.readAllLines(path, characters);
		
		String name = names.get(0);
		name = name.replace("\"", "");
		String[] namesArray = name.split(",");
		ArrayList<String> namesList = new ArrayList<String>();
		for(int i = 0; i < namesArray.length; i++)
		{
			namesList.add(namesArray[i]);
		}
		
		Collections.sort(namesList);
		for(int i = 0; i < namesList.size(); i++)
		{
			long tempSum = 0;
			for(int j = 0; j < namesList.get(i).length(); j++)
			{
				tempSum += score(namesList.get(i).charAt(j));
			}
			score = score + (tempSum * (i+1));
		}
		
		System.out.println(score);
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