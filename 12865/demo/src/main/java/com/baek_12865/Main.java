package com.baek_12865;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];
        int[] values = new int[N + 1];
        int[] weights = new int[N + 1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
            
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                if(weights[i - 1] > j) dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j], values[i] + dp[i-1][j - weights[i]]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}