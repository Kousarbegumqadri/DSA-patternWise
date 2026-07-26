class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=firstOccurance(nums,target);
        int last=lastOccurance(nums,target);
        return new int[] {first,last};
    }
    int firstOccurance(int[] nums,int target){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int res=-1;
        while(low<=high){
            int guess=(low+high)/2;
            if(nums[guess]==target){
                res=guess;
                high=guess-1;
            }
            else if(nums[guess]<target){
                low=guess+1;
            }
            else{
               // res=guess;
                high=guess-1;
            }
        }
        return res;
    }
   // low=res;
     int lastOccurance(int[] nums,int target){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int res=-1;
        while(low<=high){
            int guess=(low+high)/2;
            if(nums[guess]==target){
                res=guess;
                low=guess+1;
            }
            else if(nums[guess]<target){
                low=guess+1;
            }
            else{
                high=guess-1;
            }
        }
        return res;
    }
}