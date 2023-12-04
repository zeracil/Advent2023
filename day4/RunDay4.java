package day4;

import java.io.FileNotFoundException;

public class RunDay4 {

	public static void main(String[] args) throws FileNotFoundException {
		int sum = Tools.winnings();
		System.out.println(Integer.toString(sum));
		int sum2 = Tools.advancedWinnings();
		System.out.println(Integer.toString(sum2));

	}

}
