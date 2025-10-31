import java.util.*;

class Solution {
    char[] alphabets = {'A','E','I','O','U'};
    List<String> words = new ArrayList<>();
    public int solution(String solution) {
        int answer = 0;
        
        dfs("");
        
        for(String key: words){
            if(key.equals(solution)) break;
            answer++;
        }
        
        return answer;
    }
    
    private void dfs(String currentString){
        words.add(currentString);
        
        if(currentString.length() >= 5) return;
        
        for(int i = 0; i < 5; i++){
            dfs(currentString + alphabets[i]);
        }
    }
}