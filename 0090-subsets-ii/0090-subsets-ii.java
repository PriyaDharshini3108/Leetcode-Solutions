class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        findSubset(result,new Stack<>(),0,nums);
        return result;
    }
    void findSubset(List<List<Integer>> result,Stack<Integer> st,int i,int[] nums ) {
        if(i>=nums.length) {
            result.add(new ArrayList<>(st));
            return;
        }
        //include 
        st.push(nums[i]);
        findSubset(result,st,i+1,nums);
        st.pop();
        //skippingDuplicates
        while(i+1<nums.length && nums[i]==nums[i+1]) i++;
        findSubset(result,st,i+1,nums);
    }
}