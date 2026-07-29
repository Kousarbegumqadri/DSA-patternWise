class Solution {
    static final long LIMIT = 1_000_001;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int[] half = new int[26];
        String middle = "";

        int halfLen = 0;
        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            halfLen += half[i];
            if ((freq[i] & 1) == 1)
                middle = String.valueOf((char) ('a' + i));
        }

        if (countWays(half, halfLen) < k)
            return "";

        StringBuilder left = new StringBuilder();

        while (halfLen > 0) {

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0)
                    continue;

                half[c]--;

                long ways = countWays(half, halfLen - 1);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    halfLen--;
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + middle + right;
    }

    private long countWays(int[] half, int total) {

        long ans = 1;

        int rem = total;

        for (int i = 0; i < 26; i++) {

            if (half[i] == 0)
                continue;

            ans *= nCrLimited(rem, half[i]);

            if (ans > LIMIT)
                ans = LIMIT;

            rem -= half[i];
        }

        return ans;
    }

    private long nCrLimited(int n, int r) {

        r = Math.min(r, n - r);

        long res = 1;

        for (int i = 1; i <= r; i++) {

            res = res * (n - r + i) / i;

            if (res > LIMIT)
                return LIMIT;
        }

        return res;
    }
}