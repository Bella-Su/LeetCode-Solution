class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        // any number %60 gives remainder 0~59, total 60 possibilities
        int[] remainderMap = new int[60];
        int ans = 0;
        
        // recording the frequency based on the remainder
        for(int songTime: time){
            int remainder = songTime % 60;
            remainderMap[remainder]++; 
        }
        
        // calculating pairs
        // i=1: 1 and 59-> any of the frequency of 0 will result of 0 pair
        for(int i = 1; i < 30; i++){
            ans += remainderMap[i] * remainderMap[60-i];
        }
        
        // two corner cases
        // combination formula: kC2 -> k!/((k-2)!*2!) -> k*(k-1)/2
        if(remainderMap[0] > 0)
            ans += remainderMap[0] * (remainderMap[0] - 1) / 2;
        if(remainderMap[30] > 0)
            ans += remainderMap[30] * (remainderMap[30] - 1) / 2;
        
        return ans;
    }
}
// n is the number of the songs
// Time: O(n)
// Space: O(n)