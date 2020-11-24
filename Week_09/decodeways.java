class Solution {
    public int numDecodings(String s) {
        int pre = 1;
        int cur = 1;
        if(s.charAt(0)=='0'){
            return 0;
        }
        for(int i = 1; i<s.length() ;i++){
            int temp = cur;
            if(s.charAt(i-1)=='1'){
                if(s.charAt(i) == '0'){
                    cur = pre; 
                }
                else{
                    cur += pre;
                }
            }
            else if(s.charAt(i-1)=='2'){
                if(s.charAt(i) == '0'){
                    cur = pre; 
                }
                else if(s.charAt(i)>='1' && s.charAt(i)<='6'){
                    cur += pre;
                }
            }
            else if(s.charAt(i)=='0'&&(s.charAt(i-1)=='0'||s.charAt(i-1)>='3'))
                return 0; 
            pre = temp;
        }
        return cur;
    }
}
