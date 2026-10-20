class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        for (String part : path.split("/")) {
            if (part.isEmpty() || part.equals("."))
                continue;
            if (part.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(part);
            }
        }
        if (stack.isEmpty())
            return "/";

        StringBuilder sb = new StringBuilder();
        Iterator it = stack.descendingIterator();
        while (it.hasNext()) sb.append("/").append(it.next());

        return sb.toString();
    }
}
