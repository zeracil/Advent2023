package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Converter {
	public static int[][] matrix() throws FileNotFoundException {
		int[][] matrix = new int[140][140];
		String tempChar = new String();
		File file = new File("C:\\Users\\matti\\eclipse-workspace\\AdventOfCode2023\\src\\day3\\InputDay3");
		try (Scanner fileScanner = new Scanner(file).useDelimiter("\\n")) {
			for (int i = 0; i < 140; i++) {
				Scanner charScanner = new Scanner(fileScanner.next()).useDelimiter("");
				for (int k = 0; k < 140; k++) {
					tempChar = charScanner.next();
					if(tempChar.equals("1") || tempChar.equals("2") || tempChar.equals("3") || tempChar.equals("4") || tempChar.equals("5") || tempChar.equals("6") || tempChar.equals("7") || tempChar.equals("8") || tempChar.equals("9") || tempChar.equals("0") ) {
						matrix[i][k] = Integer.parseInt(tempChar);
					} else if (tempChar.equals(".")) {
						matrix[i][k] = -1;
					} else {
						matrix[i][k] = -9;
					}
				}
			}
			
		}
		return matrix;
	}
	
	public static int[][] matrixVar() throws FileNotFoundException {
		int[][] matrix = new int[140][140];
		String tempChar = new String();
		File file = new File("C:\\Users\\matti\\eclipse-workspace\\AdventOfCode2023\\src\\day3\\InputDay3");
		try (Scanner fileScanner = new Scanner(file).useDelimiter("\\n")) {
			for (int i = 0; i < 140; i++) {
				Scanner charScanner = new Scanner(fileScanner.next()).useDelimiter("");
				for (int k = 0; k < 140; k++) {
					tempChar = charScanner.next();
					if(tempChar.equals("1") || tempChar.equals("2") || tempChar.equals("3") || tempChar.equals("4") || tempChar.equals("5") || tempChar.equals("6") || tempChar.equals("7") || tempChar.equals("8") || tempChar.equals("9") || tempChar.equals("0") ) {
						matrix[i][k] = Integer.parseInt(tempChar);
					} else if (tempChar.equals("*")) {
						matrix[i][k] = -9;
					} else {
						matrix[i][k] = -1;
					}
				}
			}
			
		}
		return matrix;
	}
	
	public static int[][] padder(int[][] orgMatrix) {
		int [][] matrix = new int[142][142];
		for (int i = 0; i < 142; i++) {
			matrix[0][i] = -1;
		}
		for (int i = 1; i < 141; i++) {
			matrix[i][0] = -1;
			matrix[i][141] = -1;
			for (int k = 1; k < 141; k++) {
				matrix[i][k] = orgMatrix[i-1][k-1];
			}
		}
		for (int i = 0; i < 142; i++) {
			matrix[141][i] = -1;
		}
		return matrix;
	}
}

