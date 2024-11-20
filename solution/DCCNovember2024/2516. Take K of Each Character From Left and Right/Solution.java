class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0)
            return 0; // No characters needed.

        int n = s.length();
        int[] count = new int[3]; // Count of 'a', 'b', 'c'

        // Count total frequencies of 'a', 'b', and 'c'.
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // If any character's total count is less than k, return -1.
        for (int i = 0; i < 3; i++) {
            if (count[i] < k)
                return -1;
        }

        // Sliding window to find the longest valid substring.
        int[] windowCount = new int[3];
        int maxWindowSize = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            windowCount[s.charAt(right) - 'a']++;

            // Shrink the window if the outside counts fall below k.
            while (count[0] - windowCount[0] < k ||
                    count[1] - windowCount[1] < k ||
                    count[2] - windowCount[2] < k) {
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }

            // Update the maximum window size.
            maxWindowSize = Math.max(maxWindowSize, right - left + 1);
        }

        // Minimum minutes = total length - max window size.
        return n - maxWindowSize;
    }
}
