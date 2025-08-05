package com.baek_11399;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(people);
        int totalWaitTime = 0;

        for(int i = 0; i < N; i++){
            totalWaitTime += people[i] * (N - i);
        }

        System.out.println(totalWaitTime);
    }
}