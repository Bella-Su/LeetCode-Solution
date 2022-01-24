class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if(n == 1)
            return true;
        
        // check for all upper case
        if(Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))){
            for(int i = 2; i < n; i++){
                if(Character.isLowerCase(word.charAt(i)))
                    return false;
            }
        }
        // check for only first upper case or all lower cases
        else {
            for(int i = 1; i < n; i++){
                if(Character.isUpperCase(word.charAt(i)))
                    return false;
            }
        }
        return true;
    }
}
// n is length of the word
// time: O(n)
// space: O(1)