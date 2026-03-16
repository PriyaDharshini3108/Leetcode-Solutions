class Solution {
   private static final Map<Integer, String> mp = new LinkedHashMap<>();
    static {
        mp.put(1000000000, "Billion");
        mp.put(1000000, "Million");
        mp.put(1000, "Thousand");
        mp.put(100, "Hundred");
        mp.put(90, "Ninety");
        mp.put(80, "Eighty");
        mp.put(70, "Seventy");
        mp.put(60, "Sixty");
        mp.put(50, "Fifty");
        mp.put(40, "Forty");
        mp.put(30, "Thirty");
        mp.put(20, "Twenty");
        mp.put(19, "Nineteen");
        mp.put(18, "Eighteen");
        mp.put(17, "Seventeen");
        mp.put(16, "Sixteen");
        mp.put(15, "Fifteen");
        mp.put(14, "Fourteen");
        mp.put(13, "Thirteen");
        mp.put(12, "Twelve");
        mp.put(11, "Eleven");
        mp.put(10, "Ten");
        mp.put(9, "Nine");
        mp.put(8, "Eight");
        mp.put(7, "Seven");
        mp.put(6, "Six");
        mp.put(5, "Five");
        mp.put(4, "Four");
        mp.put(3, "Three");
        mp.put(2, "Two");
        mp.put(1, "One");
        mp.put(0, "Zero");
    }

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        for (Map.Entry<Integer, String> entry : mp.entrySet()) {
            if (num >= entry.getKey()) {
                String start = "";
                if (num >= 100) {
                    start = numberToWords(num / entry.getKey()) + " ";
                }

                String placeValue = entry.getValue();

                String end = "";
                if (num % entry.getKey() != 0) {
                    end = " " + numberToWords(num % entry.getKey());
                }
                return start + placeValue + end;
            }
        }
        return "";
    }
}