package com.atul.greedy;

import java.util.Arrays;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i < n; i++) {
            sumCost+=cost[i];
            sumGas+=gas[i];
        }
        if(sumGas < sumCost) return -1;
        int index = -1;
        int diff = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            diff += gas[i] - cost[i];
            if(diff < 0){
                diff = 0;
                flag = true;
                continue;
            }
            if(flag){
                index = i;
                flag = false;
            }
        }
        return index;
    }
}
