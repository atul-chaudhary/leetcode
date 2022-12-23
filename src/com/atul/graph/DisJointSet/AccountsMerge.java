package com.atul.graph.DisJointSet;

import java.util.*;

public class AccountsMerge {
    public static void main(String[] args) {
        String[][] edges = {{"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"John", "johnsmith@mail.com", "john00@mail.com"}, {"Mary", "mary@mail.com"}, {"John", "johnnybravo@mail.com"}};
        HashMap<String, Integer> map = new HashMap<>();
        int n = edges.length;
        for (int i = 0; i < n; i++) {

        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisJointSet ds = new DisJointSet(n);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            //String name = accounts.get(i).get(0);
            int size = accounts.get(i).size();
            for (int j = 1; j < size; j++) {
                String mail = accounts.get(i).get(j);
                if(map.containsKey(mail)){
                    ds.unionBySize(map.get(mail), i);
                }else {
                    map.put(mail, i);
                }
            }
        }

        List<List<String>> mergeMail = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mergeMail.add(new ArrayList<>());
        }
        for (Map.Entry<String , Integer> entry : map.entrySet()){
            String mail = entry.getKey();
            int node = ds.findUP(entry.getValue());
            mergeMail.get(node).add(mail);
        }

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(mergeMail.get(i).isEmpty()) continue;
            String name = accounts.get(i).get(0);
            List<String> temp = new ArrayList<>();
            temp.add(name);
            Collections.sort(mergeMail.get(i));
            temp.addAll(mergeMail.get(i));
            result.add(temp);
        }
        return result;
    }

    static class DisJointSet {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        public DisJointSet(int n) {
            for (int i = 0; i < n; i++) {
                size.add(1);
                parent.add(i);
            }
        }

        int findUP(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int up = findUP(parent.get(node));
            parent.set(node, up);
            return up;
        }

        void unionBySize(int u, int v) {
            int pu = findUP(u);
            int pv = findUP(v);
            if (pu == pv) {
                return;
            }

            if (size.get(pu) < size.get(pv)) {
                parent.set(pu, pv);
                size.set(pv, size.get(pu) + size.get(pv));
            } else {
                parent.set(pv, pu);
                size.set(pu, size.get(pv) + size.get(pu));
            }
        }
    }
}
