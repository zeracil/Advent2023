package day1;

import java.io.FileNotFoundException;
import java.util.stream.IntStream;

public class RunDay1 {
	public static void main(String[] args) throws FileNotFoundException {
		int sum = NumFinder.FindNumbers();
	    System.out.println(sum);
	    
	    int sumAdvanced = AdvancedNumFinder.FindNumbers();
	    System.out.println(sumAdvanced);
	    
	  }
}
