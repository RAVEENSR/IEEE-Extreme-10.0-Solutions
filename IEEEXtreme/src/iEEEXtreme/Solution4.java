package iEEEXtreme;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution4 {

	public static void main(String[] args) throws FileNotFoundException {

		int q = 0;

		ArrayList<Long> d = new ArrayList<>();
		ArrayList<Long> d2 = new ArrayList<>();

		// input file
		//File file1 = new File("input.txt");

		// default scanner
		// **CHANGE TO SYSTEM.IN WHEN SUBMITTING**
		Scanner sc = new Scanner(System.in);

		q = Integer.parseInt(sc.nextLine());

		String[] array = new String[q];

		int counter = 0;
		do {
			array[counter] = sc.nextLine();
			counter++;
		} while (sc.hasNextInt());

		String[] array2 = new String[counter];
		
		for (int j = 0; j < q; j++) {
			d.clear();
			d2.clear();
			array2 = array[j].split(" ");
			long n = Long.parseLong(array2[0]);
			long e = Long.parseLong(array2[1]);
			long f = Long.parseLong(array2[2]);

			if (n % 2 == 0) {
				for (long i = 1; i <= Math.sqrt(n); i++) {
					if (n % i == 0) {
						// System.out.println(i + ", ");
						d.add(i);
						if (i != n / i) {
							// System.out.println(n/i + ", ");
							d.add(n / i);
						}
					}
				}
			} else {
				for (long i = 1; i <= Math.sqrt(n); i = i + 2) {
					if (n % i == 0) {
						// System.out.println(i + ", ");
						d.add(i);
						if (i != n / i) {
							// System.out.println(n/i + ", ");
							d.add(n / i);
						}
					}
				}
			}
			long r = f * (f + 1) / 2 - e * (e + 1) / 2 + e;
			long addition = 0;
			// int u=0;
			// int v=0;
			/*
			 * for (int p=1;p<d.size();p++){ u=e/d.get(p); v=f/d.get(p);
			 * addition+=((d.get(p)*v*(v+1)/2) - (d.get(p)*u*(u+1)/2));
			 * System.out.println(d.get(p)); }
			 */
			for (long p = e; p < f + 1; p++) {
				d2.add(p);
			}
			for (long b = 0; b < d.size(); b++) {
				if (d2.size() == 0) {
					break;
				}
				if (d.get((int) b) == 1) {
					continue;
				}
				for (long h = 0; h < d2.size(); h++) {
					if (d2.get((int) h) % d.get((int) b) == 0) {
						addition += d2.get((int) h);
						// System.out.println(d2.get(h));
						d2.remove(h);
					}
				}
			}
			System.out.println((r - addition) % 1000000007);

		}
	}

}