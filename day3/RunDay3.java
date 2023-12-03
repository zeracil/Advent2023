package day3;

import java.io.FileNotFoundException;

import java.util.ArrayList;


public class RunDay3 {
	
	public static void main(String[] args) throws FileNotFoundException {
		int[][] matrix = Converter.matrix();
		matrix = Converter.padder(matrix);
		ArrayList<Integer> nums = Positioner.findNums(matrix);
		System.out.println(nums.toString());
		
		int sum = 0;
		for (int i = 0; i < nums.size(); i++) {
			sum = sum + nums.get(i);
		}
		System.out.println(Integer.toString(sum));
		
		// part 2
		
		matrix = Converter.matrixVar();
		matrix = Converter.padder(matrix);
		nums = Positioner.gearRatio(matrix);
		System.out.println(nums.toString());
		
		sum = 0;
		for (int i = 0; i < nums.size(); i++) {
			sum = sum + nums.get(i);
		}
		System.out.println(Integer.toString(sum));
	  }
}
