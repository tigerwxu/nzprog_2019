package nzprog_2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem_F 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int num_lines = Integer.parseInt(in.readLine());
		
		for (int n = 0; n < num_lines; n++ )
		{
			String[] cards = in.readLine().split(" ");
			String final_card = "";
			
			for (int i = 0; i < 4; i++)
			{
				if (cards[0].charAt(i) == cards[1].charAt(i))
				{
					final_card = final_card + cards[0].charAt(i);
				}
				else
				{
					final_card = final_card + find_property("" + cards[0].charAt(i), "" + cards[1].charAt(i), i);
				}
			}
			
			System.out.println(final_card);
		}
	}
	
	static String find_property(String a, String b, int property)
	{
		String labels = null;
		switch (property)
		{
			case 0:
				labels = "RGB";
				break;
			case 1:
				labels = "DOS";
				break;
			case 2:
				labels = "123";
				break;
			case 3:
				labels = "FSE";
				break;
		}
		
		labels = labels.replace(a, "");
		labels = labels.replace(b, "");
		return labels;

	}
}
