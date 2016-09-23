import java.util.*;


public class Test 
{

	public static void main(String[] args)
	{
		int counter = 1, check = 0, flag = 0;
		int ans = 0;
		while(flag==0)
		{
			check = 0;
			for(int i = 1; i <= 20; i++)
			{
				if(counter % i == 0)
				{
					check++;
				}
				if(check == 20)
				{
					ans = counter;
					flag = 1;
				}
			}
			
			counter++;
			
		}
		
		System.out.println(ans);
		
	}
}
