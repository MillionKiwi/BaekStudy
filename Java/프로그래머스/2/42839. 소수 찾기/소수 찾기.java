import java.util.*;
import java.io.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    boolean[] visited;
    char[] numberChars;
    
    
    public int solution(String numbers) {
        this.numberChars = numbers.toCharArray();
        this.visited = new boolean[this.numberChars.length];
        
        for(int i = 1; i <= this.numberChars.length; i++){
            dfs("",i);
        }
        
        int answer = 0;
        
        for(int n: this.set){
            if(isPrime(n)){
                answer++;
            }
        }
        
        
        return answer;
    }
    
    public void dfs(String current, int length){
        if(current.length() == length){
            this.set.add(Integer.parseInt(current));
            return;
        }
        
        for(int i = 0; i < this.numberChars.length; i++){
            if(!this.visited[i]){
                this.visited[i] = true;
                dfs(current + this.numberChars[i],length);
                this.visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n){
        if(n == 1 || n == 0) return false;
        
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        
        return true;
    }
}