package nzprog_2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem_H 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//line0
		String origin = in.readLine();
		
		//line1
		String departure = in.readLine();
		String[] line = departure.split(" ");
		int msm = (Integer.parseInt(line[2].split(":")[0]) * 60) + Integer.parseInt(line[2].split(":")[1]); //minutes since midnight
		
		//line2
		line = in.readLine().split(":");
		line[1] = line[0].charAt(0) + line[1]; //copying sign to minutes position
		int tzd = -(Integer.parseInt(line[0]) * 60 + Integer.parseInt(line[1])); //time zone difference (minutes)
		
		//line3
		String destination = in.readLine();
		
		//line4
		line = in.readLine().split(":");
		line[1] = line[0].charAt(0) + line[1]; //copying sign to minutes position
		tzd += Integer.parseInt(line[0]) * 60 + Integer.parseInt(line[1]);
		
		//line5
		line = in.readLine().split(":");
		int flight_minutes = Integer.parseInt(line[0]) * 60 + Integer.parseInt(line[1]);
		
		//processing
		int total_minutes  = flight_minutes + tzd;
		msm += total_minutes; //minutes since midnight at destination
		int hours, minutes_remainder;
		hours = msm / 60;
		minutes_remainder = msm % 60;
		String whichday = "same day";
		if (hours >= 24)
		{
			hours = hours % 24;
			whichday = "following day";
		}
		
		System.out.println("Departs " + origin + " " + departure);
		System.out.println("Arrives " + destination + " " + String.format("%02d", hours) + ":" + String.format("%02d", minutes_remainder) + " " + whichday);
		
		
	}
}
