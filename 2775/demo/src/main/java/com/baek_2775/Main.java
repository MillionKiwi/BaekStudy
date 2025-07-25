package com.baek_2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] people = new int[15][15];

        for (int j = 0; j < 15; j++){
            people[0][j] = j;
        }

        for(int i = 1; i < 15; i++){
            for(int j = 1; j < 15; j++){
                people[i][j] = people[i-1][j] + people[i][j-1];
            }
        }

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(people[k][n]);
        }
    }
}