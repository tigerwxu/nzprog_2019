package nzprog_2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_G 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num_lines = Integer.parseInt(in.readLine());
		
		for (int n = 0; n < num_lines; n++)
		{
			List<String> symbols = new ArrayList<String>(Arrays.asList(in.readLine().split(" ")));
			int i = 0; //pointer to current symbol
			while (symbols.size() > 1)
			{
				String curr = symbols.get(i);
				if (!curr.matches("(\\d)+")) //check if this is an operand
				{
					int a = Integer.parseInt(symbols.remove(i-2)); //operand now at i-1
					int b = Integer.parseInt(symbols.remove(i-2)); //operand now at i-2
					switch (curr)
					{
						case "+":
							symbols.set(i-2, (a + b) + "");
							break;
						case "-":
							symbols.set(i-2, (a - b) + "");
							break;
						case "*":
							symbols.set(i-2, (a * b) + "");
							break;
						case "/":
							symbols.set(i-2, (a / b) + "");
							break;
					}
					i = i - 2; //move pointer back to account for 2 lost numbers
				}
				i++;
			}
			System.out.println(symbols.get(0));
		}
	}
}
