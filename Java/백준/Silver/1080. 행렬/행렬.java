import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[][] matA;
    static int[][] matB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matA = new int[N][M];
        matB = new int[N][M];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                matA[i][j] = line.charAt(j) - '0';
            }
        }
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                matB[i][j] = line.charAt(j) - '0';
            }
        }

        if (N < 3 || M < 3) {
            if (areSame()) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            return;
        }

        int count = 0;
        // 3x3 뒤집기가 가능한 범위까지만 순회
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                // A와 B의 (i, j) 원소가 다르면 뒤집기 연산 수행
                if (matA[i][j] != matB[i][j]) {
                    flip(i, j);
                    count++;
                }
            }
        }

         // 모든 연산 후 두 행렬이 같은지 최종 확인
        if (areSame()) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

    // (x, y)를 시작점으로 3x3 행렬을 뒤집는 함수
    static void flip(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                matA[i][j] = 1 - matA[i][j];
            }
        }
    }

    // 두 행렬이 완전히 같은지 비교하는 함수
    static boolean areSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matA[i][j] != matB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
