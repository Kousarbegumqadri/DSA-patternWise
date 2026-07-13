class Solution {
    public String reverseWords(String s) {
        StringBuilder srt=new StringBuilder();
        int end=s.length()-1;

        while(end>=0){
            while(end>=0 && s.charAt(end)==' '){
                end--;
            }
            if(end<0){
                break;
            }
            int start=end;
            while(start>=0 && s.charAt(start)!=' '){
                start--;
            }
            srt.append(s.substring(start+1,end+1));
            srt.append(" ");
            end=start;
        }
        return srt.toString().trim();
    }
}