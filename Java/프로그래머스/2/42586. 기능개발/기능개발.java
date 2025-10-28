import java.util.*;
import java.io.*;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> processQueue = new ArrayDeque<>();
        
        for(int i =0; i < progresses.length; i++){
            double remainDays = Math.ceil((100.0 - progresses[i]) / speeds[i]);
            processQueue.add((int) remainDays);
        }
        
        
        while(!processQueue.isEmpty()){
            int currentRemainDays = processQueue.poll();
            
            int finishedCount = 1;
            
            while(!processQueue.isEmpty() && 
                  processQueue.peek() <= currentRemainDays){
                
                processQueue.poll();
                finishedCount++;
            }
            
            answer.add(finishedCount);
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}