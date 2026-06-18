// ═══════════════════════════════════════════════════════
// Problem: 1446. Angle Between Hands of a Clock
// Difficulty: Medium
// Topics: Math
// Runtime: 0 ms (Beats 100.0%)
// Memory: 44.9 MB (Beats 43.6%)
// Submitted: Jun 18, 2026
// Link: https://leetcode.com/problems/angle-between-hands-of-a-clock/
// ═══════════════════════════════════════════════════════

class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteAngle = 6.0 * minutes;
        double hourAngle = 30.0 * (hour % 12) + 0.5 * minutes;

        double diff = Math.abs(hourAngle - minuteAngle);

        return Math.min(diff, 360.0 - diff);
    }
}
