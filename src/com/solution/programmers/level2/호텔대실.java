package com.solution.programmers.level2;

import java.util.*;
public class 호텔대실 {
    class Solution {
        public int solution(String[][] book_time) {
            int answer = 0;

            Arrays.sort(book_time, (x, y) -> x[0].compareTo(y[0]));
            PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);

            for(int i=0; i<book_time.length; i++) {
                String[] str1 = book_time[i][0].split(":");
                String[] str2 = book_time[i][1].split(":");

                int start = Integer.parseInt(str1[0])*100+Integer.parseInt(str1[1]);
                int end = Integer.parseInt(str2[0])*100+Integer.parseInt(str2[1]);

                end += 10;

                if (end % 100 >= 60) {
                    end += 40;
                }

                if(pq.isEmpty()) {
                    answer++;
                    pq.offer(new int[]{start, end});
                    continue;
                }

                int[] prev = pq.poll();
                int pStart = prev[0];
                int pEnd = prev[1];

                if(start >= pEnd) {
                    pq.offer(new int[]{start, end});
                } else {
                    pq.add(prev);
                    answer++;
                    pq.offer(new int[]{start, end});
                }
            }

            return answer;
        }
    }
}
