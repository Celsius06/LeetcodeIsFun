// 1352. Product of the Last K Numbers
// Difficulty: Medium
// Link: https://leetcode.com/problems/product-of-the-last-k-numbers/

// List
// Prefix
// Runtime: 16ms (14/02/2025 | 8pm - GMT+7)

// Complexity:
// + Time: O(1) for add() and O(1) for getProduct()
// + Space: O(n) for prefix list

class ProductOfNumbers {
    // List to store cumulative (prefix) products.
    // We start with an initial value of 1 to simplify multiplication.
    List<Long> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1L);
    }

    public void add(int num) {
        // If num is 0, we cannot use previous products,
        // so we clear the list and start fresh.
        if (num == 0) {
            prefix.clear();
            prefix.add(1L);
        } else {
            // Multiply the last product with num and add it.
            long last = prefix.get(prefix.size() - 1);
            prefix.add(last * num);
        }
    }

    public int getProduct(int k) {
        // If k is greater than or equal to the size of the prefix list,
        // that means a 0 was encountered within the last k numbers.
        if (k >= prefix.size()) {
            return 0;
        }
        // Total product of all numbers so far.
        long total = prefix.get(prefix.size() - 1);
        // Product of numbers before the last k numbers.
        long divisor = prefix.get(prefix.size() - 1 - k);
        // The product of the last k numbers is total / divisor.
        return (int) (total / divisor);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
