class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] suf = new int[m + 1];
        suf[m] = n;
        for (int j = m - 1; j >= 0; j--) {
            if (suf[j + 1] == -1) {
                suf[j] = -1;
                continue;
            }
            int p = suf[j + 1] - 1;
            while (p >= 0 && word1.charAt(p) != word2.charAt(j)) p--;
            suf[j] = p; // -1 if not found
        }

        int[] res = new int[m];
        int j = 0, i = 0;
        boolean mismatched = false;

        while (i < m) {
            if (j >= n) return new int[0];
            if (word1.charAt(j) == word2.charAt(i)) {
                res[i] = j;
                j++;
                i++;
            } else if (!mismatched && suf[i + 1] != -1 && j + 1 <= suf[i + 1]) {
                res[i] = j;
                j++;
                mismatched = true;
                i++;
            } else {
                j++; // skip this word1 character
            }
        }
        return res;
    }
}