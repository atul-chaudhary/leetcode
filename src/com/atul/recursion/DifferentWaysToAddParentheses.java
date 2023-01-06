package com.atul.recursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        String s = "0+1";
        System.out.println(diffWaysToCompute(s));
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                String str1 = expression.substring(0, i);
                String str2 = expression.substring(i + 1);
                List<Integer> res1 = diffWaysToCompute(str1);
                List<Integer> res2 = diffWaysToCompute(str2);

                for (int j = 0; j < res1.size(); j++) {
                    for (int k = 0; k < res2.size(); k++) {
                        if (expression.charAt(i) == '+') {
                            result.add(res1.get(j) + res2.get(k));
                        } else if (expression.charAt(i) == '-') {
                            result.add(res1.get(j) - res2.get(k));
                        } else {
                            result.add(res1.get(j) * res2.get(k));
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(expression));
        }
        return result;
    }
}
