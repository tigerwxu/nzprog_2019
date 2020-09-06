package nzprog_2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem_I 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		List<String> possibilities = new ArrayList<String>(); //probably a better idea to use a set, but a list is easier to iterate over
		
		//fill up the list with all 1296 possible codes
		for (int i = 0; i < 1296; i++)
		{
			//System.out.println(get_permutation(i));
			possibilities.add(get_permutation(i));
		}
		
		int num_guesses = Integer.parseInt(in.readLine());
		for (int i = 0; i < num_guesses; i++)
		{
			String[] line = in.readLine().split(" ");
			String guess = line[0];
			int exact = Integer.parseInt(line[1]);
			int almost = Integer.parseInt(line[2]);
			for (int j = 0; j < possibilities.size(); j++) //watch out for pointer j - need to decrement on removal to keep pointer correct
			{
				if (!possible(possibilities.get(j), guess, exact, almost))
				{
					possibilities.remove(j);
					j--;
				}
			}
			
			if (possibilities.size() == 1)
			{
				System.out.println(possibilities.get(0));
				System.out.println(i + 1);
				break;
				
			}
		}
		
		
		
	}
	
	static String get_permutation(int i) // 0 < i < 1296
	{
		String code = "";
		code = code + (char) (((i/216) % 6) + 65);
		code = code + (char) (((i/36) % 6) + 65);
		code = code + (char) (((i/6) % 6) + 65);
		code = code + (char) ((i % 6) + 65);
		
		return code;
	}
	
	
	static boolean possible(String assumption, String guess, int exact, int almost)
	{
		int true_exact = 0;
		int true_almost = 0;
		
		//count exact matches
		for (int i = 0; i < assumption.length(); i++)
		{
			if (assumption.charAt(i) == guess.charAt(i))
			{
				true_exact++;
				assumption = assumption.substring(0, i) + assumption.substring(i+1);
				guess = guess.substring(0, i) + guess.substring(i+1);
				i--; //move pointer back by 1 to account for removal
			}
		}
		
		//count almost matches
		for (int i = 0; i < assumption.length(); i++)
		{
			char curr_char = assumption.charAt(i);
			if (guess.indexOf(curr_char) != -1)
			{
				true_almost++;
				assumption = assumption.replaceFirst("" + curr_char, "");
				guess = guess.replaceFirst("" + curr_char, "");
				i--;
			}
		}
		
		if (exact == true_exact && almost == true_almost)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
