package nzprog_2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem_B 
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(in.readLine());
		int n2 = Integer.parseInt(in.readLine());
		
		System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
		System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));
		System.out.println(n1 + " x " + n2 + " = " + (n1 * n2));
		System.out.println(n1 + " divided by " + n2 + " is " + (n1 / n2) + " remainder " + (n1 % n2));
	}
}
