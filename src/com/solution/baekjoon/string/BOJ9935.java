package com.solution.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() >= bomb.length()) {
                int k = 0;
                boolean check = true;
                for (int j=bomb.length()-1; j>=0; j--) {
                    k++;
                    if (bomb.charAt(j) != stack.get(stack.size()-k)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        if(sb.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}
