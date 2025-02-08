// 2349. Design a Number Container System
// Difficulty: Medium

// DSAs
// Methods & Approaches
// Runtime: 79ms (08/02/2025 | 10pm - GMT+7)

// Complexity:
// + Time: O(log n) for find() and O(1) for change()
// + Space: O(M) where M is the number of unique numbers

class NumberContainers {
    // Mapping from index to number currently stored.
    private Map<Integer, Integer> indexToNum;
    // Mapping from number to a sorted set of indices.
    private Map<Integer, TreeSet<Integer>> numToIndices;

    public NumberContainers() {
        indexToNum = new HashMap<>();
        numToIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        // If index already has a number, remove it from its set.
        if (indexToNum.containsKey(index)) {
            int oldNumber = indexToNum.get(index);
            TreeSet<Integer> set = numToIndices.get(oldNumber);
            set.remove(index);
        }
        // Set new number for the index.
        indexToNum.put(index, number);
        // Add index to the corresponding number set.
        numToIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        // Return the smallest index if exists; otherwise, -1.
        if (!numToIndices.containsKey(number) || numToIndices.get(number).isEmpty()) {
            return -1;
        }
        return numToIndices.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
