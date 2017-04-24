package iEEEXtreme;

/* Title: Goldbach Conjecture
 * Author: Harris R
 */

import java.util.Scanner;

public class Solution11
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please input an integer to find two prime numbers whose sum add up to it.");
    int input = scan.nextInt();
    if(input < 4)
    {
      System.out.println("Number must be greater than or equal to 4");
      return;
    }
    if(input%2 > 0)
    {
      System.out.println("Number must be even.");
      return;
    }
    long startTime = System.nanoTime();
    int[] primes = generatePrimes(input);    
    findPairs(input, primes);
    long endTime = System.nanoTime();
    System.out.println("\n This program took: " + (endTime-startTime) + " nanoseconds or " + ((endTime-startTime)*1e-9) + " seconds.");
  }

  private static int[] generatePrimes(int max)
  {
    boolean[] isComposite = new boolean[max + 1];
    for (int i = 2; i * i <= max; i++)
    {
      if (!isComposite [i])
      {
        for (int j = i; i * j <= max; j++)
        {
          isComposite [i*j] = true;
        }
      }
    }
    int numPrimes = 0;
    for (int i = 2; i <= max; i++)
    {
      if (!isComposite [i]) numPrimes++;
    }
    int [] primes = new int [numPrimes];
    int index = 0;
    for (int i = 2; i <= max; i++)
    {
      if (!isComposite [i]) primes [index++] = i;
    }
    return primes; 
  }

  private static void findPairs(int input, int[] primes)
  { 
    String primepairs = "";
    for(int i = 0; i < primes.length; i++)
    {
      for(int j = i; j < primes.length; j++)
      {
          int p = primes[i];
          int q = primes[j];
          if(p+q == input)
          {
              primepairs += "\n" + q + " + " + p + " = " + input;
          }
      }
      System.out.println("Program Completion: " + (((double)i/primes.length)*100) + "%");
    }
    System.out.println(primepairs);
  }
}