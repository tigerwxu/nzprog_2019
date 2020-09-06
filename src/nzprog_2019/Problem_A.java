package nzprog_2019;

import java.io.*;

public class Problem_A
{	
	@SuppressWarnings("unused")
	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int total_spaces = Integer.parseInt(in.readLine());
		boolean[] space_taken = new boolean[total_spaces];
		
		String first_day = in.readLine();
		String second_day = in.readLine();
		int occupied_both_days = 0;
		
		for (int i = 0; i < total_spaces; i++)
		{
			if (first_day.charAt(i) == 'O' && second_day.charAt(i) == 'O')
			{
				occupied_both_days++;
			}
		}
		
		System.out.println(occupied_both_days);
	}
}
