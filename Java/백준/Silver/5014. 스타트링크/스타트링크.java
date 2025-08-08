import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] moves = new int[2];
    static boolean[] visited = new boolean[1000001];
    static int[] cnt = new int[1000001]; 
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());
        int current = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        moves[0] = Integer.parseInt(st.nextToken());
        moves[1] = -Integer.parseInt(st.nextToken());


        //bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(current);
        visited[current] = true;

        boolean isFind = false;

        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now == goal){
                System.out.println(cnt[now]);
                isFind = true;
                break;
            }

            for(int move : moves){
                int next = now + move;
                if(next >=1 && next <= total && !visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                    cnt[next] = cnt[now] + 1;
                }
            }
        }
        if(!isFind){
            System.out.println("use the stairs");
        }
    }
}
