// 1792. Maximum Average Pass Ratio

// Priority Queue (Max-Heap)
// Greedy Approach
// Runtime: 329ms

// Complexity:
// + Time: O(n + extraSudents * log(n))
// + Space: O(n)

import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Create a max-heap based on the improvement of the average ratio
        PriorityQueue<ClassInfo> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.increment, a.increment));

        // Initialize the heap with the potential increments
        for (int i = 0; i < classes.length; i++) {
            double currentAvg = (double) classes[i][0] / classes[i][1];
            double newAvg = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            double increment = newAvg - currentAvg;
            maxHeap.offer(new ClassInfo(increment, i));
        }

        // Distribute extra students to maximize the average ratio
        while (extraStudents-- > 0) {
            ClassInfo top = maxHeap.poll();
            int idx = top.index;
            classes[idx][0]++;
            classes[idx][1]++;

            double currentAvg = (double) classes[idx][0] / classes[idx][1];
            double newAvg = (double) (classes[idx][0] + 1) / (classes[idx][1] + 1);
            double increment = newAvg - currentAvg;
            maxHeap.offer(new ClassInfo(increment, idx));
        }

        // Calculate the final average
        double totalAvg = 0.0;
        for (int[] clazz : classes) {
            totalAvg += (double) clazz[0] / clazz[1];
        }

        return totalAvg / classes.length;
    }

    // Helper class to hold the increment and index
    private static class ClassInfo {
        double increment;
        int index;

        ClassInfo(double increment, int index) {
            this.increment = increment;
            this.index = index;
        }
    }
}

