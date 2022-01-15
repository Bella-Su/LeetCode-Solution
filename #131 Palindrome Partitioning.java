class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> currList = new ArrayList<>();
        
        if(s == null || s.length() == 0)
            return ans;
        
        helper(0, ans, currList, s);
        return ans;
    }
    
    private void helper(int index, List<List<String>> ans, List<String> currList, String s){
        // base case for the recusion
        if(index == s.length()){
            ans.add(new ArrayList<>(currList));
            return;
        }
        
        // iterate the whole string
        for(int i = index; i < s.length(); i++){            
            if(isPalindrome(index, i, s)){
                // add the first part in the current list
                currList.add(s.substring(index,i+1));
                
                // revusively sending the second part of the string to the helper function
                helper(i+1, ans, currList, s);
                
                // backtracking remove the added element
                currList.remove(currList.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(int index, int i, String s){
        // String reversedStr = new StringBuilder(str).reverse().toString();
        // return str.equals(reversedStr);
        while(index < i){
            if(s.charAt(index++) != s.charAt(i--))
                return false;
        }
        return true;
    }
}