// 1462. Course Schedule IV
// Difficulty: Medium

// Floyd-Warshall algorithm
// Runtime: 21ms (27/01/2025 | 11pm - GMT+7)

// Complexity:
// + Time: O(N^3)
// + Space: O(N^2)

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Step 1: Initialize the prerequisite matrix
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];
        
        // Step 2: Populate the matrix with direct prerequisites
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            isPrerequisite[a][b] = true;
        }
        
        // Step 3: Compute transitive closure using Floyd-Warshall
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (isPrerequisite[i][k] && isPrerequisite[k][j]) {
                        isPrerequisite[i][j] = true;
                    }
                }
            }
        }
        
        // Step 4: Answer each query
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];
            result.add(isPrerequisite[u][v]);
        }
        
        return result;
    }
}


