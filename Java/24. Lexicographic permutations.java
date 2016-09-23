import java.util.*;
import java.math.*;

public class Test 
{
	
	static ArrayList<String> lexicographic = new ArrayList<String>();
	
	public static void main(String[] args)
	{
	
		String set = "0123456789";
		permute(set);
		
		Collections.sort(lexicographic);
		
		System.out.println(lexicographic.get(999999));
		
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
			lexicographic.add(out.toString());
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