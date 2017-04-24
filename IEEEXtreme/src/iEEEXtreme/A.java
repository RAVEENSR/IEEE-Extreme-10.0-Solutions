package iEEEXtreme;


import java.util.ArrayList;

public class A {
    static int N=2;
    static String [] array={"12 5 10","5 1 4"};
    static ArrayList<Integer> d = new ArrayList<> ();
    static ArrayList<Integer> d2 = new ArrayList<> ();
    public static void main(String[] args) {
        String [] array2=new String[3];
       for(int j=0;j<N;j++){
           d.clear();
           d2.clear();
           array2=array[j].split(" ");
           int n=Integer.parseInt(array2[0]);
           int e=Integer.parseInt(array2[1]);
           int f=Integer.parseInt(array2[2]);
           
            if(n % 2 == 0) {
                for(int i = 1; i <= Math.sqrt(n); i++) {
                    if(n % i == 0) {
                        //System.out.println(i + ", ");
                        d.add(i);
                        if(i != n/i) {
                            //System.out.println(n/i + ", ");
                            d.add(n/i);
                        }
                    }
                }
            }
            else {
                for(int i = 1; i <= Math.sqrt(n); i=i+2) {
                    if(n % i == 0) {
                        //System.out.println(i + ", ");
                        d.add(i);
                        if(i != n/i) {
                            //System.out.println(n/i + ", ");
                            d.add(n/i);
                        }
                    }
                }
            }
            int r=f*(f+1)/2 -e*(e+1)/2 +e;
            int addition=0;
            //int u=0;
            //int v=0;
             /*for (int p=1;p<d.size();p++){
                 u=e/d.get(p);
                 v=f/d.get(p);
                 addition+=((d.get(p)*v*(v+1)/2) - (d.get(p)*u*(u+1)/2));
                 System.out.println(d.get(p));
             }*/
            for (int p=e;p<f+1;p++){
                d2.add(p);
            }
            for(int b=0;b<d.size();b++){
                if(d2.size()==0){
                    break;
                }
                if(d.get(b)==1){
                    continue;
                }
                for (int h=0;h<d2.size();h++){
                    if(d2.get(h)%d.get(b)==0){
                        addition+=d2.get(h);
                        //System.out.println(d2.get(h));
                        d2.remove(h);
                    }
                }
            }
             System.out.println((r-addition)%1000000007);
               
       }
    }
    
}