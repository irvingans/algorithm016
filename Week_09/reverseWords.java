class Solution {
    public String reverseWords(String s) {
       StringBuilder sb = new StringBuilder();
       getReversewords(s,sb,0,false);
       return sb.toString();
    }

    public void getReversewords(String input, StringBuilder sb, int start,boolean flag){
        while(start < input.length() && input.charAt(start) == ' ') start++;
        if(start == input.length()) return;
        int end = start;
        while(end < input.length() && input.charAt(end) != ' ') end++;
        getReversewords(input,sb,end, true);
        sb.append(input.substring(start,end));

        if(flag) sb.append(' ');
    }
}
