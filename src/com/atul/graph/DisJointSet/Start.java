package com.atul.graph.DisJointSet;

import java.util.ArrayList;
import java.util.List;

public class Start {
    class DisJointSet{
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisJointSet(int n){
            for (int i = 0; i <=n ; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        int findUP(int node){
            if(node == parent.get(node)) {
                return node;
            }
            int up = findUP(parent.get(node));
            parent.set(node, up);
            return up;
        }

        void unionByRank(int u, int v){
            int pu = findUP(u);//parent.get(u);
            int pv = findUP(v);//parent.get(v);
            if(pv == pu) return;
            if(rank.get(pu) < rank.get(pv)){
                parent.set(pu, pv);
            }else if(rank.get(pv) < rank.get(pv)){
                parent.set(pv, pu);
            }else {
                parent.set(pv, pu);
                rank.set(pu, rank.get(pu)+1);
            }
        }

        void unionBySize(int u, int v){
            int pu = findUP(u);//parent.get(u);
            int pv = findUP(v);//parent.get(v);
            if(pv == pu) return;
            if(size.get(pu) < size.get(pv)){
                parent.set(pu, pv);
                size.set(pv, size.get(pu)+size.get(pv));
            }else {
                parent.set(pv, pu);
                size.set(pu, size.get(pv)+size.get(pu));
            }
        }
    }
}
