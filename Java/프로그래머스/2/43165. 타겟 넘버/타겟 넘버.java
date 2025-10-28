import java.util.*;
import java.io.*;

class Solution {
    int[] numbers;
    int target;
    int answer;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        this.answer = 0;
        
        dfs(0,0);
        
        return this.answer;
    }
    
    private void dfs(int index, int currentSum){
        if(index == this.numbers.length){
            if(currentSum == target) this.answer++;
            return;
        }
        // +인 경우
        dfs(index + 1,currentSum + this.numbers[index]);
        // - 인 경우
         dfs(index + 1,currentSum - this.numbers[index]);
    }
}