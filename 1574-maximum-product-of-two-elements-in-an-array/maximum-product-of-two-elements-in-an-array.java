class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max=0;
        int smax=0;
        for(int i=0;i<n;i++){
            if(nums[i]>max&&nums[i]>smax){
                smax=max;
                max=nums[i];
            }
            else if(nums[i]>smax){
                smax=nums[i];                
            }
        }
        return (smax-1)*(max-1);
    }
}