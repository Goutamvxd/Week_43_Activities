package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 
Ronny's confidence level (C) is 0. You have a series of K exercises each of which increases Ronny's confidence by P[K] units (where P[K] is a set of K prime numbers, [2, 3, 5, 7, .... ]),respectively
Ronny practices exactly 1 exercise each day. The same exercise can be practiced over
and over again. 
Find the minimum number of days it will take for his confidence level to reach exactly to D.

Input Specification:
input1: D, final confidence level.
input2: K, the total different number of exercises.

Output Specification:
Your function should return the minimum number of days required to achieve the target. if not possible. output -1

Example 1:
input1: 12
input2: 5
output: 2
Explanation: now since k is 5 therefore p[k]={2,3,5,7,11}
exercise of p[k] value 5 and 7 will chosen to reach exactly 12 
 */

public class RonnyConfidence {
	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int D ,K;
        D= sc.nextInt();
        K= sc.nextInt();
        Integer[] dp = new Integer[1000];
        Arrays.fill(dp,new Integer(-1));
        List<Integer>  DP = Arrays.asList(dp);
        ArrayList<Integer>  P = new ArrayList<>();
        int i=2,k=0;
        while(k < K){
            if(isPrime(i)){
                P.add(i);
                k++;
            }
            i++;
        }
       System.out.println(calculateConfidence(D,P,DP));
     }
    static final int INT_MAX = Integer.MAX_VALUE;
    static int calculateConfidence(int D, ArrayList<Integer> P, List<Integer> dp)
    {
        if(D==0) return 0;
        if(D<0) return INT_MAX;        
        if(dp.get(D) != -1)
            return dp.get(D);
        dp.set(D,INT_MAX);
        for(int i=0;i<P.size()-1;i++)
        {
            int current = calculateConfidence(D-P.get(i),P,dp);            
            if(current == INT_MAX) continue;            
            dp.set(D,Math.min(dp.get(D),current+1));            
        }        
        return dp.get(D);
    }
    static boolean isPrime(int n){        
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;      
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;      
        return true;
    }
}