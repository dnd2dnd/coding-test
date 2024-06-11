package com.solution.programmers.level2;

import java.util.*;

public class 택배상자 {
    class Solution {
        public int solution(int[] order) {
            int answer = 0;
            Stack<Integer> stackA = new Stack<>();
            Stack<Integer> stackB = new Stack<>();

            for(int i=order.length; i>=1; i--){
                stackA.push(i);
            }

            int i=0;
            while(!stackA.isEmpty()) {
                int x = order[i];
                int a = stackA.peek();
                if(x==a) {
                    stackA.pop();
                    answer++;
                    i++;
                } else {
                    if(!stackB.isEmpty()) {
                        int b = stackB.peek();
                        if(x==b) {
                            stackB.pop();
                            answer++;
                            i++;
                        } else {
                            stackB.push(stackA.pop());
                        }
                    } else {
                        stackB.push(stackA.pop());
                    }

                }
            }

            while(!stackB.isEmpty()) {
                int x = order[i];
                int b = stackB.pop();
                if(x==b) {
                    answer++;
                    i++;
                } else{
                    break;
                }
            }

            return answer;
        }
    }
}
