package com.atul.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImplementMagicDictionary {
    public static void main(String[] args) {

    }

    class MagicDictionary {
        List<String> list = null;
        public MagicDictionary() {
            list = new ArrayList<>();
        }

        public void buildDict(String[] dictionary) {
            list.addAll(Arrays.asList(dictionary));
        }

        public boolean search(String searchWord) {
            int n = list.size();
            for (String it : list){
                if(check(it, searchWord)){
                    return true;
                }
            }
            return false;
        }

        private boolean check(String dict, String word){
            int n = dict.length();
            int m = word.length();
            if(n != m) return false;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if(dict.charAt(i) != word.charAt(i)) count++;
                if(count >= 2) return false;
            }
            return count == 1;
        }
    }

}
