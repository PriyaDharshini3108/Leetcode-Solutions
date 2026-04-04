class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        int[] res = new int[n];
        int pointer = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            if (operations[i].equals("C")) {
                pointer--;
            } 
            else if (operations[i].equals("D")) {
                res[pointer] = 2 * res[pointer - 1];
                pointer++;
            } 
            else if (operations[i].equals("+")) {
                res[pointer] = res[pointer - 1] + res[pointer - 2];
                pointer++;
            } 
            else {
                res[pointer] = Integer.parseInt(operations[i]);
                pointer++;
            }
        }

        for (int i = 0; i < pointer; i++) {
            sum += res[i];
        }

        return sum;
    }
}