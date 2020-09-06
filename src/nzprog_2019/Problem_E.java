package nzprog_2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Problem_E {
	
	static class Student
	{
		String name;
		int[] attempts;
		boolean[] passed;
		
		public Student(String name)
		{
			this.name = name;
			attempts = new int[5];
			passed = new boolean[5];
		}
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		//parse in weightings
		int max_score = 0;
		int[] weightings = new int[5];
		String[] weightings_string = in.readLine().split(" ");
		for (int i = 0; i < 5; i++)
		{
			int weight = Integer.parseInt(weightings_string[i]);
			max_score += weight * 10;
			weightings[i] = weight;
		}
		
		int no_students = Integer.parseInt(in.readLine());
		int order[] = new int[no_students]; //we need to keep track of the order we see the students since that order is also the output order
		HashMap<Integer, Student> students = new HashMap<Integer, Student>();
		
		//populating hashmap with students
		for (int i = 0; i < no_students; i++)
		{
			String[] line = in.readLine().split(" ");
			int id = Integer.parseInt(line[0]);
			order[i] = id;
			Student curr_student = new Student(line[1] + " " + line[2]);
			students.put(id, curr_student);
			
		}
		
		//run through test results, updating each time:
		String line = in.readLine();
		while (!line.equals("0 # #"))
		{
			int id = Integer.parseInt(line.split(" ")[0]);
			int testNum = (int) line.split(" ")[1].charAt(0) - 65;
			boolean passed = line.split(" ")[2].equals("P") ? true : false;
			
			Student student = students.get(id);
			student.attempts[testNum] += 1;
			student.passed[testNum] = passed;
			
			line = in.readLine();
		}
		
		//print results:
		for (int i = 0; i < no_students; i++)
		{
			Student student = students.get(order[i]);
			int score = 0;
			for (int j = 0; j < 5; j++)
			{
				if (student.passed[j])
				{
					if (student.attempts[j] == 1)
					{
						score += 10 * weightings[j];
					}
					else if (student.attempts[j] == 2)
					{
						score += 7 * weightings[j];
					}
					else 
					{
						score += 4 * weightings[j];
					}
				}
			}
			
			if ((score * 2) >= max_score)
			{
				System.out.println(student.name + " Pass");
			}
			else
			{
				System.out.println(student.name + " Fail");
			}
			
		}
		
	}

}
