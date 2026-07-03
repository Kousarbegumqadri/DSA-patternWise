class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int bestending=nums[0];
        int res=nums[0];
        for(int i=1;i<n;i++){
            int v1=nums[i];
            int v2=bestending+nums[i];
            bestending=Math.max(v1,v2);
            res=Math.max(bestending,res);
        }
        return res;
    }
}