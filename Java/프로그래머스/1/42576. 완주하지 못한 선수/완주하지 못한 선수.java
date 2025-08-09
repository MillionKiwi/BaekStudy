import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> member = new HashMap<>();
        
        for(String person : participant){
            member.put(person, member.getOrDefault(person,0) + 1);
        }
        
        for(String person : completion){
            member.replace(person, member.get(person) - 1);
        }
        
        for(String key : member.keySet()){
            if(member.get(key) == 1)    answer = key;
        }
        
        return answer;
    }
}