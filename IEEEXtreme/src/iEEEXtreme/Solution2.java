package iEEEXtreme;



import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Solution2{

	public static void main(String[] args) {

		ArrayList<Long> array = new ArrayList<>();

		Scanner dis = new Scanner(System.in);
		double madhuL, madhuLone, varLat, varLon;
		String line;
		String[] lineVector, newVec;
		int last = 0;

		line = dis.nextLine(); // read 1,2,3

		// separate all values by comma
		lineVector = line.split(",");

		// parsing the values to Integer
		madhuL = Double.parseDouble(lineVector[0]);
		madhuLone = Double.parseDouble(lineVector[1]);

		double range = dis.nextDouble();

		dis.nextLine();
		dis.nextLine();

		while (dis.hasNext()) {
			String test = dis.nextLine();

			newVec = test.split(",");

			String dateTime = newVec[0];
			varLat = Double.parseDouble(newVec[1]);
			varLon = Double.parseDouble(newVec[2]);
			long telNum = Long.parseLong(newVec[3]);

			/*
			 * System.out.println("Fixed Lat "+madhuLat+" "+"Fixed Lo "
			 * +madhuLon+" "+"Range "+range); System.out.println("Date and Time"
			 * +dateTime); System.out.println("Var lat"+varLat+"Var Lon"
			 * +varLon); System.out.println("Tel num "+telNum);
			 */

			// TODO Auto-generated method stub
			final double R = 6378.137; // Radius of the earth
			/*
			 * Double lat1 = 18.9778972; Double lon1 = 72.8321983; Double lat2 =
			 * 18.9811929; Double lon2 = 72.8353202;
			 */
			Double latDistance = toRad(madhuL - varLat);
			Double lonDistance = toRad(madhuLone - varLon);
			Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(toRad(madhuL))
					* Math.cos(toRad(varLat)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
			Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
			Double distance = R * c;
			
			boolean retval = array.contains(telNum);
			if (distance < range && !retval) {
				array.add(telNum);

			}

			// System.out.println("The distance between two lat and long is::" +
			// distance);

		}
		int count=0;

		Collections.sort(array);
		for (long i : array) {
			System.out.print(i);
			count++;
			if(count != array.size()){
				System.out.print(",");
			}
		}
	}

	private static Double toRad(Double value) {
		return value * Math.PI / 180;

	}

}