// 3160. Find the Number of Distinct Colors Among the Balls
// Difficulty: Medium

// DSAs
// Methods & Approaches
// Runtime: 50ms (07/02/2025 | 10pm - GMT+7)

// Complexity:
// + Time: O()
// + Space: O()

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballToColor = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        int m = queries.length;
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int ball = queries[i][0];
            int newColor = queries[i][1];

            // Increase count for newColor
            colorCount.put(newColor, colorCount.getOrDefault(newColor, 0) + 1);

            // If ball was previously colored, update that color's count.
            if (ballToColor.containsKey(ball)) {
                int oldColor = ballToColor.get(ball);
                int updatedCount = colorCount.get(oldColor) - 1;
                if (updatedCount == 0) {
                    colorCount.remove(oldColor);
                } else {
                    colorCount.put(oldColor, updatedCount);
                }
            }
            ballToColor.put(ball, newColor);

            // Number of distinct colors is the size of the colorCount map.
            result[i] = colorCount.size();
        }
        return result;
    }
}
