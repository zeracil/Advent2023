package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NumFinder {
	
	public static int FindNumbers() throws FileNotFoundException {
		File file = new File("C:\\Users\\matti\\eclipse-workspace\\AdventOfCode2023\\src\\day1\\InputDay1");
		Scanner fileScanner = new Scanner(file).useDelimiter("\\n");
		String line = new String();
		ArrayList<Integer> lineInts = new ArrayList<Integer>();
		int num = 0;
		int sum = 0;
		
		for (int i = 0; i < 1000; i++) {
				Scanner lineScanner = new Scanner(fileScanner.next()).useDelimiter("");
				while(lineScanner.hasNext()) {
					line = lineScanner.next();
					if(line.equals("1") || line.equals("2") || line.equals("3") || line.equals("4") || line.equals("5") || line.equals("6") || line.equals("7") || line.equals("8") || line.equals("9") || line.equals("0") ) {
						lineInts.add(Integer.parseInt(line));
					}
				}
				num = lineInts.get(0)*10+lineInts.get(lineInts.size()-1);
				sum = sum + num;
				lineInts.clear();
			}
		fileScanner.close();
		return sum;
	}

    
}
