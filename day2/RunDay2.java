package day2;

import java.io.FileNotFoundException;

public class RunDay2 {
	public static void main(String[] args) throws FileNotFoundException {
		int redCap = 12;
		int greenCap = 13;
		int blueCap = 14;
		int sum = GameChecker.valid(redCap, greenCap, blueCap);
	    System.out.println(sum);
	    
	    int sum2 = GameChecker.minPowerCalc();
	    System.out.println(sum2);
	    
	    
	  }
}
