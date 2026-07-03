class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n=nums.length;
        int maxending=nums[0];
        int minending=nums[0];
        int maxres=nums[0];
        int minres=nums[0];
        //int z=nums[0];
        for(int i=1;i<n;i++){
            int v1=nums[i];
            int v2=maxending+nums[i];
            int v3=minending+nums[i];
            maxending=Math.max(v1,v2);
            minending=Math.min(v1,v3);
            maxres=Math.max(maxres,maxending);
            minres=Math.min(minres,minending);
            //z=Math.max(Math.abs(maxres),Math.abs(minres));
        }
        return Math.max(Math.abs(maxres),Math.abs(minres));
    }
}