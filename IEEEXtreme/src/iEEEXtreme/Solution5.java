package iEEEXtreme;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution5 {
	public static void main(String[] args) throws FileNotFoundException {
		File file1 = new File("input.txt");
		Scanner sc = new Scanner(System.in); //
		String word = sc.nextLine();

		String[] splited = word.split("\\s+");

		double c = Double.parseDouble(splited[0]);
		double h = Double.parseDouble(splited[1]);
		double o = Double.parseDouble(splited[2]);

		double water = ((2*o)+h-(4*c)) / 4;
		

		double co2 = ((2 * o) - h) / 4;

		double glucose = ((4*c)+h-(2*o)) / 24;
		System.out.println(water);
		System.out.println(co2);
		System.out.println(glucose);
		
		if (water % 1 == 0) {
			if (co2 % 1 == 0)  {
				if (glucose % 1 == 0)  {
					System.out.println((int)water+" "+(int)co2+" "+(int)glucose);
				} else {
					System.out.println("Error");
				}
			} else {
				System.out.println("Error");
			}

		} else {
			System.out.println("Error");
		}

	}
}
