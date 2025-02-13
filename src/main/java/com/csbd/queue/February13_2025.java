package com.csbd.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class February13_2025 {
    public int minOperations(int[] nums, int k) {
        // 3066. Minimum Operations to Exceed Threshold Value II

        Queue<Long> queue = new PriorityQueue<>();

        for (int n : nums) {
            queue.add((long) n);
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            if(queue.peek() >= k)
                break;
            long x = queue.poll();
            long y = queue.poll();
            queue.add(x * 2 + y);
            ans++;
        }
        return ans;
    }
}
