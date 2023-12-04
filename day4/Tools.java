package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Tools {
	
	public static ArrayList<Integer> winNums(String line) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		Scanner charScanner = new Scanner(line).useDelimiter(" ");
		charScanner.next();
		charScanner.next();
		while (charScanner.hasNext()) {
			nums.add(Integer.parseInt(charScanner.next()));
		}
		return nums;
	}
	
	public static ArrayList<Integer> myNums(String line) { 
		String temp = new String();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		Scanner charScanner = new Scanner(line).useDelimiter(" ");
		while (charScanner.hasNext()) {
			temp =charScanner.next();
			nums.add(Integer.parseInt(temp));
		}
		return nums;
	}
	
	public static int numberOfCards(ArrayList<Integer> wins) {
		int[] nums = new int[wins.size()];
		int sum = 0;
		for (int i = 0; i < wins.size(); i++) {
			nums[i] = nums[i] + 1;
			for (int k = wins.get(i); k > 0; k--) {
				nums[i+k] = nums[i+k] + 1*nums[i];
			}
		}
		for (int i = 0; i < wins.size(); i++) {
			sum = sum + nums[i];
		}
		return sum;
	}
	
	public static int winnings() throws FileNotFoundException {
		int win = 0;
		int sum = 0;
		ArrayList<Integer> winningNums = new ArrayList<Integer>();
		ArrayList<Integer> elfNums = new ArrayList<Integer>();
		File file = new File("C:\\Users\\matti\\eclipse-workspace\\AdventOfCode2023\\src\\day4\\InputDay4");
		try (Scanner fileScanner = new Scanner(file).useDelimiter("\\n")) {
			while (fileScanner.hasNext()) {
				Scanner lineScanner = new Scanner(fileScanner.next().replaceAll("  ", " ").replaceAll("  ", " ")).useDelimiter("\\|");
				winningNums = winNums(lineScanner.next());
				elfNums = myNums(lineScanner.next().replaceAll("\r", ""));
				for (int i = 0; i < winningNums.size(); i++) {
					if (elfNums.contains(winningNums.get(i))) {
						if (win == 0) {
							win = 1;
						} else {
							win = win*2;
						}
					}
				}
				sum = sum + win;
				win = 0;
			}
		}
		
		return sum;
	}
	
	public static int advancedWinnings() throws FileNotFoundException {
		ArrayList<Integer> winsArr = new ArrayList<Integer>();
		//int pos = 0;
		int wins = 0;
		int sum = 0;
		ArrayList<Integer> winningNums = new ArrayList<Integer>();
		ArrayList<Integer> elfNums = new ArrayList<Integer>();
		File file = new File("C:\\Users\\matti\\eclipse-workspace\\AdventOfCode2023\\src\\day4\\InputDay4");
		try (Scanner fileScanner = new Scanner(file).useDelimiter("\\n")) {
			while (fileScanner.hasNext()) {
				Scanner lineScanner = new Scanner(fileScanner.next().replaceAll("  ", " ").replaceAll("  ", " ")).useDelimiter("\\|");
				winningNums = winNums(lineScanner.next());
				elfNums = myNums(lineScanner.next().replaceAll("\r", ""));
				for (int i = 0; i < winningNums.size(); i++) {
					if (elfNums.contains(winningNums.get(i))) {
						wins = wins + 1;
					}
				}
				winsArr.add(wins);
				wins = 0;
			}
			sum = numberOfCards(winsArr);
			
			
		}
		
		return sum;
		
		
	}
	
}
