package com.baek_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Paper{
        public int priority;
        public int index;

        public Paper(int priority, int index){
            this.priority = priority;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for(int t= 0; t< T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<Paper> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                queue.add(new Paper(Integer.parseInt(st.nextToken()), i));
            }

            int printCount = 0;

            //queue가 빌 때까지 출력
            while(!queue.isEmpty()){
                Paper nowPaper = queue.poll();
                boolean isPrintable = true;

                for(Paper p : queue){
                    if(nowPaper.priority < p.priority){
                        isPrintable = false;
                        break;
                    }
                }

                if(isPrintable){
                    printCount++;   //인쇄 확정
                    if(nowPaper.index == M) 
                        break;
                }
                else
                    queue.add(nowPaper);
            }

            System.out.println(printCount);
            
        }
    }
}