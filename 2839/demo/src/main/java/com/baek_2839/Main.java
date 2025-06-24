package com.baek_2839;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

/// 그리디로 solved
/* 
public class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());

       int min_bag = -1;

       //5kg이 가능한 수 부터 찾기
       for(int i = N/5; i >= 0; i--){
        int remain = N - (i * 5);
        
        if (remain < 0) continue;
        
        if(remain % 3 == 0){
            min_bag = i + (remain / 3);
            break;
        }
       } 

       System.out.println(min_bag);
    }
}
*/


/// DP로 풀어보기
public class Main{
    static int BigNum = 5001;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        
        int[] dp = new int[N+1];
        Arrays.fill(dp,BigNum);

        dp[0] = 0;

        for(int i = 3; i <= N; i++){
            if(dp[i - 3] != BigNum){
                dp[i] = Math.min(dp[i],dp[i-3]+1);
            }
        }


        for(int i = 5; i <= N; i++){
            if(dp[i - 5] != BigNum){
                dp[i] = Math.min(dp[i],dp[i-5]+1);
            }
        }
        
        if (dp[N] == BigNum) { 
            System.out.println(-1);
        } else { 
            System.out.println(dp[N]);
        }

    }
}