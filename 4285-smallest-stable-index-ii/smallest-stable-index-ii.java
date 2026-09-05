class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int j;
        //int minans=Integer.MAX_VALUE;
        if(nums[0]==0){return 0;}
        int[] suff=new int[n];
        suff[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i]=Math.min(suff[i+1],nums[i]);
        } 
        int max=nums[0];
            for(j=0;j<n;j++){
            max=Math.max(max,nums[j]);
            int min=suff[j];
            int ans=max-min;
            if(ans<=k){
                return j;
            }
            }
        return -1;
    }
}