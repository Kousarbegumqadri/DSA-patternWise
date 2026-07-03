class Solution {
    public int maximumSum(int[] nums) {
        int n =nums.length;
        int noDelete=nums[0];
        int oneDelete=Integer.MIN_VALUE;
        int res=nums[0];
        for(int i=1;i<n;i++){
            int prenoDelete=noDelete;
            int preOneDelete=oneDelete;
            noDelete=Math.max(noDelete+nums[i],nums[i]);
            int v2=0;
            if(preOneDelete==Integer.MIN_VALUE){
            v2=nums[i];
            }
            else{
                v2=preOneDelete+nums[i];
            }
            oneDelete=Math.max(v2,prenoDelete);   
            res=Math.max(res,Math.max(noDelete,oneDelete));
        }
        return res;
    }
}