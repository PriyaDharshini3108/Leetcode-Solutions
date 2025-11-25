class Solution {
    public int[] searchRange(int[] nums, int target) {
    
        int n=nums.length;
        
        int[] t={-1,-1};
        int l=s(nums, target, true);
        int r=s(nums, target, false);
        t[0]=l; t[1]=r;
       return t;

    }
    int s(int[] nums, int t, boolean aa){
        int ans=-1;
        int n=nums.length;
        int l=0, r=n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(t<nums[mid]){
                r=mid-1;
            }
            else if(t>nums[mid]){
                l=mid+1;
            }
            else{
                ans=mid;
                if(aa){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            
            }
        }return ans;
    }
}