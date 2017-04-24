package iEEEXtreme;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution8 {

	public static void main(String[] args) throws FileNotFoundException {

		File file1 = new File("input.txt");
		Scanner sc = new Scanner(file1);

		String str = sc.nextLine();
		String[] splited = str.split("\\s+");

		int base = Integer.parseInt(splited[0]);
		String characterWord = splited[1];

		String[][] strArr = new String[base][2];

		for (int i = 0; i < base; i++) {
			char c = characterWord.charAt(i);
			strArr[i][0] = Character.toString(c);
			strArr[i][1] = String.valueOf(i);

		}

		String statement1 = sc.nextLine();
		String statement2 = sc.nextLine();

		String dotLine = sc.nextLine();

		// Output
		System.out.println(str);
		System.out.println(statement1);
		System.out.println(statement2);
		System.out.println(dotLine);

		int stmntLength1 = statement1.length();
		int stmntLength2 = statement2.length();

		String[][] stmntArr1 = new String[stmntLength1][2];
		String[][] stmntArr2 = new String[stmntLength2][2];

		for (int i = 0; i < stmntLength1; i++) {
			char c1 = statement1.charAt(i);
			stmntArr1[i][0] = Character.toString(c1);
			for (int j = 0; j < strArr.length; j++) {

				if (stmntArr1[i][0].equals(strArr[j][0])) {
					stmntArr1[i][1] = strArr[j][1];
					System.out.println(stmntArr1[i][0]);
					System.out.println(stmntArr1[i][1]);
				}
			}

		}

		for (int i = 0; i < stmntLength2; i++) {
			char c2 = statement2.charAt(i);
			stmntArr2[i][0] = Character.toString(c2);

			for (int j = 0; j < strArr.length; j++) {
				if (stmntArr2[i][0].equals(strArr[j][0])) {
					stmntArr2[i][1] = strArr[j][1];
					System.out.println(stmntArr2[i][0]);
					System.out.println(stmntArr2[i][1]);
				}
			}

		}
		System.out.println(stmntArr2.length);
		System.out.println(stmntArr1.length);
		System.out.println(stmntLength1);
		System.out.println(stmntLength2);

		int[] sumArray;
		int temp = 0;
		if (stmntLength1 > stmntLength2) {
			sumArray = new int[stmntLength1 + 1];

			for (int k = 0; k < stmntLength1; k++) {
				if (stmntArr1[stmntLength1 - k][1] != null && stmntArr2[stmntLength1 - k][1] != null) {

					temp = Integer.parseInt(stmntArr1[stmntLength1 - k][1])
							+ Integer.parseInt(stmntArr2[stmntLength1 - k][1]);

				} else if (stmntArr1[stmntLength1 - k][1] == null && stmntArr2[stmntLength1 - k][1] == null) {
					temp = 0;
				} else if (stmntArr1[stmntLength1 - k][1] == null) {
					temp = Integer.parseInt(stmntArr2[stmntLength1 - k][1]);
				} else {
					temp = Integer.parseInt(stmntArr1[stmntLength1 - k][1]);
				}

				if (temp > base) {
					temp = temp - base;
					sumArray[stmntLength1 - k - 1] = sumArray[stmntLength1 - k - 1] + temp;

					sumArray[stmntLength1 - k] = sumArray[stmntLength1 - k] + 1;
				} else {
					sumArray[stmntLength1 - k] = temp + sumArray[stmntLength1 - k];
				}

			}

		} else {
			sumArray = new int[stmntLength2 + 1];

			for (int k = 1; k < stmntLength2; k++) {
				if (stmntArr1[stmntLength2 - k][1] != null && stmntArr2[stmntLength2 - k][1] != null) {

					temp = Integer.parseInt(stmntArr1[stmntLength2 - k][1])
							+ Integer.parseInt(stmntArr2[stmntLength2 - k][1]);

				} else if (stmntArr1[stmntLength2 - k][1] == null && stmntArr2[stmntLength2 - k][1] == null) {
					temp = 0;
				} else if (stmntArr1[stmntLength2 - k][1] == null) {
					temp = Integer.parseInt(stmntArr2[stmntLength2 - k][1]);
				} else {
					temp = Integer.parseInt(stmntArr1[stmntLength2 - k][1]);
				}

				if (temp > base) {
					temp = temp - base;
					sumArray[stmntLength2 - k - 1] = sumArray[stmntLength2 - k - 1] + temp;

					sumArray[stmntLength2 - k] = sumArray[stmntLength2 - k] + 1;
				} else {
					sumArray[stmntLength2 - k] = temp + sumArray[stmntLength2 - k];
				}

			}

		}


		
		 String[] lastArray = new String[sumArray.length];
		  
		 for (int m = 0; m < sumArray.length; m++) { for (int r = 0; r <
		 strArr.length; r++) { if (strArr[r][0].equals(sumArray[m])) {
		lastArray[m] = strArr[m][0]; } else { } }
		  
		  }
		  
		  System.out.println(str); System.out.println(statement1);
		  System.out.println(statement2); System.out.println(dotLine); for (int
		  n = 0; n < lastArray.length; n++) { System.out.print(lastArray[n]); }
		 
	}

}
