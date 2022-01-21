class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // check if we have a solution
        int totalGas = 0;
        int totalCost = 0;
        for(int i = 0; i < gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost)
            return -1;
        
        int remainGas =0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            // rule out the gas station that cannot be starting station
            remainGas += gas[i] - cost[i];
            if(remainGas < 0){
                start = i + 1;
                remainGas = 0;
            }
        }
        // since it is guaranteed to be unique solution, so we don't need optimization, simply return
        return start;
    }
}
// n is the number of stations
// Time: O(n)
// Space: O(1)