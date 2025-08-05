package com.back_15654;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int N_arr[];
    static int Ans_arr[];
    static boolean visited[];
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        N_arr = new int[N];
        Ans_arr = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            N_arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(N_arr);

        dfs(0);
    }

    static void dfs(int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(Ans_arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                Ans_arr[depth] = N_arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}