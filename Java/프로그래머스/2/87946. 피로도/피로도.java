

class Solution {
    boolean[] visited;
    int[][] dungeons;
    int answer = -1;
    
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.visited= new boolean[dungeons.length];
        
        dfs(k, 0);
        
        
        return this.answer;
    }
    
    public void dfs(int remainTired, int count){
        this.answer = Math.max(count, this.answer);
        
        for(int i = 0; i < this.dungeons.length; i++){
            if(!visited[i] && remainTired >= this.dungeons[i][0]){
                visited[i] = true;
                
                dfs(remainTired - this.dungeons[i][1], count + 1);
                
                visited[i] = false;
                    
            }
        }
    }
}