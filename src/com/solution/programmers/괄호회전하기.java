package com.solution.programmers;

import java.util.Stack;

public class 괄호회전하기 {
    class Solution {
        public int solution(String s) {
            int answer = 0;


            for(int i=0; i<s.length(); i++) {
                StringBuilder st = new StringBuilder();
                Stack<Character> stack = new Stack<>();
                st.append(s.substring(i, s.length()));
                st.append(s.substring(0, i));

                String str = st.toString();
                for(int k=0; k<s.length(); k++) {
                    char c = str.charAt(k);
                    if(c == '[' || c=='(' || c=='{') {
                        stack.add(c);
                    } else {
                        if(stack.size()==0) {
                            break;
                        } else {
                            if(stack.peek()=='[' && c==']') {
                                stack.pop();
                            } else if(stack.peek()=='(' && c==')') {
                                stack.pop();
                            } else if(stack.peek()=='{' && c=='}') {
                                stack.pop();
                            } else {
                                break;
                            }
                        }

                    }

                    if(k==s.length()-1 && stack.size()==0) {
                        answer++;
                    }
                }
            }

            return answer;
        }
    }
}
