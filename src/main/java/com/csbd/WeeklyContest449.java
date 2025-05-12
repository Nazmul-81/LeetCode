package com.csbd;

import java.util.*;

public class WeeklyContest449 {

    public static int minDeletion(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count + 1);
        }
        int n = map.size() - k;
        int ans = 0;
        int index = 0;

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);

        for (Integer value : list) {
            if (index < n) {
                ans += value;
            }
            index++;
        }

        return ans;
    }


    public static boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowSum = new int[m];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }
            rowSum[i] = sum;
            if (i > 0) {
                rowSum[i] = rowSum[i - 1] + sum;
            }
        }
        for (int i = 0; i < m - 1; i++) {
            if (rowSum[i] == (rowSum[m - 1] - rowSum[i]))
                return true;
        }

        int[] colSum = new int[n];
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += grid[i][j];
            }
            colSum[j] = sum;
            if (j > 0) {
                colSum[j] = colSum[j - 1] + sum;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (colSum[i] == (colSum[n - 1] - colSum[i]))
                return true;
        }

        return false;
    }

    public long maxScore(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] ab : edges) {
            graph[ab[0]].add(ab[1]);
            graph[ab[1]].add(ab[0]);
        }

        Arrays.sort(graph, Comparator.comparingInt(List::size));

        long product = 0;
        int assignNumber = n;
        boolean[] visited = new boolean[n];

        for (int i = graph.length - 1; i > -1; i--) {
            if(visited[i])
                continue;
            if(graph[i].size() == 2){
                visited[i] = true;
                product +=  ((long) assignNumber * (--assignNumber));
                Integer first = graph[i].get(0);
                Integer second = graph[i].get(1);
                if(graph[first].size() > graph[second].size()){

                }
            }

        }
        return 0L;

    }


    public static void main(String[] args) {
        //minDeletion("yyyzz", 1);
        int[][] grids = {
                {1, 2, 3},
                {4, 5, 5},
                {5, 6, 7}
        };
        System.out.println(canPartitionGrid(grids));
    }
}