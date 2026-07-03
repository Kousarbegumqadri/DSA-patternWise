class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int maxending=nums[0];
        int minending=nums[0];
        int maxres=nums[0];
        int minres=nums[0];
        //int z=nums[0];
        int sum=nums[0];
        int z=0;
        for(int i=1;i<n;i++){
            int v1=nums[i];
            int v2=maxending+nums[i];
            int v3=minending+nums[i];
            maxending=Math.max(v1,v2);
            minending=Math.min(v1,v3);
            maxres=Math.max(maxres,maxending);
            minres=Math.min(minres,minending);
            sum=sum+nums[i];
        }
        if(maxres<0){
            return maxres;
        }
        z=sum-minres;
        return Math.max(z,maxres);
    }
}