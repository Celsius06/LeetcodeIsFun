// 2109. Adding Spaces to a String

// StringBuilder 
// Runtime: 22ms

// Complexity:
// + Time: O(n + m)
// + Space: O(n + m)

class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int n = spaces.length;

        for (int i = 0; i < s.length(); i++) {
            if (index < n && i == spaces[index]) {
                result.append(' ');
                index++;
            }
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}