class Solution {
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> sequentialDigits(int low, int high) {
        for(int i = 1; i <= 9 ; i++)
            dfs(low, high, i, 0);
        
        Collections.sort(ans);
        return ans;
    }
    
    private void dfs(int low, int high, int i, int num){
        if(num >= low && num <= high)
            ans.add(num);
        if(num > high || i > 9)
            return;
        dfs(low, high, i+1, num*10+i);
    }
}
// 1, 12, 123, ..., 123456789 in worst case.
// 2 ...
// ... 
// sorting takes O(nlogn)
// total time: O(nlogn) 