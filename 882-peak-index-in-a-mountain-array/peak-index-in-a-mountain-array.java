class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int mid=0,low=0,high=n-1;
        int res=-1;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]<arr[mid+1]){
               low=mid+1;
                
            }
            else{
                res=mid;
                high=mid-1;
            }
        }
        return res;
    }
}