
import java.util.GregorianCalendar;

public class towers {

	// global count for moves
	public static long count;

	public static void main(String[] args) {

		int d = 7; // number of disks defaults to 7

		// use command line argument for number of disks if given ie. java towers 10
		if (args.length > 0)
			d = Integer.parseInt(args[0]);

		// count moves
		count = 0;

		// start time
		GregorianCalendar startTime = new GregorianCalendar();
		long start = startTime.getTimeInMillis();

		// call recursive towers function
		TOH(d, "A", "B", "Temp");

		// stop time
		GregorianCalendar stopTime = new GregorianCalendar();
		long stop = stopTime.getTimeInMillis();

		// calculate total seconds
		long diff = stop - start;
		double totalSeconds = (double) diff / (double) 1000;

		// calculate moves per second
		double mps = count / totalSeconds;

		System.out.println();
		System.out.printf("count %,d moves, ", count);
		System.out.println("numbr of disks = " + d + ", time = " + totalSeconds + " seconds");
		System.out.printf("%,.0f moves per second", mps);
		System.out.println();

	}

	private static void TOH(int n, String start, String goal, String temp) {

		if (n > 0) {
			TOH(n - 1, start, temp, goal);

			// note: comment out print for analysis
			// System.out.println( "Move disk from " + start + " to " + goal);

			count++; // global count

			TOH(n - 1, temp, goal, start);
		}

	}// towers

}// class
