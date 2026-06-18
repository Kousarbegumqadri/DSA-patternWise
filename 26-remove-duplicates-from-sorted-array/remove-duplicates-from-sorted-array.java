class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int off=0;
       nums[off]=nums[0];
        int uniq=1;
        int cm=1;
        while(cm<n){
            if(nums[cm]==nums[cm-1]){
                cm++;
            }
            else{
            off++;
            nums[off]=nums[cm];
            uniq++;
            cm++;
            }
        }
        return uniq;
    }
}