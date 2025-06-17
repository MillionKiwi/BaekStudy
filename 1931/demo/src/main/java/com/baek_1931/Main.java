package com.baek_1931;
import java.util.*;
import java.io.*;


public class Main {
    static class Meeting{
        public int startTime;
        public int endTime;

        public Meeting(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Meeting[] meetings = new Meeting[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // --- endTime을 기준으로 오름차순 정렬 ---
        // Arrays.sort()와 람다 표현식을 사용한 Comparator
        // Integer.compare()는 두 정수를 비교하여 첫 번째가 작으면 음수, 같으면 0, 크면 양수를 반환합니다.
        Arrays.sort(meetings, (m1, m2) -> {
            if(m1.endTime == m2.endTime){
                return Integer.compare(m1.startTime, m2.startTime);
            }
            return Integer.compare(m1.endTime, m2.endTime);
        });

        Meeting current_Metting = meetings[0];
        int meetingNum = 1;

        for(int i = 1; i < N; i++){
            if(current_Metting.endTime <= meetings[i].startTime){
                meetingNum++;
                current_Metting = meetings[i];
            }
        }

        System.out.println(meetingNum);
    }
}