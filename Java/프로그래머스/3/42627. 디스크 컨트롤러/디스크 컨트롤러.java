import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        int totalWaitTime = 0;
        int totalJobCount = jobs.length;
        int completeCount = 0;
        int currentTime = 0;
        int jobIndex = 0;
        
        while(completeCount < totalJobCount){
            
            // 현재 이전 작업들 추가
            while(jobIndex < totalJobCount && jobs[jobIndex][0] <= currentTime){
                pq.add(jobs[jobIndex]);
                jobIndex++;
            }
            
            // 작업 처리
            if(!pq.isEmpty()){
                int[] currentJob = pq.poll();
                int requestTime = currentJob[0];
                int processTime = currentJob[1];
                
                currentTime += processTime;
                totalWaitTime += (currentTime - requestTime);
                
                completeCount++;
            }
            // 대기 시간 
            else if(completeCount < totalJobCount){
                currentTime = jobs[jobIndex][0];
            }
            
        }
        
        
        return (int)totalWaitTime/totalJobCount;
    }
}