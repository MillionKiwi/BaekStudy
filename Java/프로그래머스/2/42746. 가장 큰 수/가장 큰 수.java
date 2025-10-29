import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strs = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            strs[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strs,(o1,o2) -> (o2 + o1).compareTo(o1 + o2));
        
        answer = String.join("",strs);
        
        if(answer.startsWith("0")) return "0";
        
        return answer;
    }
}