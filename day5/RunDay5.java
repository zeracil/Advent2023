package day5;

import java.util.ArrayList;

public class RunDay5 {

	public static void main(String[] args) {
		ArrayList<Long> locations = Tools.findLocations();
		long lowest = Tools.findLowest(locations);
		System.out.println(Long.toString(lowest));
	}

}
