package com.baek_1759;
import java.io.*;
import java.util.*;

public class Main {
    static int L,C;
    static char[] code, alphabets;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        code = new char[L];
        alphabets = new char[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            alphabets[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabets);

        dfs(0,0);

    }
    public static void dfs(int start, int depth){
        if(depth == L){
            if(isValid(code))
                System.out.println(code);
            return;
        }

        for(int i = start; i < C; i++){
            code[depth] = alphabets[i];
            dfs(i+1, depth+1);
        }
    }
    public static boolean isValid(char[] code){
        int mCount = 0;
        int sCount = 0;
        for(char c : code){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                mCount++;
            }
            else sCount++;
        }

        if(mCount >= 1 && sCount >=2)
            return true;
        return false;
    }
}