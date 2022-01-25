class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        
        //upward
        for(;i+1 < n; i++){
            if(arr[i] < arr[i+1]){}
            else
                break;
        }
        
        // check the progress of above
        if(i == 0 || i == n-1)
            return false;
        
        // downward
        for(; i+1 < n; i++){
            if(arr[i] > arr[i+1]){}
            else
                break;
        }
        return i == n-1;
    }
}
// n is the length of the arr
// time: O(n)
// space: O(1)