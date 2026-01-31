class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') ans.add(a + b);
                        else if (c == '-') ans.add(a - b);
                        else ans.add(a * b);
                    }
                }
            }
        }

        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(expression));
        }
        return ans;
    }
}