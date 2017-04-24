/*
package iEEEXtreme;

import java.util.ArrayList;

public class SolutionOne {
    
    //Set up O(1) lookup for max in interval (i, j).
    //Initialize memo table
	
	
	int n=0;
	int m=0;
    int [][] intervalmax=new int[n][n];
    int [][] memo=new int[m+1][n];
    int a[]=new int[n];
    
    void preprocess(int n,int m,int intervalmax[][],int memo [][])
    {
        int i, j;
        for(i=0; i<n; i++)
        {
            intervalmax[i][i]=a[i];
            for(j=i+1; j<n; j++)
            {
                intervalmax[i][j]=max(intervalmax[i][j-1], a[j]);
            }
        }
        for(i=1; i<=m; i++)
        {
            for(j=0; j<n; j++)
            {
                memo[i][j]=-1;
            }
        }
    }
    //a is the array, n is the size of the list, m is the number of partitions to be made
    int solution( int i, int n, int m)
    {
        if(memo[m][i]!=-1)
            return memo[m][i];
        if(m==1)
        {
            memo[m][i]=intervalmax[i][n-1];
            return memo[m][i];
        }
        int minresult=INT_MAX;
        for(int k=i; k<=n-m; k++)
        {
            minresult=min(minresult, intervalmax[i][k]+solution(a, k+1, n, m-1));
        }
        memo[m][i]=minresult;
        return memo[m][i];
    }
    
    public static void main(String []args){
    	
    	int n=0;
    	int m=0;
        int [][] intervalmax=new int[n][n];
        int [][] memo=new int[m+1][n];
    	
    }
}
*/