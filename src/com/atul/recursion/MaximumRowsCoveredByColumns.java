package com.atul.recursion;

public class MaximumRowsCoveredByColumns {
    public static void main(String[] args) {
        int [][] mat = {{0,0,0},{1,0,1},{0,1,1},{0,0,1}};
        int cols = 2;
        boolean[] visited = new boolean[mat[0].length];
        //delete(visited);
        System.out.println(solve(mat, cols, 0, 0, visited));
    }

    private static int solve(int[][] arr, int cols, int index, int curTotalPicked, boolean[] visited) {
        if (index == arr[0].length) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                boolean flag = true;
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 1) {
                        if (!visited[j]) {
                            flag = false;
                        }
                    }
                }

                if (flag) {
                    count++;
                }
            }
            return count;
        }

        int pick = 0;
        if (curTotalPicked < cols) {
            visited[index] = true;
            pick = solve(arr, cols, index + 1, curTotalPicked + 1, visited);
            visited[index] = false;
        }
        int notPick = solve(arr, cols, index +1, curTotalPicked, visited);
        return Math.max(pick, notPick);
    }

    /*int maximumRows(vector<vector<int>>&mat, int cols) {

        int currentCols = 0;
        vector<bool> visited (mat[0].size(), false);
        int ans = 0;
        pickColumns(mat, cols, 0, currentCols, visited, ans);
        return ans;
    }
*/
    /*void pickColumns(vector<vector<int>>&mat, int cols, int index, int currentCols, vector<bool>&visited, int&ans) {
        if (index == mat[0].size()) {
            int count = 0;
            for (int i = 0; i < mat.size(); i++) {
                bool flag = true;
                for (int j = 0; j < mat[0].size(); j++) {
                    if (mat[i][j] == 1) {
                        if (visited[j] == false) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    count++;
                }
            }

            ans = max(ans, count);
            return;
        }
        //pick this column
        if (currentCols < cols) {
            visited[index] = true;
            pickColumns(mat, cols, index + 1, currentCols + 1, visited, ans);
            visited[index] = false;
        }
        //not pick the column
        pickColumns(mat, cols, index + 1, currentCols, visited, ans);
    }*/

}