class Solution {
    public int compareVersion(String version1, String version2) {
        String[] vs1 = version1.split("\\.");
        String[] vs2 = version2.split("\\.");

        int m = vs1.length, n = vs2.length;
        int maxLen = Math.max(m, n);

        for (int i = 0; i < maxLen; i++) {
            int v1 = (i < m) ? Integer.parseInt(vs1[i]) : 0;
            int v2 = (i < n) ? Integer.parseInt(vs2[i]) : 0;

            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }

        return 0;
    }
}