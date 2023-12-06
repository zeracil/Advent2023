package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Tools {
	

	
	public static ArrayList<Long> findLocations() {
		ArrayList<String> almanack = new ArrayList<String>();
		File file = new File("C:\\Users\\matti\\eclipse-workspace\\AdventOfCode2023\\src\\day5\\InputDay5");
		try {
			Scanner fileScanner = new Scanner(file).useDelimiter("\\n");
			while (fileScanner.hasNext()) {
				almanack.add(fileScanner.next().replaceAll("\r", ""));
			}
			ArrayList<Long> seeds = findSeeds(almanack);
			ArrayList<LinkedList<Long>> seedToSoilLow = oneToTwo(almanack, true, 3, 9);
			ArrayList<LinkedList<Long>> seedToSoilHigh = oneToTwo(almanack, false, 3, 9);
			ArrayList<Long> soils = findTwos(seeds, seedToSoilLow, seedToSoilHigh);
			
			ArrayList<LinkedList<Long>> soilToFertLow = oneToTwo(almanack, true, 11, 54);
			ArrayList<LinkedList<Long>> soilToFertHigh = oneToTwo(almanack, false, 11, 54);
			ArrayList<Long> ferts = findTwos(soils, soilToFertLow, soilToFertHigh);
			
			ArrayList<LinkedList<Long>> fertToWaterLow = oneToTwo(almanack, true, 56, 95);
			ArrayList<LinkedList<Long>> fertToWaterHigh = oneToTwo(almanack, false, 56, 95);
			ArrayList<Long> waters = findTwos(ferts, fertToWaterLow, fertToWaterHigh);
			
			ArrayList<LinkedList<Long>> waterToLightLow = oneToTwo(almanack, true, 97, 144);
			ArrayList<LinkedList<Long>> waterToLightHigh = oneToTwo(almanack, false, 97, 144);
			ArrayList<Long> lights = findTwos(waters, waterToLightLow, waterToLightHigh);
			
			ArrayList<LinkedList<Long>> lightToTempLow = oneToTwo(almanack, true, 146, 173);
			ArrayList<LinkedList<Long>> lightToTempHigh = oneToTwo(almanack, false, 146, 173);
			ArrayList<Long> temps = findTwos(lights, lightToTempLow, lightToTempHigh);
			
			ArrayList<LinkedList<Long>> tempToHumidLow = oneToTwo(almanack, true, 175, 183);
			ArrayList<LinkedList<Long>> tempToHumidHigh = oneToTwo(almanack, false, 175, 183);
			ArrayList<Long> humids = findTwos(temps, tempToHumidLow, tempToHumidHigh);
			
			ArrayList<LinkedList<Long>> humidToLocLow = oneToTwo(almanack, true, 185, 201);
			ArrayList<LinkedList<Long>> humidToLocHigh = oneToTwo(almanack, false, 185, 201);
			ArrayList<Long> locs = findTwos(humids, humidToLocLow, humidToLocHigh);
			
			
			//for (int i = 0; i < seeds.size(); i++) {
			//	System.out.println(Long.toString(seeds.get(i)));
			//}
			fileScanner.close();
			return locs;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Error");
		return null;
	}


	private static ArrayList<Long> findTwos(ArrayList<Long> ones, ArrayList<LinkedList<Long>> oneToTwoLow,
			ArrayList<LinkedList<Long>> oneToTwoHigh) {
		ArrayList<Long> twos = new ArrayList<Long>();
		boolean found = false;
		for (int i = 0; i < ones.size(); i++) {
			for (int k = 0; k < oneToTwoLow.size(); k++) {
				if (ones.get(i) >= oneToTwoLow.get(k).getFirst() && ones.get(i) < oneToTwoHigh.get(k).getFirst()) {
					twos.add(findTwo(ones.get(i), oneToTwoLow.get(k)));
					found = true;
				}
			}
			if (!found) {
				twos.add(ones.get(i));
			}
			found = false;
		}
		
		
		return twos;
	}

	private static Long findTwo(Long ones, LinkedList<Long> rangeLow) {
		long difference = ones - rangeLow.getFirst();
		long Two = rangeLow.getLast() + difference;
		return Two;
	}

	private static ArrayList<Long> findSeeds(ArrayList<String> almanack) {
		ArrayList<Long> seeds = new ArrayList<Long>();
		@SuppressWarnings("resource")
		Scanner lineScanner = new Scanner(almanack.get(0)).useDelimiter(" ");
		lineScanner.next();
		while (lineScanner.hasNext()) {
			seeds.add(Long.parseLong(lineScanner.next()));
		}
		lineScanner.close();
		return seeds;
	}
	
	private static ArrayList<LinkedList<Long>> oneToTwo(ArrayList<String> almanack, boolean first, int lower, int upper) {
		ArrayList<LinkedList<Long>> seedToSoil = new ArrayList<LinkedList<Long>>();
		long temp1 = 0;
		long temp2 = 0;
		long range = 0;
		for (int i = lower; i < upper; i++) {
			Scanner lineScanner = new Scanner(almanack.get(i)).useDelimiter(" ");
			LinkedList<Long> sTS = new LinkedList<Long>();
			if (first == true) {
				sTS.add(Long.parseLong(lineScanner.next()));
				sTS.addFirst(Long.parseLong(lineScanner.next()));
			} else {
				temp1 = Long.parseLong(lineScanner.next());
				temp2 = Long.parseLong(lineScanner.next());
				range = Long.parseLong(lineScanner.next());
				sTS.add(temp2 + range - 1);
				sTS.add(temp1 + range - 1);
				}
			seedToSoil.add(sTS);
			lineScanner.close();
		}
		
		
		return seedToSoil;
	}

	public static long findLowest(ArrayList<Long> soils) {
		long lowest = soils.get(0); 
		for (int i = 1; i < soils.size(); i++) {
			if (lowest > soils.get(i)) {
				lowest = soils.get(i);
			}
		}
		return lowest;
	}

	public static Long findLocationsAdvanced() {
		ArrayList<String> almanack = new ArrayList<String>();
		File file = new File("C:\\Users\\matti\\eclipse-workspace\\AdventOfCode2023\\src\\day5\\InputDay5");
		try {
			Scanner fileScanner = new Scanner(file).useDelimiter("\\n");
			while (fileScanner.hasNext()) {
				almanack.add(fileScanner.next().replaceAll("\r", ""));
			}
			ArrayList<Long> seeds = findSeeds(almanack);
			long start = seeds.get(0);
			long end = seeds.get(1);
			long seed = 0;
			long lowest = 2037529854;
			long tempLowest = 0;
			for (long k = start; k < start+end; k++) {
				seed = start+k;
				ArrayList<LinkedList<Long>> seedToSoilLow = oneToTwo(almanack, true, 3, 9);
				ArrayList<LinkedList<Long>> seedToSoilHigh = oneToTwo(almanack, false, 3, 9);
				ArrayList<Long> soils = findTwosAdvanced(seed, seedToSoilLow, seedToSoilHigh);
				
				ArrayList<LinkedList<Long>> soilToFertLow = oneToTwo(almanack, true, 11, 54);
				ArrayList<LinkedList<Long>> soilToFertHigh = oneToTwo(almanack, false, 11, 54);
				ArrayList<Long> ferts = findTwos(soils, soilToFertLow, soilToFertHigh);
				
				ArrayList<LinkedList<Long>> fertToWaterLow = oneToTwo(almanack, true, 56, 95);
				ArrayList<LinkedList<Long>> fertToWaterHigh = oneToTwo(almanack, false, 56, 95);
				ArrayList<Long> waters = findTwos(ferts, fertToWaterLow, fertToWaterHigh);
				
				ArrayList<LinkedList<Long>> waterToLightLow = oneToTwo(almanack, true, 97, 144);
				ArrayList<LinkedList<Long>> waterToLightHigh = oneToTwo(almanack, false, 97, 144);
				ArrayList<Long> lights = findTwos(waters, waterToLightLow, waterToLightHigh);
				
				ArrayList<LinkedList<Long>> lightToTempLow = oneToTwo(almanack, true, 146, 173);
				ArrayList<LinkedList<Long>> lightToTempHigh = oneToTwo(almanack, false, 146, 173);
				ArrayList<Long> temps = findTwos(lights, lightToTempLow, lightToTempHigh);
				
				ArrayList<LinkedList<Long>> tempToHumidLow = oneToTwo(almanack, true, 175, 183);
				ArrayList<LinkedList<Long>> tempToHumidHigh = oneToTwo(almanack, false, 175, 183);
				ArrayList<Long> humids = findTwos(temps, tempToHumidLow, tempToHumidHigh);
				
				ArrayList<LinkedList<Long>> humidToLocLow = oneToTwo(almanack, true, 185, 201);
				ArrayList<LinkedList<Long>> humidToLocHigh = oneToTwo(almanack, false, 185, 201);
				ArrayList<Long> locs = findTwos(humids, humidToLocLow, humidToLocHigh);
				
				
				//for (int i = 0; i < seeds.size(); i++) {
				//	System.out.println(Long.toString(seeds.get(i)));
				//}
				tempLowest = Tools.findLowest(locs);
				if (tempLowest < lowest) {
					lowest = tempLowest;
				}
			
			}
			fileScanner.close();
			return lowest;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Error");
		return null;
	}


	private static ArrayList<Long> findTwosAdvanced(long seed, ArrayList<LinkedList<Long>> oneToTwoLow,
			ArrayList<LinkedList<Long>> oneToTwoHigh) {
		ArrayList<Long> twos = new ArrayList<Long>();
		boolean found = false;
			for (int k = 0; k < oneToTwoLow.size(); k++) {
				if (seed >= oneToTwoLow.get(k).getFirst() && seed < oneToTwoHigh.get(k).getFirst()) {
					twos.add(findTwo(seed, oneToTwoLow.get(k)));
					found = true;
				}
			}
			if (!found) {
				twos.add(seed);
			}
		return null;
	}


	private static ArrayList<Long> findSeedsAdvanced(ArrayList<String> almanack) {
		ArrayList<Long> seeds = new ArrayList<Long>();
		@SuppressWarnings("resource")
		Scanner lineScanner = new Scanner(almanack.get(0)).useDelimiter(" ");
		lineScanner.next();
		while (lineScanner.hasNext()) {
			seeds.add(Long.parseLong(lineScanner.next()));
		}
		long start = seeds.get(0);
		long end = seeds.get(1);
		for (long k = start; k < start+end; k++) {
			seeds.add(start+k);
		}
		lineScanner.close();
		return seeds;
	}

}
