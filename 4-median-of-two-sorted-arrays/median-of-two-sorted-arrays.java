class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int i=0,j=0;
        int[] arr=new int[m+n];
        int k=0;
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                arr[k]=nums1[i];
                i++;
                k++;
            }
            else{
                arr[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<n){
            arr[k]=nums1[i];
            i++;
            k++;
        }
        while(j<m){
            arr[k]=nums2[j];
            j++;
            k++;
        }
        //int low=0,high=arr.length-1;
        int len=arr.length;
            if(len%2==0){
                return (double)(arr[(len/2)-1]+arr[len/2])/2;
            }
            else{
                return arr[len/2];
            }
    }
}