package nzprog_2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem_D {

	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean turn_A = true;
		
		String team_A = in.readLine();
		String team_B = in.readLine();
		
		String score = in.readLine();
		int score_A = Integer.parseInt(score.split(" ")[0]);
		int score_B = Integer.parseInt(score.split(" ")[1]);

		int num_chars = Integer.parseInt(in.readLine());
		
		String game = in.readLine();
		
		for (int i = 0; i < num_chars; i++)
		{
			switch (game.charAt(i)) 
			{
				case ('M'):
					turn_A = !turn_A;
					break;
				case ('H'):
					if (turn_A)
					{
						score_A++;
					}
					else
					{
						score_B++;
					}
					break;
				case('P'):
					if (turn_A)
					{
						score_A++;
					}
					else
					{
						score_B++;
					}
					turn_A = !turn_A;
					break;
			}
		}
		
		System.out.println(team_A + " " + score_A + " " + team_B + " " + score_B);
		
		
		
	}
}
