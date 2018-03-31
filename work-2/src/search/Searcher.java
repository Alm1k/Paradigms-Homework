package search;

class Searcher {
    // Pre: a[] - find array, can't be null
    // For all i: a[i] >= a[i + 1]
    // -1 <= l <= r <= a[].length
    // l - index of the last number that exactly greater than key (default -1)
    // r - index of the first number that may be our answer (default a.length)
    // key - value for searching
    // useRecursiveAlgorithm - boolean for algorithm choosing
    static int find(int[] a, int l, int r, int key, boolean useRecursiveAlgorithm) {
        // Algorithm realisation chooser
        if (useRecursiveAlgorithm) {
            // Pre defined before .find
            return searchRecursive(a, l, r, key);
            // Post defined after .find
        }
        else {
            // Pre defined before .find
            return searchIterative(a, l, r, key);
            // Post defined after .find
        }
    }
    // Post: 1) (a[i]' == a[i]) && (key' == key)
    // 2.1) useRecursiveAlgorithm is true -> .searchRecursive is called
    // 2.2) useRecursiveAlgorithm is false -> .searchIterative is called
    // 3.1) (a[].length == 0 || a[0] <= key) -> (R = 0)
    // 3.2) (a[].last > key) -> (R = a.length)
    // 3.3) (0 <= R <= a[].length) -> (For all 0 <= i < R: a[i] > key) && (For all R <= i < a.length: a[i] <= key)

    // Pre defined before .find
    private static int searchIterative(int[] a, int l, int r, int key) {
        // While the search boundary contains more than one number we are trying to cut our border in half
        while (r - l > 1) {
            // So, we find middle element
            int m = (l + r) / 2;
            // l <= m <= r
            // Compare it with find key
            if (a[m] <= key) {
                // This means that all numbers to the right of the middle will be less or equal
                // For all i >= m: a[i] <= key
                // (m - l) < (r - l)
                r = m;
                // r also first number that may be our answer, because it's minimal, that we find yet
            } else {
                // This means that all numbers to the left of the middle will be greater
                // For all i <= m: a[i] > a[i]
                // (r - m) < (r - l)
                l = m;
                // l also last number that exactly greater than key, because it's maximum, that we find yet
            }
            // We halved the search boundary
        }

        // (r - l == 1) -> we have one element in our boundary, let's return this
        return r;
    }
    // Post defined after .find

    // Pre defined before .find
    private static int searchRecursive(int[] a, int l, int r, int key) {
        // If search boundary contains more than one number we are call recursive with smaller boundary
        // Answer will be correct and will return to calling method
        if (r - l > 1) {
            // Find middle element
            int m = (l + r) / 2;
            // l <= m <= r
            // Compare it with find key
            if (a[m] <= key) {
                // This means that all numbers to the right of the middle will be less or equal
                // For all i >= m: a[i] <= key
                // Let's start our function by substituting middle instead of right
                // (m - l) < (r - l)
                return searchRecursive(a, l, m, key);
                // We returned founded value
            } else {
                // This means that all numbers to the left of the middle will be greater
                // For all i <= m: a[i] > a[i]
                // Let's start our function by substituting middle instead of left
                // (r - m) < (r - l)
                return searchRecursive(a, m, r, key);
                // We returned founded value
            }
        }

        // (r - l == 1) -> we have one element in our boundary, let's return this
        return r;
    }
    // Post defined after .find
}
