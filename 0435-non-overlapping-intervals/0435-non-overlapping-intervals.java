class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) return 0;

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        int[] prev = intervals[0];
        int ans = 0;

        for (int i = 1; i <= intervals.length - 1; i++) {
            int[] curr = intervals[i];

            if (prev[1] > curr[0]) {
                prev[1] = Math.min(prev[1], curr[1]);
                ans++;
            } else {
                prev = curr;
            }
        }
        return ans;
    }
}