class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
       int altitude=0;
       int maxaltitude=0;
       for(int g:gain){
        altitude+=g;
        maxaltitude=Math.max(maxaltitude,altitude);
       }
       return maxaltitude;
    }
}