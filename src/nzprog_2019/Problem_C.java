package nzprog_2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Problem_C {

	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String item_name = in.readLine();
		int num_items = Integer.parseInt(in.readLine());
		
		HashMap<String, Double> hmap = new HashMap<String, Double>();
		List<String> missing_ingredients = new ArrayList<String>();
		
		for (int i = 0; i < num_items; i ++)
		{
			String[] tokens = in.readLine().split(", ");
			double quantity = Double.parseDouble(tokens[2]);
			if (tokens[1].matches("(kg)|l"))
			{
				quantity = quantity * 1000;
			}
			hmap.put(tokens[0], quantity);
		}
		
		for (int i = 0; i < num_items; i++)
		{
			String[] tokens = in.readLine().split(", ");
			double quantity = Double.parseDouble(tokens[2]);
			if (tokens[1].matches("(kg)|l"))
			{
				quantity = quantity * 1000;
			}
			if (hmap.get(tokens[0]) > quantity)
			{
				missing_ingredients.add(tokens[0]);
			}

		}
		
		Collections.sort(missing_ingredients);
		
		if (missing_ingredients.isEmpty())
		{
			System.out.println("You may make your " + item_name + ".");
		}
		else
		{
			System.out.println("You may NOT make your " + item_name + ".");
			
			String temp = missing_ingredients.get(0);
			for (int i = 1; i < missing_ingredients.size(); i++)
			{
				temp = temp + (", " + missing_ingredients.get(i));
			}
			
			System.out.println("You need " + temp + ".");
		}
	}

}
