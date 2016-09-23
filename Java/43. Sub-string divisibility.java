import java.util.*;
import java.math.*;

public class Test 
{
	
	static ArrayList<String> panDigital = new ArrayList<String>();
	
	public static void main(String[] args)
	{
	
		String first = "1406357289";
		BigInteger sum = new BigInteger("0");
		permute(first);
		
		ArrayList<String> panDigitalString = new ArrayList<String>();
		ArrayList<String> answer = new ArrayList<String>();
		
		for(String i: panDigital)
			if(i.charAt(0) != '0')
				panDigitalString.add(i);
		
		for(String i: panDigitalString)
		{
			if(Integer.parseInt(i.substring(7,10)) % 17 == 0)									//17
				if(Integer.parseInt(i.substring(6,9)) % 13 == 0)								//13
					if(Integer.parseInt(i.substring(5,8)) % 11 == 0)							//11
						if(Integer.parseInt(i.substring(4,7)) % 7 == 0)							//7
							if(Integer.parseInt(i.substring(3,6)) % 5 == 0)						//5
								if(Integer.parseInt(i.substring(2,5)) % 3 == 0)					//3
									if(Integer.parseInt(i.substring(1,4)) % 2 == 0)				//2
										answer.add(i);
								
		}
		
		for(String i: answer)
		{
			BigInteger temp = new BigInteger(i);
			sum = sum.add(temp);
		}
		
		System.out.println(sum);
		
	}
	
	public static void permute(String n)
	{
		int length = n.length();
		char[] characters = n.toCharArray();
		boolean[] used = new boolean[length];
		StringBuffer b = new StringBuffer();
		doPermute(length, characters, used, b, 0);
	}
	
	public static void doPermute(int length, char[] characters, boolean[] used, StringBuffer out, int level)
	{
		if(level == length)
		{
			panDigital.add(out.toString());
			return;
		}
		
		for(int i = 0; i < length; ++i)
		{
			if(used[i]) continue;
			
			out.append(characters[i]);
			used[i] = true;
			doPermute(length, characters, used, out, level+1);
			used[i] = false;
			out.setLength(out.length() - 1);
		}
	}
	
}