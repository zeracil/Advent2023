package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameChecker {

	public static int valid(int numRed, int numGreen, int numBlue) throws FileNotFoundException {
		int sum = 0;
		int tempNum = 0;
		int currentGame = 0;
		String tempColour = new String();
		boolean validity = true;
		boolean firstSet = true;
		File file = new File("C:\\Users\\matti\\eclipse-workspace\\AdventOfCode2023\\src\\day2\\InputDay2");
		try (Scanner fileScanner = new Scanner(file).useDelimiter("\\n")) {
			while(fileScanner.hasNext()) {
				Scanner setScanner = new Scanner(fileScanner.next()).useDelimiter(";");
				firstSet = true;
				validity = true;
				currentGame = currentGame + 1;
				while(setScanner.hasNext()) {
					Scanner wordScanner = new Scanner(setScanner.next()).useDelimiter(" ");
					if (firstSet == true) {
						wordScanner.next();
						wordScanner.next();
						firstSet = false;
					}
					while(wordScanner.hasNext()) {
						tempNum = Integer.parseInt(wordScanner.next());
						tempColour = wordScanner.next();
						if (tempColour.equals("red") || tempColour.equals("red,") || tempColour.equals("red\r")) {
							if (numRed < tempNum) {
								validity = false;
							}
						} else if (tempColour.equals("green") || tempColour.equals("green,") || tempColour.equals("green\r")) {
							if (numGreen < tempNum) {
								validity = false;
							}
						} else if (tempColour.equals("blue") || tempColour.equals("blue,") || tempColour.equals("blue\r")) {
							if (numBlue < tempNum) {
								validity = false;
							}
						}
						if (validity == false) {
							break;
						}
					}
				}
				if (validity == true) {
					sum = sum + currentGame;
				}
			}
			fileScanner.close();
		}
		return sum;
	}
	
	public static int minPowerCalc() throws FileNotFoundException {
		int sum = 0;
		int tempNum = 0;
		int currentGame = 0;
		int tempMaxRed = 0;
		int tempMaxGreen = 0;
		int tempMaxBlue = 0;
		String tempColour = new String();
		boolean firstSet = true;
		
		File file = new File("C:\\Users\\matti\\eclipse-workspace\\AdventOfCode2023\\src\\day2\\InputDay2");
		try (Scanner fileScanner = new Scanner(file).useDelimiter("\\n")) {
			while(fileScanner.hasNext()) {
				Scanner setScanner = new Scanner(fileScanner.next()).useDelimiter(";");
				tempMaxRed = 0;
				tempMaxGreen = 0;
				tempMaxBlue = 0;
				firstSet = true;
				currentGame = currentGame + 1;
				while(setScanner.hasNext()) {
					Scanner wordScanner = new Scanner(setScanner.next()).useDelimiter(" ");
					if (firstSet == true) {
						wordScanner.next();
						wordScanner.next();
						firstSet = false;
					}
					while(wordScanner.hasNext()) {
						tempNum = Integer.parseInt(wordScanner.next());
						tempColour = wordScanner.next();
						if (tempColour.equals("red") || tempColour.equals("red,") || tempColour.equals("red\r")) {
							if (tempMaxRed < tempNum) {
								tempMaxRed = tempNum;
							}
						} else if (tempColour.equals("green") || tempColour.equals("green,") || tempColour.equals("green\r")) {
							if (tempMaxGreen < tempNum) {
								tempMaxGreen = tempNum;
							}
						} else if (tempColour.equals("blue") || tempColour.equals("blue,") || tempColour.equals("blue\r")) {
							if (tempMaxBlue < tempNum) {
								tempMaxBlue = tempNum;
							}
						}
					}
				}
				sum = sum + tempMaxRed*tempMaxGreen*tempMaxBlue;
			}
			fileScanner.close();
		}
		return sum;
	}
}
