class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        // fing the max number of banana in one pile
        for(int pile : piles) {
            right = Math.max(right, pile);
        }
        
        // implement binary search
        while(left < right){
            int mid = (left + right) / 2;
            int hourSpent = 0;
            
            for(int pile : piles){
                // Math.ceil() return smallest integer that greater or equal to argument
                hourSpent += Math.ceil((double) pile / mid);
            }

            // if the current speed is workable, then reduce the speed by half
            if(hourSpent <= h)
                right = mid; //can not use mid-1, it will skip values
            else
                left = mid + 1;
        }
        return right;
    }
}
// n is number of piles, m is the initial search space for eating speed
// Time: O(nlogm)
// space: O(1)