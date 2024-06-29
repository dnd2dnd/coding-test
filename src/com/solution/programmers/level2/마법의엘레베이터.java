package com.solution.programmers.level2;

public class 마법의엘레베이터 {
    class Solution {
        public int solution(int storey) {
            int answer = 0;

            while(storey!=0) {
                int x = storey%10;
                storey/=10;

                if(x == 5) {
                    if(storey%10 >= 5) {
                        answer += 10-x;
                        storey++;
                    } else {
                        answer += x;
                    }
                } else if (x>5) {
                    answer += 10-x;
                    storey++;
                } else {
                    answer += x;
                }

            }

            return answer;
        }
    }
}
