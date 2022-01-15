class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0)
            return 1;
        
        int multi = 1;
        int ans = 0;
        
        while(n != 0){
            int binaryRep = (n % 2 == 0) ? 1 : 0;
            n /= 2;
            ans += binaryRep * multi;
            multi *= 2;
        }
        return ans;
    }
}