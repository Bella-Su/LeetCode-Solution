class Solution {
    public int myAtoi(String s) {
        int i = 0, num = 0;
        boolean negative = false;
        
        // trim the white space at the beginning of the string
        while(i < s.length() && s.charAt(i) == ' ')
            i++;
        
        // determine if the num will be negative or positive
        if(i < s.length() && s.charAt(i) == '-'){
            negative = true;
            i++;
        }else if(i < s.length() && s.charAt(i) == '+')
            i++;
        
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            // if the num is greater than 32-bit
            if((Integer.MAX_VALUE - digit) / 10 < num){
                if(negative)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        
        if(num == 0)
            return 0;
        else{
            if(negative)
                return -num;
            else
                return num;
        }
    }
}