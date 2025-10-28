import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>tree[];
    static boolean visited[];
    static int A_list[], B_list[];
    static int n, max, max_idx;

    static class Node{
        int idx, cnt;
        Node(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        tree = new ArrayList[n+1];

        
        for(int i=0; i<=n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++) {
            String [] t = br.readLine().split(" ");
            int parent = Integer.parseInt(t[0]);
            int child = Integer.parseInt(t[1]);
            int weight = Integer.parseInt(t[2]);
            tree[parent].add(new Node(child,weight));
            tree[child].add(new Node(parent,weight));
        }
        
        visited = new boolean[n+1];
        A_list = new int[n+1];
        B_list = new int[n+1];


        // 1. 임의의 노드(1)에서 가장 먼 노드(A)를 찾음 (turn=0)
        max = -1; // max 초기화 
        visited[1] = true;
        dfs(1,0,0); 
        int nodeA = max_idx; // A 저장
        
        // 2. 노드 A에서 가장 먼 노드(B)를 찾으면서 A까지의 거리를 A_list에 저장 (turn=1)
        max = -1; // max 초기화 
        visited = new boolean[n+1];
        visited[nodeA] = true;
        dfs(nodeA,0,1);
        int nodeB = max_idx; // B 저장
        
        // 3. 노드 B에서 각 노드까지의 거리를 B_list에 저장 (turn=2)
        max = -1; // max 초기화 
        visited = new boolean[n+1];
        visited[nodeB] = true;
        dfs(nodeB,0,2);

        for(int i = 1; i < n + 1; i++){
            System.out.println(Math.max(A_list[i],B_list[i]));
        }

    }

    public static void dfs(int idx, int cnt, int turn){
        if(max < cnt){
            max = cnt;
            max_idx = idx;
        }

        if(turn == 1){
            A_list[idx] = cnt;
        }

        if(turn == 2){
            B_list[idx] = cnt;
        }

        for(Node n:tree[idx]){
            if(!visited[n.idx]){
                visited[n.idx] = true;
                dfs(n.idx, cnt + n.cnt, turn);
            }
        }

    }

}
