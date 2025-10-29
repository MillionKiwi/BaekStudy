import java.util.*;
import java.io.*;

class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int[][] visitable;
    int[][] maps;
    
    public int solution(int[][] maps) {
        int answer = 0;
        this.visitable = maps;
        this.maps = maps;
        
        answer = bfs(0,0);
        
        
        return answer;
    }
    
    private int bfs(int x, int y){
        int rows = this.maps.length;
        int cols = this.maps[0].length;
        
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x,y});
        
        this.visitable[x][y] = 0;
        this.maps[x][y] = 1;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currX = current[0];
            int currY = current[1];
            
            for(int i = 0; i < 4; i++){
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];
                
                if(nextX < 0 || nextX >= rows ||
                    nextY < 0 || nextY >= cols ){
                    continue;
                }
                
                if(this.maps[nextX][nextY] == 1 && visitable[nextX][nextY] == 1){
                    queue.offer(new int[]{nextX,nextY});
                    this.visitable[nextX][nextY] = 0;
                    
                    this.maps[nextX][nextY] = this.maps[currX][currY] + 1;
                }
            }
        }
        
        if(this.visitable[rows - 1][cols - 1] == 1) return -1;
        
        return this.maps[rows - 1][cols - 1];
    }
}