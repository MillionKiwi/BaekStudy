import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> pokemons = new HashMap<>();
        
        for(int id : nums){
            pokemons.put(id, pokemons.getOrDefault(id,0) + 1);
        }
        
        if (pokemons.keySet().size() > nums.length / 2)
            answer = nums.length / 2;
        else
            answer = pokemons.keySet().size();
        return answer;
    }
}