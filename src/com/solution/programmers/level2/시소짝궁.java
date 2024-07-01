package com.solution.programmers.level2;

import java.util.*;
public class 시소짝궁 {
    class Solution {
        long answer = 0;
        public long solution(int[] weights) {
            Arrays.sort(weights);
            Map<Double, Integer> map = new HashMap<>();
            for(int w : weights) {
                double n1 = w*1.0;
                double n2 = w*2.0/3.0;
                double n3 = w*2.0/4.0;
                double n4 = w*3.0/4.0;

                if(map.containsKey(n1)) {
                    answer+=map.get(n1);
                }
                if(map.containsKey(n2)) {
                    answer+=map.get(n2);
                }
                if(map.containsKey(n3)) {
                    answer+=map.get(n3);
                }
                if(map.containsKey(n4)) {
                    answer+=map.get(n4);
                }
                map.put(w*1.0, map.getOrDefault(w*1.0, 0)+1);
            }

            return answer;
        }
    }
}
