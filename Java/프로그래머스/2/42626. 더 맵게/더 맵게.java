import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        
        while(pq.peek() < K){
            if(pq.size() < 2) return -1;
            
            int firstFood = pq.poll();
            int secondFood = pq.poll();
            int newFood = firstFood + 2*secondFood;
            
            pq.add(newFood);
            answer++;
        }
        
        return answer;
    }
}