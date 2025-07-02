package com.baek_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static final int PATTERN_B_START = 0b10101010;
    public static final int PATTERN_W_START = 0b01010101;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = (line.charAt(j) == 'B') ? 1 : 0; // B: 1, W: 0
            }
        }

        int min = 64; // worst case

        for(int i = 0; i <= N - 8; i++){
            for(int j = 0; j <= M - 8; j++){
                min = Math.min(min,getPaintCount(board, i, j));
            }
        }

        System.out.println(min);
        br.close();
    }

    public static int getPaintCount(int[][] board, int startRow, int startCol){
        int bStartCount = 0;

        for (int i = 0; i < 8; i++){
            int rowValue = 0;
            for(int j = 0; j < 8; j++){
                //앞으로 8개의 배열에 대해 
                rowValue <<= 1;
                rowValue |= board[startRow + i][startCol + j];
            }

            //Xor 연산으로 비교
            if(i % 2 == 0){
                int xorResult = rowValue ^ PATTERN_B_START;
                bStartCount += Integer.bitCount(xorResult);
            }
            else{
                int xorResult = rowValue ^ PATTERN_W_START;
                bStartCount += Integer.bitCount(xorResult);
            }
        }

        return(Math.min(bStartCount, 64 - bStartCount));
    }
}