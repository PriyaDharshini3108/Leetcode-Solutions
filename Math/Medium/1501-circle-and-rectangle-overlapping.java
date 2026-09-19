// ═══════════════════════════════════════════════════════
// Problem: 1501. Circle and Rectangle Overlapping
// Difficulty: Medium
// Topics: Math, Geometry
// Runtime: 0 ms (Beats 100.0%)
// Memory: 42 MB (Beats 77.3%)
// Submitted: Sep 19, 2026
// Link: https://leetcode.com/problems/circle-and-rectangle-overlapping/
// ═══════════════════════════════════════════════════════

class Solution {
    public boolean checkOverlap(int r, int cx, int cy, int x1, int y1, int x2, int y2) {
        int x = Math.max(x1, Math.min(cx, x2)) - cx;
        int y = Math.max(y1, Math.min(cy, y2)) - cy;

        return x * x + y * y <= r * r;
    }
}
