package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3040 {
    static int sum = 0;
    static int[] nums = new int[9];
    static boolean[] visited = new boolean[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }

        com(0, 0, new int[2]);


    }
    public static void com(int x, int d, int[] temp) {
        if(d==2) {
            if(sum - temp[0] - temp[1] == 100) {
                for(int i=0; i<9; i++) {
                    if(nums[i] == temp[0] || nums[i] == temp[1]) {
                        continue;
                    }
                    System.out.println(nums[i]+" ");
                }
                System.exit(-1);
            }
            return;
        }

        for(int i=x; i<9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[d] = nums[i];
                com(i+1, d+1, temp);
                visited[i] = false;
            }
        }
    }
}
