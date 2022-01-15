class Solution {
    public String addBinary(String a, String b) {
        String ans = "";
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        
        while(i >= 0 || j >= 0){
            int x = (i >= 0) ? a.charAt(i)-'0' : 0;
            int y = (j >= 0) ? b.charAt(j)-'0' : 0;
            int sum = x + y + carry;
            carry = sum / 2;
            ans = sum%2 + ans;
            i--;
            j--;
        }
        
        if(carry != 0)
            ans = carry + ans;
        
        return ans;   
    }
}