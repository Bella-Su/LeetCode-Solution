class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] passengers = new int[1001];
        int currCapacity = 0;
        
        // iterate all trips and record them into an array
        // index are the every from and to location
        for(int i = 0; i < trips.length; i++){
            passengers[trips[i][1]] += trips[i][0];
            passengers[trips[i][2]] -= trips[i][0];
        }
        
        // adding all the corresponding passengers
        for(int CurrPassenger: passengers){
            currCapacity += CurrPassenger;
            if(currCapacity > capacity)
                return false;
        }
        return true;
    }
}
// Time: O(n)
// Space: O(n)