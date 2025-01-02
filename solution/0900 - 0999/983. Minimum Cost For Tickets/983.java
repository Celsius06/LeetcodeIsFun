// 983. Minimum Cost For Tickets

// Memoization Array, Dynamic Programming, Recursive Traversal
// Runtime: 0ms

// Complexity:
// + Time: O(n)
// + Space: O(n)

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] memo = new int[days.length];
        Arrays.fill(memo, -1);
        return dfs(0, days, costs, memo);
    }

    private int dfs(int i, int[] days, int[] costs, int[] memo) {
        if (i >= days.length)
            return 0;
        if (memo[i] != -1)
            return memo[i];

        int oneDay = costs[0] + dfs(i + 1, days, costs, memo);
        int j = i;
        while (j < days.length && days[j] < days[i] + 7)
            j++;
        int sevenDays = costs[1] + dfs(j, days, costs, memo);
        j = i;
        while (j < days.length && days[j] < days[i] + 30)
            j++;
        int thirtyDays = costs[2] + dfs(j, days, costs, memo);

        return memo[i] = Math.min(oneDay, Math.min(sevenDays, thirtyDays));
    }
}
