class Solution {

    class Node {
        char leftChar;
        char rightChar;
        int prefix;
        int suffix;
        int max;
        int length;

        Node(char leftChar, char rightChar,
             int prefix, int suffix, int max, int length) {
            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.max = max;
            this.length = length;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        int n = s.length();
        int k = queryIndices.length;

        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            // Update the character
            arr[index] = ch;

            // Update segment tree
            update(1, 0, n - 1, index, ch);

            // Root contains answer for entire string
            ans[i] = tree[1].max;
        }

        return ans;
    }

    // Build segment tree
    private void build(int node, int left, int right) {

        if (left == right) {
            char ch = arr[left];

            tree[node] = new Node(
                ch, ch,
                1, 1, 1,
                1
            );

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    // Update one position
    private void update(int node, int left, int right,
                        int index, char ch) {

        if (left == right) {

            tree[node] = new Node(
                ch, ch,
                1, 1, 1,
                1
            );

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, right, index, ch);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    // Merge two nodes
    private Node merge(Node left, Node right) {

        char leftChar = left.leftChar;
        char rightChar = right.rightChar;

        int prefix = left.prefix;
        int suffix = right.suffix;

        int max = Math.max(left.max, right.max);

        int length = left.length + right.length;

        // If boundary characters are equal,
        // the suffix of left and prefix of right can join.
        if (left.rightChar == right.leftChar) {

            max = Math.max(
                max,
                left.suffix + right.prefix
            );

            // Entire left segment has same character
            if (left.prefix == left.length) {
                prefix = left.length + right.prefix;
            }

            // Entire right segment has same character
            if (right.suffix == right.length) {
                suffix = right.length + left.suffix;
            }
        }

        return new Node(
            leftChar,
            rightChar,
            prefix,
            suffix,
            max,
            length
        );
    }
}