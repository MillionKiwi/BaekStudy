package com.baek_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N; // N을 static 변수로 만들어 dfs에서 사용
    public static int[][] area;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException { // main 메서드에 throws IOException 추가
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        area = new int[N][N];
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, area[i][j]);
            }
        }

        // 최소 안전 영역은 1
        int maxArea = 1; 

        for (int h = 0; h < maxHeight; h++) {
            visited = new boolean[N][N];
            int areaCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (area[i][j] > h && !visited[i][j]) {
                        dfs(i, j, h);
                        areaCount++;
                    }
                }
            }
            maxArea = Math.max(maxArea, areaCount);
        }

        System.out.println(maxArea);
    }

    public static void dfs(int x, int y, int height) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배열 범위 확인
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (area[nx][ny] > height && !visited[nx][ny]) {
                    dfs(nx, ny, height);
                }
            }
        }
    }
}