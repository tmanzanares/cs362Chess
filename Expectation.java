package chess362;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Expectation {

	//amount off the top / trials
	//255 / that
	
	public static void main(String[] args) {

		int n = 2;
		int trials = 100;
		int innerTrials = 5000000;
		int[] moves = new int[innerTrials];
		double[] totalTrials = new double[trials];
		int[][] board; // = new int[n][n];
		int x;
		int y;
		int movement;
		int steps;
		int successfulFalls = 0;
		int num;
		boolean fell = false;

		Random rand = new Random();
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter("C:/Users/Tommy/Desktop/expectation.txt", false);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bw = new BufferedWriter(fw);
		
		for (int i = 0; i < trials; i++) {
			n++; //Use when there is another for loop
			//System.out.println("NNNNNNNNNNNNNNNNN " + n);
			board = new int[n][n];
			steps = 0;
			x = rand.nextInt(n - 2) + 1;
			y = rand.nextInt(n - 2) + 1;
			//System.out.println("X is: " + x + ", Y is: " + y);
			successfulFalls = 0;
			
			num = n - 2;
			System.out.println("Starting the " + num + ", " + num + " test.");
			while (successfulFalls < innerTrials) {

				if(fell){
					x = rand.nextInt(n - 2) + 1;
					y = rand.nextInt(n - 2) + 1;
					fell = false;
					steps = 0;
				}
				//System.out.println("X: " + x + ",  Y: " + y);
				movement = rand.nextInt(8) + 1;
				switch (movement) {
				case 1:
					x--;
					break;
				case 2:
					x--;
					y--;
					break;
				case 3:
					x--;
					y++;
					break;
				case 4:
					y++;
					break;
				case 5:
					y--;
					break;
				case 6:
					x++;
					break;
				case 7:
					x++;
					y++;
					break;
				case 8:
					x++;
					y--;
					break;
				}
				steps++;
				if (x <= 0 || x >= n - 1 || y <= 0 || y >= n - 1){
					//System.out.println("Fell off the board in " + steps + " steps!");
					moves[successfulFalls] = steps;
					successfulFalls++;
					fell = true;
				}
				
			}
			fell = false; // reset for next goround
			
			double avg = 0;
			for (int j = 0; j < moves.length; j++) {
				avg += moves[j];
			}
			avg = avg / moves.length;
			totalTrials[i] = avg;
			
			
		}
		
		double totalavg = 0;
		for (int i = 0; i < totalTrials.length; i++) {
			totalavg += totalTrials[i];
			 try {
				fw.write("Average expectation of " + i + "   " + String.valueOf(totalTrials[i]) + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		totalavg = totalavg / totalTrials.length;
		System.out.println(totalavg);
		
		try {
			//bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}