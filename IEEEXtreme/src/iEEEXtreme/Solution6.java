package iEEEXtreme;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution6{
    private FastScanner inside;
    private PrintWriter outside;
    ArrayList<values> array = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution3. */

        new Solution6().solve();
    }


    public void solve() throws IOException {
    	inside = new FastScanner();
    	outside = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        
        outside.close();
    }

    private void readData() throws IOException {
        long numberOfTests = inside.nextInt();


        for (int x = 0; x < numberOfTests; x++) {


            int number = inside.nextInt();
            for (int y = 0; y < number; y++) {
            	array.add(new values(inside.nextInt(), 0));
            }

            solving();

            array.clear();

        }

    }

    class values {
        int value;
        int nextOccurance = 0;

        public values(int value, int nextOccurance) {
            this.nextOccurance = nextOccurance;
            this.value = value;
        }
    }

    void solving() {

        int brush1counter = 0;
        ArrayList<values> brush1 = new ArrayList<>();
        ArrayList<values> brush2 = new ArrayList<>();
        int brush1counter2 = 0;

        for (int x = 0; x < array.size(); x++) {
            for (int y = x + 1; y < array.size(); y++) {
                if (array.get(y).value == array.get(x).value) {
                	array.get(x).nextOccurance = y - x + 1;
                    break;
                }
            }
        }

        for (values bg : array) {
            //System.out.println(bg.value + " " + bg.nextOccurance);
        }

        for (int d = 0; d < array.size(); d++) {
            //System.out.println(arr.get(d).value + " Values are " + brush1counter + " " + brush1counter2);

            if (brush1counter == 1) {
                brush1.add(array.get(d));
                brush1counter = array.get(d).nextOccurance;
            } else if (brush1counter2 == 1) {
                brush2.add(array.get(d));
                brush1counter2 = array.get(d).nextOccurance;
            } else if (brush1counter == 0) {
                brush1.add(array.get(d));
                brush1counter = array.get(d).nextOccurance;
            } else if (brush1counter2 == 0) {
                brush2.add(array.get(d));
                brush1counter2 = array.get(d).nextOccurance;
            }else if (brush1counter2 >= brush1counter) {
                brush2.add(array.get(d));
                brush1counter2 = array.get(d).nextOccurance;
            } else {
                brush1.add(array.get(d));
                brush1counter = array.get(d).nextOccurance;
            }

            if (brush1counter > 0) {
                brush1counter--;
            }

            if (brush1counter2 > 0) {
                brush1counter2--;
            }
        }


        int count =0;
        int countVal = -1;

        for(values vf: brush1){
            if(vf.value!=countVal){
                count++;
            }
            countVal=vf.value;
        }

        countVal=-1;

        for(values vf: brush2){
            if(vf.value!=countVal){
                count++;
            }
            countVal=vf.value;
        }

        System.out.println(count);

        brush1.clear();
        brush2.clear();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}