package day6;

public class RunDay6 {

	public static long runner(long dist, long time) {
		long numOfTimes = 0;
		
		for (long i = 0; i < time; i++) {
			if (i*(time-i) > dist ) {
				numOfTimes = numOfTimes + 1;
			}
		}
		return numOfTimes;
	}
	
	public static void main(String[] args) {
		long ans = runner(308,42)*runner(1170,89)*runner(1291,91)*runner(1467,89);
		System.out.println(Long.toString(ans));
		
		long dist = Long.parseLong("308117012911467");
		long ans2 = runner(dist, 42899189);
		System.out.println(Long.toString(ans2));
	}
}
