package chess362;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Probability {

	//amount off the top / trials
	//255 / that
	
	public static void main(String[] args) {
		int n = 9;
		int trials = 100;
		long numOfTests = 100000000;
		int successfulFalls = 0;
		int fellOffTop = 0;
		
		int x = 2;
		int y = 4;
		
		int movement;
		
		boolean fell = false;
		
		Random rand = new Random();
		
		System.out.println("start");
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				
				x = i;
				y = j;
				fellOffTop = 0;
				
				while (successfulFalls < numOfTests) {

					//maybe check fall in expectation
					if (fell) {
						x = i;
						y = j;
						fell = false;
					}

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
					
					
					

					if (x <= 0 || x >= n || y <= 0 || y >= n) {
						//System.out.println("Fell off the board in " + steps + " steps!");
						successfulFalls++;
						if (x <= 0 || (x == 0 && y == 0) || (y == n && x == 0)) fellOffTop++;
						fell = true;
					}

				}
				successfulFalls = 0;
				
				//System.out.println("X: " + i + ",  Y: " + j);
				//System.out.println("Fell off the top " + fellOffTop + " times.");
				/*if(j == 1 && i == 1){
					System.out.print("p");
					System.out.println(x + ", " + y);
				}
				else System.out.print("0");*/
				double prob =  (fellOffTop / (double)numOfTests);
				System.out.print(prob + "  ");
				
			} 
			System.out.println("\n");
		}
	}
}