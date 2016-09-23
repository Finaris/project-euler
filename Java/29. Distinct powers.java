import java.util.*;
import java.math.*;

public class Test 
{
	public static void main(String[] args)
	{
		
		ArrayList<BigInteger> sequence = new ArrayList<BigInteger>();
		ArrayList<BigInteger> trueSequence = new ArrayList<BigInteger>();
		for(int i = 2; i <= 100; i++)
		{
			for(int j = 2; j <= 100; j++)
			{
				BigInteger base = new BigInteger(Integer.toString(i));
				BigInteger store = base.pow(j);
				sequence.add(store);
			}
		}
		
		Collections.sort(sequence);
		
		for(BigInteger i: sequence)
			trueSequence.add(i);
		
		for(BigInteger i: sequence)
		{
			while(Collections.frequency(trueSequence, i) > 1)
			{
				trueSequence.remove(i);
			}
		}
		
		System.out.println(trueSequence.size());
		
	}	
}