class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int high=0;
        int n=nums.length;
        int low=0;
        int sum=0;
        int len=0;
        int res=Integer.MAX_VALUE;
       for(high=0;high<n;high++){
        sum=sum+nums[high];
        while(sum>=target){
            len=high-low+1;
            res=Math.min(len,res);
            sum=sum-nums[low];
            low++;
        }
       }
        return res==Integer.MAX_VALUE ? 0 : res;
    }
}