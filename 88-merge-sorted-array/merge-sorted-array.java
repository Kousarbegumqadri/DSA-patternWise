class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,id=0;
        int[] res=new int[m+n];
        while(i<m&&j<n){
            if(nums1[i]<nums2[j]){
                res[id]=nums1[i];
                id++;
                i++;
            }
            else{
                res[id]=nums2[j];
                id++;
                j++;
            }
        }
        while(i<m){
            res[id]=nums1[i];
            id++;
            i++;
        }
        while(j<n){
            res[id]=nums2[j];
            id++;
            j++;
        }
        for(int k=0;k<res.length;k++){
            nums1[k]=res[k];
        }
    }
}