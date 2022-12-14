package com.atul.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveSubFoldersFromTheFilesystem {
    static class Node {
        Map<String, Node> links = new HashMap<>();
        boolean isEnd;
        String word;

        boolean containsKey(String s) {
            return links.get(s) != null;
        }

        void put(String s, Node node) {
            links.put(s, node);
        }

        Node get(String s) {
            return links.get(s);
        }
    }

    public static void main(String[] args) {
        String[] folder = {"/a/b/c","/a/b/ca","/a/b/d"};
        System.out.println(removeSubfolders(folder));
    }

    public static List<String> removeSubfolders(String[] folder) {
        Node root = new Node();
        for (String it : folder) {
            insert(root, it);
        }
        List<String> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private static void dfs(Node root, List<String> result){
        if(root.isEnd){
            result.add(root.word);
            return;
        }

        for (Map.Entry<String, Node>  entry : root.links.entrySet()){
            dfs(entry.getValue(), result);
        }
    }

    private static void insert(Node root, String s) {
        Node node = root;
        String[] arr = s.split("/");
        for (String it : arr) {
            if (!node.containsKey(it)) {
                node.put(it, new Node());
            }
            node = node.get(it);
        }
        node.isEnd = true;
        node.word = s;
    }

}
