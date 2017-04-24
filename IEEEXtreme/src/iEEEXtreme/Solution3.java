package iEEEXtreme;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution3 {
	public static void main(String[] args) throws FileNotFoundException {
		// input file
		File file1 = new File("input.txt");

		// default scanner
		// **CHANGE TO SYSTEM.IN WHEN SUBMITTING**
		Scanner sc = new Scanner(file1);
		
		// colors are here
		ArrayList<Integer> colors = new ArrayList<Integer>();
		ArrayList<Integer> howFar = new ArrayList<Integer>();
		
		int n=0;

		int t=sc.nextInt();
		do{
			String line = sc.nextLine();
			int tempCount=0;
			for(String retVal : line.split(" ")){
				tempCount++;
			}
			
			if(tempCount==1){
				// clear everything
				colors.clear();
				
				
				// it's integer n
				n= Integer.parseInt(line);
			}else{
				// it's colors
				for(String retVal : line.split(" ")){
					colors.add(Integer.parseInt(retVal));
					howFar.add(0);
				}
				
				for(int i=0 ; i<colors.size() ; i++){
					int distance = 0;
					for(int j=0 ; j<colors.size(); j++){
						if(i<j){
							distance++;
							if(colors.get(j)==colors.get(i)){
								colors.set(i, distance);
							}
						}else{
							
						}
					}
				}
				for(Integer c : colors){
					System.out.println(c);
				}
				for(Integer r:howFar){
					System.out.println(r);
				}
			}
			
		}while(sc.hasNextLine());

	}
}