package com.baek_3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    static int N;

    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        board = new char[N][N];

        // 입력 받기
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                board[i][j] = line.charAt(j);
            }
        }

        // 탐색
        int ans = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int d = 0; d < 2; d++){
                    int ni = i + dx[d];
                    int nj = j + dy[d];

                    if(ni < N && nj < N && board[i][j] != board[ni][nj]){
                        swap(i, j, ni, nj);
                        ans = Math.max(ans, getMax());
                        swap(i, j, ni, nj); // 원상복구
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static void swap(int x1, int y1, int x2, int y2){
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    public static int rowMax(int row){
        int max = 1;
        int cnt = 1;
        for(int i = 0; i < N - 1; i++){
            if(board[row][i] == board[row][i + 1]){
                cnt++;
            }
            else{
                cnt = 1;
            }
            max = Math.max(max,cnt);
        }

        return max;
    }

    public static int colMax(int col){
        int max = 1;
        int cnt = 1;
        for(int i = 0; i < N - 1; i++){
            if(board[i][col] == board[i + 1][col]){
                cnt++;
            }
            else{
                cnt = 1;
            }
            max = Math.max(max,cnt);
        }

        return max;
    }

    public static int getMax() {
        int max = 1;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, rowMax(i));
            max = Math.max(max, colMax(i));
        }
        return max;
    }
}