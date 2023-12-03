package day3;

import java.util.ArrayList;

public class Positioner {
	
	public static int findLen(int x, int y, int[][] matrix) {
		int i = x;
		int k = y;
		int len = 0;
		while (matrix[i][k] > -1) {
			len = len +1; 
			k = k+1;
		}
		return len;
	}
	
	public static boolean testAdj(int x, int y, int numLen, int[][] matrix) {
		boolean foundAdj = false;
		for (int i = x-1; i < x+2; i++) {
			for (int k = y-1; k < y+numLen+1; k++) {
				if (matrix[i][k] == -9) {
					foundAdj = true;
				}
			}
		}
		return foundAdj;
	}
	
	public static int numCreator(int x, int y, int numLen, int[][] matrix) {
		int pos = 1;
		int number = 0;
		for (int i = y+numLen-1; i > y-1; i--) {
			number = number + matrix[x][i]*pos;
			pos = pos*10;
		}
		return number;
	}
	
	public static int[] findStart(int x, int y, int[][] matrix) {
		int[] startPos = {x,-1};
		int k = y;
		while(matrix[x][k] > -1) {
			startPos[1] = k;
			k = k-1;
		}
		return startPos;
	}
	
	public static ArrayList<Integer> findNums(int[][] matrix) {
			int i = 1;
			int k = 1;
			int numLen = 1;
			ArrayList<Integer> nums = new ArrayList<Integer>();
			
			while (i < 141) {
				while (k < 141) {
					if (matrix[i][k] > -1) {
						numLen = findLen(i,k,matrix);
						if (testAdj(i,k,numLen,matrix)) {
							nums.add(numCreator(i,k,numLen,matrix));
						}
						k = k + numLen;
					} else {
						k = k+1;
					}
				}
				k = 1;
				i = i+1;
			}
		return nums;
	}

	public static ArrayList<Integer> gearRatio(int[][] matrix) {
		int i = 1;
		int k = 1;
		int[] startPos1 = new int[2];
		int[] startPos2 = new int[2];
		int[] tempStart = new int[2];
		int numLen1 = 0;
		int numLen2 = 0;
		int num1 = 0;
		int num2 = 0;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while (i < 141) {
			while (k < 141) {
				if (matrix[i][k] == -9) {
					startPos1[0] = -1;
					startPos1[1] = -1;
					startPos2[0] = -1;
					startPos2[1] = -1;
					numLen1 = 0;
					numLen2 = 0;
					for (int x = i-1; x < i+2; x++) {
						for (int y = k-1; y < k+2; y++) {
							if (matrix[x][y] > -1) {
								tempStart = findStart(x,y,matrix);
								if (startPos1[0] == -1) {
									startPos1 = tempStart;
									numLen1 = findLen(startPos1[0], startPos1[1], matrix);
								} else if(tempStart[0] != startPos2[0] && tempStart[1] != startPos2[1] && (tempStart[0] != startPos1[0] || tempStart[1] != startPos1[1])) {
									startPos2 = tempStart;
									numLen2 = findLen(startPos2[0], startPos2[1], matrix);
								}
							}
						}
					}
					if (startPos2[0] != -1) {
						num1 = numCreator(startPos1[0], startPos1[1], numLen1, matrix);
						num2 = numCreator(startPos2[0], startPos2[1], numLen2, matrix);
						nums.add(num1*num2);
					}
				}
				k = k+1;
			}
			k = 1;
			i = i+1;
		}
		return nums;
	}
}
