class Solution {
    public long[] distance(int[] nums) {
        int len = nums.length;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        long[] res = new long[len];
        for(int ky: map.keySet()){
            List<Integer> ind = map.get(ky);
            int sz = ind.size();

            long[] preSum = new long[sz];
            preSum[0] = ind.get(0);
            for(int i = 1;i < sz; i++){
                preSum[i] = (preSum[i-1] + ind.get(i));
            }

            for(int i = 0;i < sz;i++){
                long ttlLft = (long) ind.get(i) * (i);
                long ttlRgt = (long) ind.get(i) * (sz-i-1);

                long mulLft = 0;
                if(i > 0) mulLft = preSum[i-1];
                
                long mulRgt = preSum[sz-1] - preSum[i];
                
                long sum = ttlLft-mulLft;
                sum += (mulRgt-ttlRgt);
                
                res[ind.get(i)] = sum;
            }
        }
        
        return res;
    }
}