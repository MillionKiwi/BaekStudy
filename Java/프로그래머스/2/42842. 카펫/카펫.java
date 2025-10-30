import java.util.*;
import java.io.*;

class Solution {
    HashSet<Integer[]> sets = new HashSet<>();
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = 1; i*i <= yellow; i++){
            if(yellow % i == 0){
                Integer[] numberSet = {yellow / i, i};
                sets.add(numberSet);
            }
        }
        
        for(Integer[] set : sets){
            if(brown == 2 * (set[0] + set[1] + 2)){
                answer[0] = set[0] + 2;
                answer[1] = set[1] + 2;
                
                return answer;
            }
        }
        
        return null;
    }
}