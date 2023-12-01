package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdvancedNumFinder {
	
	public static int FindNumbers() throws FileNotFoundException {
		File file = new File("C:\\Users\\matti\\eclipse-workspace\\AdventOfCode2023\\src\\day1\\InputDay1");
		Scanner fileScanner = new Scanner(file).useDelimiter("\\n");
		String line = new String();
		ArrayList<Integer> lineInts = new ArrayList<Integer>();
		ArrayList<String> lineChars = new ArrayList<String>();
		int num = 0;
		int sum = 0;
		
		for (int i = 0; i < 1000; i++) {
				Scanner lineScanner = new Scanner(fileScanner.next()).useDelimiter("");
				while(lineScanner.hasNext()) {
					lineChars.add(lineScanner.next());
				}
				
				for (int k = 0; k<lineChars.size(); k++) {
					if(lineChars.get(k).equals("1") || lineChars.get(k).equals("2") || lineChars.get(k).equals("3") || lineChars.get(k).equals("4") || lineChars.get(k).equals("5") || lineChars.get(k).equals("6") || lineChars.get(k).equals("7") || lineChars.get(k).equals("8") || lineChars.get(k).equals("9") || lineChars.get(k).equals("0") ) {
						lineInts.add(Integer.parseInt(lineChars.get(k)));
					} else {
						if(lineChars.get(k).equals("o") && k+2 < lineChars.size() ) {
							if(lineChars.get(k+1).equals("n") && lineChars.get(k+2).equals("e")) {
								lineInts.add(1);
							}
						} 
						if (lineChars.get(k).equals("t") && k+2 < lineChars.size() ) {
							if(lineChars.get(k+1).equals("w") && lineChars.get(k+2).equals("o")) {
								lineInts.add(2);
							} 
						}
						if (lineChars.get(k).equals("t") && k+4 < lineChars.size() ) {
							if(lineChars.get(k+1).equals("h") && lineChars.get(k+2).equals("r") && lineChars.get(k+3).equals("e") && lineChars.get(k+4).equals("e")) {
								lineInts.add(3);
							}
						}
						if (lineChars.get(k).equals("f") && k+3 < lineChars.size() ) {
							if(lineChars.get(k+1).equals("o") && lineChars.get(k+2).equals("u") && lineChars.get(k+3).equals("r")) {
								lineInts.add(4);
							}
						}
						if (lineChars.get(k).equals("f") && k+3 < lineChars.size() ) {
							if(lineChars.get(k+1).equals("i") && lineChars.get(k+2).equals("v") && lineChars.get(k+3).equals("e")) {
								lineInts.add(5);
							}
						}
						if (lineChars.get(k).equals("s") && k+2 < lineChars.size() ) {
							if(lineChars.get(k+1).equals("i") && lineChars.get(k+2).equals("x")) {
								lineInts.add(6);
							}
						}
						if (lineChars.get(k).equals("s") && k+4 < lineChars.size() ) {
							if(lineChars.get(k+1).equals("e") && lineChars.get(k+2).equals("v") && lineChars.get(k+3).equals("e") && lineChars.get(k+4).equals("n")) {
								lineInts.add(7);
							}
						}
						if (lineChars.get(k).equals("e") && k+4 < lineChars.size() ) {
							if(lineChars.get(k+1).equals("i") && lineChars.get(k+2).equals("g") && lineChars.get(k+3).equals("h") && lineChars.get(k+4).equals("t")) {
								lineInts.add(8);
							}
						}
						if (lineChars.get(k).equals("n") && k+3 < lineChars.size() ) {
							if(lineChars.get(k+1).equals("i") && lineChars.get(k+2).equals("n") && lineChars.get(k+3).equals("e")) {
								lineInts.add(9);
							}
						}
					} 
				}
				num = lineInts.get(0)*10+lineInts.get(lineInts.size()-1);
				sum = sum + num;
				lineInts.clear();
				lineChars.clear();
			}
		fileScanner.close();
		return sum;
	}

    
}
