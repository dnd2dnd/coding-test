package com.solution.programmers;

import java.util.*;

/**
 * 프로그래머스 Level 2, 구명보트
 */
public class 구명보트 {
    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;

            Arrays.sort(people);

            int index = 0;
            for(int i=people.length-1; i>=index; i--) {
                if(people[i]+people[index]<=limit) {
                    index++;
                }
                answer++;
            }

            return answer;
        }
    }
}
