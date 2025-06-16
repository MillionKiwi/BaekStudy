package com.baek_2839;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());

       int min_bag = -1;

       //5kg이 가능한 수 부터 찾기
       for(int i = N/5; i >= 0; i--){
        int remain = N - (i * 5);
        
        if (remain < 0) continue;
        
        if(remain % 3 == 0){
            min_bag = i + (remain / 3);
            break;
        }
       } 

       System.out.println(min_bag);
    }
}