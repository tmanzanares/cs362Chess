package chess362;

import java.util.Random;

public class Bonus {

	//actual distribution of an 8x8
	//show the chances that he falls off of each square
	public static void main(String[] args) {
		int n = 9;
		int trials = 100;
		long numOfTests = 1000000000;
		int successfulFalls = 0;
		int fellOffTop = 0;
		
		int x = 2;
		int y = 4;

		int tempx = x;
		int tempy = y;
		
		int x1y1 = 0;
		int x1y2 = 0;
		int x1y3 = 0;
		int x1y4 = 0;
		int x1y5 = 0;
		int x1y6 = 0;
		int x1y7 = 0;
		int x1y8 = 0;
		
		int x2y1 = 0;
		int x2y8 = 0;
		
		int x3y1 = 0;
		int x3y8 = 0;
		
		int x4y1 = 0;
		int x4y8 = 0;
		
		int x5y1 = 0;
		int x5y8 = 0;
		
		int x6y1 = 0;
		int x6y8 = 0;
		
		int x7y1 = 0;
		int x7y8 = 0;
		
		int x8y1 = 0;
		int x8y2 = 0;
		int x8y3 = 0;
		int x8y4 = 0;
		int x8y5 = 0;
		int x8y6 = 0;
		int x8y7 = 0;
		int x8y8 = 0;
		
		int movement;
		
		boolean fell = false;
		
		Random rand = new Random();
		
		System.out.println("start");
		//for (int i = 1; i < n; i++) {
		//	for (int j = 1; j < n; j++) {
				
				fellOffTop = 0;
				
				while (successfulFalls < numOfTests) {

					if (fell) {
						x = 2;
						y = 4;
						fell = false;
					}

					tempx = x;
					tempy = y;
					
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
						//if (x <= 0 || (x == 0 && y == 0) || (y == n && x == 0)) fellOffTop++;
						
						
						if(tempx == 1 && tempy == 1) x1y1++;
						if(tempx == 1 && tempy == 2) x1y2++;
						if(tempx == 1 && tempy == 3) x1y3++;
						if(tempx == 1 && tempy == 4) x1y4++;
						if(tempx == 1 && tempy == 5) x1y5++;
						if(tempx == 1 && tempy == 6) x1y6++;
						if(tempx == 1 && tempy == 7) x1y7++;
						if(tempx == 1 && tempy == 8) x1y8++;
						
						if(tempx == 2 && tempy == 1) x2y1++;
						if(tempx == 2 && tempy == 8) x2y8++;
						
						if(tempx == 3 && tempy == 1) x3y1++;
						if(tempx == 3 && tempy == 8) x3y8++;
						
						if(tempx == 4 && tempy == 1) x4y1++;
						if(tempx == 4 && tempy == 8) x4y8++;

						if(tempx == 5 && tempy == 1) x5y1++;
						if(tempx == 5 && tempy == 8) x5y8++;
						
						if(tempx == 6 && tempy == 1) x6y1++;
						if(tempx == 6 && tempy == 8) x6y8++;
						
						if(tempx == 7 && tempy == 1) x7y1++;
						if(tempx == 7 && tempy == 8) x7y8++;
						
						if(tempx == 8 && tempy == 1) x8y1++;
						if(tempx == 8 && tempy == 2) x8y2++;
						if(tempx == 8 && tempy == 3) x8y3++;
						if(tempx == 8 && tempy == 4) x8y4++;
						if(tempx == 8 && tempy == 5) x8y5++;
						if(tempx == 8 && tempy == 6) x8y6++;
						if(tempx == 8 && tempy == 7) x8y7++;
						if(tempx == 8 && tempy == 8) x8y8++;
						
						fell = true;
					}

				}
				successfulFalls = 0;

				System.out.println(x1y1/(double)numOfTests + "  " + x1y2/(double)numOfTests + "  " + x1y3/(double)numOfTests + "  " + x1y4/(double)numOfTests + "  " + x1y5/(double)numOfTests + "  " + x1y6/(double)numOfTests + "  " + x1y7/(double)numOfTests + "  " + x1y8/(double)numOfTests);
				System.out.println(x2y1/(double)numOfTests + "                      " + x2y8/(double)numOfTests);
				System.out.println(x3y1/(double)numOfTests + "                      " + x3y8/(double)numOfTests);
				System.out.println(x4y1/(double)numOfTests + "                      " + x4y8/(double)numOfTests);
				System.out.println(x5y1/(double)numOfTests + "                      " + x5y8/(double)numOfTests);
				System.out.println(x6y1/(double)numOfTests + "                      " + x6y8/(double)numOfTests);
				System.out.println(x7y1/(double)numOfTests + "                      " + x7y8/(double)numOfTests);
				System.out.println(x8y1/(double)numOfTests + "  " + x8y2/(double)numOfTests + "  " + x8y3/(double)numOfTests + "  " + x8y4/(double)numOfTests + "  " + x8y5/(double)numOfTests + "  " + x8y6/(double)numOfTests + "  " + x8y7/(double)numOfTests + "  " + x8y8/(double)numOfTests);
				 
			//} 
		//}
	}
}
