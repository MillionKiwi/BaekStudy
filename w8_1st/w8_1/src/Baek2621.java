import java.io.*;
import java.util.*;

public class Baek2621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] color = new int[5];
        int[] num = new int[5];
        Map<Character, Integer> colorMap = new HashMap<>();
        colorMap.put('R', 0);
        colorMap.put('B', 1);
        colorMap.put('Y', 2);
        colorMap.put('G', 3);

        int[] colorCnt = new int[4];
        int[] numCnt = new int[10];

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            char c = s.charAt(0);
            int n = Integer.parseInt(s.substring(1));
            color[i] = colorMap.get(c);
            num[i] = n;
            colorCnt[color[i]]++;
            numCnt[num[i]]++;
        }

        Arrays.sort(num);

        boolean isFlush = false;
        for (int cnt : colorCnt) {
            if (cnt == 5) isFlush = true;
        }

        boolean isStraight = false;
        int start = num[0];
        isStraight = true;
        for (int i = 1; i < 5; i++) {
            if (num[i] != start + i) {
                isStraight = false;
                break;
            }
        }

        int maxScore = 0;

        // 1. Straight Flush
        if (isFlush && isStraight) {
            maxScore = Math.max(maxScore, 900 + num[4]);
        }

        // 2. Four of a Kind
        for (int i = 1; i <= 9; i++) {
            if (numCnt[i] == 4) {
                maxScore = Math.max(maxScore, 800 + i);
            }
        }

        // 3. Full House
        int three = 0, two = 0;
        for (int i = 1; i <= 9; i++) {
            if (numCnt[i] == 3) three = i;
            if (numCnt[i] == 2) two = i;
        }
        if (three > 0 && two > 0) {
            maxScore = Math.max(maxScore, 700 + three * 10 + two);
        }

        // 4. Flush
        if (isFlush) {
            maxScore = Math.max(maxScore, 600 + num[4]);
        }

        // 5. Straight
        if (isStraight) {
            maxScore = Math.max(maxScore, 500 + num[4]);
        }

        // 6. Three of a Kind
        if (three > 0) {
            maxScore = Math.max(maxScore, 400 + three);
        }

        // 7. Two Pair
        int firstPair = 0, secondPair = 0;
        for (int i = 9; i >= 1; i--) {
            if (numCnt[i] == 2) {
                if (firstPair == 0) firstPair = i;
                else if (secondPair == 0) secondPair = i;
            }
        }
        if (firstPair > 0 && secondPair > 0) {
            int remain = 0;
            for (int i = 1; i <= 9; i++) {
                if (numCnt[i] == 1) remain = i;
            }
            maxScore = Math.max(maxScore, 300 + firstPair * 10 + secondPair + remain);
        }

        // 8. One Pair
        if (firstPair > 0) {
            int remain = 0;
            for (int i = 9; i >= 1; i--) {
                if (numCnt[i] == 1) {
                    remain = i;
                    break;
                }
            }
            maxScore = Math.max(maxScore, 200 + firstPair * 10 + remain);
        }

        // 9. High Card
        maxScore = Math.max(maxScore, 100 + num[4]);
        System.out.println(maxScore);
    }
}
