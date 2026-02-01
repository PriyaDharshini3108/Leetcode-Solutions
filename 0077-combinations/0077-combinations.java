class Solution {
    public static void solve(int n, int k, List<List<Integer>> answer, List<Integer> combination, int index) {
        if (combination.size() == k) {
            answer.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i <= n; i++) {
            combination.add(i);
            solve(n, k, answer, combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        solve(n, k, answer, combination, 1);
        return answer;
    }
}