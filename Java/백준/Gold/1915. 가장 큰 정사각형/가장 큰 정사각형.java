import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][m];
        int maxLength = 0; 

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                dp[i][j] = line.charAt(j) - '0';

                if (dp[i][j] == 1 && i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                
                if (dp[i][j] > maxLength) {
                    maxLength = dp[i][j];
                }
            }
        }

        System.out.println(maxLength * maxLength);
    }
}