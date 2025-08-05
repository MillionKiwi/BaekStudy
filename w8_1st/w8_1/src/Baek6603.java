import java.io.*;
import java.util.*;

public class Baek6603 {
    static int nums[];
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            String line = br.readLine();
            if(line.equals("0"))    break;
            
            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());

            nums = new int[k];

            for(int i = 0; i < k; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int[] ans = new int[6];

            dfs(ans, 0, 0);

            System.out.println(" ");
        }   
    }

    public static void dfs(int[] ans, int start, int level){
        if(level == 6){
            for(int i = 0; i < 6; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println("");
            return;
        }
        for(int i = start; i < k; i++){
            ans[level] = nums[i];
            dfs(ans, i + 1, level + 1);
        }
    }
}
