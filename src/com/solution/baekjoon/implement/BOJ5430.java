package com.solution.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();

            String content = br.readLine();
            StringTokenizer st = new StringTokenizer(content.substring(1, content.length() - 1), ",");
            while (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean flag = true;
            boolean direction = true;
            for(char c : p.toCharArray()) {
                if (c=='R') {
                    direction = !direction;
                } else if (c=='D') {
                    if (deque.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if (direction) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }

            if (flag) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while(!deque.isEmpty()) {
                    sb.append(direction ? deque.pollFirst() : deque.pollLast());

                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");

                System.out.println(sb);
            } else {
                System.out.println("error");
            }
        }
    }
}
