import java.util.*;

class Solution {
    int A, B, C, D;
    int[][][][] memo;
    int[][] digitExp = new int[10][4]; // exponents of (2,3,5,7) per digit

    public String smallestNumber(String num, long t) {
        long tt = t;
        int a = 0, b = 0, c = 0, d = 0;
        while (tt % 2 == 0) { tt /= 2; a++; }
        while (tt % 3 == 0) { tt /= 3; b++; }
        while (tt % 5 == 0) { tt /= 5; c++; }
        while (tt % 7 == 0) { tt /= 7; d++; }
        if (tt != 1) return "-1";
        A = a; B = b; C = c; D = d;

        digitExp[1] = new int[]{0,0,0,0};
        digitExp[2] = new int[]{1,0,0,0};
        digitExp[3] = new int[]{0,1,0,0};
        digitExp[4] = new int[]{2,0,0,0};
        digitExp[5] = new int[]{0,0,1,0};
        digitExp[6] = new int[]{1,1,0,0};
        digitExp[7] = new int[]{0,0,0,1};
        digitExp[8] = new int[]{3,0,0,0};
        digitExp[9] = new int[]{0,2,0,0};

        memo = new int[A+1][B+1][C+1][D+1];
        for (int[][][] x1 : memo)
            for (int[][] x2 : x1)
                for (int[] x3 : x2) Arrays.fill(x3, -1);
        memo[0][0][0][0] = 0;

        int n = num.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) digits[i] = num.charAt(i) - '0';

        // 1) check num itself
        boolean zeroFree = true;
        int[] cur = {0,0,0,0};
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) { zeroFree = false; break; }
            addExp(cur, digitExp[digits[i]]);
        }
        if (zeroFree && cur[0] >= A && cur[1] >= B && cur[2] >= C && cur[3] >= D) {
            return num;
        }

        // 2) same-length search
        int z = n;
        for (int i = 0; i < n; i++) if (digits[i] == 0) { z = i; break; }

        int[][] prefixState = new int[z+1][];
        prefixState[0] = new int[]{0,0,0,0};
        for (int i = 0; i < z; i++) {
            int[] s = prefixState[i].clone();
            addExp(s, digitExp[digits[i]]);
            prefixState[i+1] = s;
        }

        int foundI = -1, foundDg = -1;
        int[] foundRem = null;
        int top = Math.min(z, n - 1);
        for (int i = top; i >= 0; i--) {
            int[] base = prefixState[i];
            for (int dg = digits[i] + 1; dg <= 9; dg++) {
                int[] s = base.clone();
                addExp(s, digitExp[dg]);
                int ra = Math.max(A - s[0], 0);
                int rb = Math.max(B - s[1], 0);
                int rc = Math.max(C - s[2], 0);
                int rd = Math.max(D - s[3], 0);
                int need = minDigits(ra, rb, rc, rd);
                int remainLen = n - 1 - i;
                if (need <= remainLen) {
                    foundI = i; foundDg = dg;
                    foundRem = new int[]{ra, rb, rc, rd};
                    break;
                }
            }
            if (foundI != -1) break;
        }

        StringBuilder sb = new StringBuilder();
        if (foundI != -1) {
            sb.append(num, 0, foundI);
            sb.append((char) ('0' + foundDg));
            int remainLen = n - 1 - foundI;
            appendSuffix(sb, remainLen, foundRem[0], foundRem[1], foundRem[2], foundRem[3]);
        } else {
            int M = minDigits(A, B, C, D);
            int L = Math.max(n + 1, M);
            appendSuffix(sb, L, A, B, C, D);
        }
        return sb.toString();
    }

    private void addExp(int[] s, int[] e) {
        s[0] = Math.min(s[0] + e[0], A);
        s[1] = Math.min(s[1] + e[1], B);
        s[2] = Math.min(s[2] + e[2], C);
        s[3] = Math.min(s[3] + e[3], D);
    }

    private int minDigits(int a, int b, int c, int d) {
        if (memo[a][b][c][d] != -1) return memo[a][b][c][d];
        int best = Integer.MAX_VALUE;
        for (int dg = 2; dg <= 9; dg++) {
            int[] e = digitExp[dg];
            int na = Math.max(a - e[0], 0);
            int nb = Math.max(b - e[1], 0);
            int nc = Math.max(c - e[2], 0);
            int nd = Math.max(d - e[3], 0);
            if (na == a && nb == b && nc == c && nd == d) continue; // no progress
            int r = 1 + minDigits(na, nb, nc, nd);
            if (r < best) best = r;
        }
        memo[a][b][c][d] = best;
        return best;
    }

    private void appendSuffix(StringBuilder sb, int len, int a, int b, int c, int d) {
        int ra = a, rb = b, rc = c, rd = d, remain = len;
        while (remain > 0) {
            for (int dg = 1; dg <= 9; dg++) {
                int[] e = digitExp[dg];
                int na = Math.max(ra - e[0], 0);
                int nb = Math.max(rb - e[1], 0);
                int nc = Math.max(rc - e[2], 0);
                int nd = Math.max(rd - e[3], 0);
                if (minDigits(na, nb, nc, nd) <= remain - 1) {
                    sb.append((char) ('0' + dg));
                    ra = na; rb = nb; rc = nc; rd = nd;
                    remain--;
                    break;
                }
            }
        }
    }
}