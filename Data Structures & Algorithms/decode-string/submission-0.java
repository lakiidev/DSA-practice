class Solution {
    public String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> prevs = new ArrayDeque<>();

        StringBuilder curr = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                counts.push(k);
                prevs.push(curr);
                curr = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder inner = curr;
                curr = prevs.pop();
                int times = counts.pop();
                for (int i = 0; i < times; i++) curr.append(inner);
            } else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}