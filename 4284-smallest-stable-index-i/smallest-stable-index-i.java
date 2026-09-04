class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int max=nums[0];
        int j;
        int minans=Integer.MAX_VALUE;
        if(nums[0]==0){return 0;}
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            int min=nums[i];
            for(j=i;j<n;j++){
            min=Math.min(min,nums[j]);
            }
            int ans=max-min;
            if(ans<=k){
                return i;
            }
        }
        return -1;
    }
}