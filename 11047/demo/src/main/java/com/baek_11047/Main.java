package com.baek_11047;
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];

        for(int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i = N - 1; i >= 0; i--){
            int value = K / coins[i];
            if(value > 0){
                count += value;
                K -= value * coins[i];
            }
        }

        System.out.println(count);
    }
}