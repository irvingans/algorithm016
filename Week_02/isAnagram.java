class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] alfs = new int[26];
        for(int i=0;i<s.length();i++){
            alfs[s.charAt(i)-'a']++;
            alfs[t.charAt(i)-'a']--;
        }

        for(int j=0;j<alfs.length;j++){
            if(alfs[j]!=0){
                return false;
            }
        }
        return true;
    }
}
