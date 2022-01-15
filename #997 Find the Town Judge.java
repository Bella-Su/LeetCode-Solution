class Solution {
    public int findJudge(int n, int[][] trust) {
        // the record from 1 to n, we are not going to use 0
        int[] isJudge = new int[n+1];
        
        for(int i = 0; i < trust.length; i++){
            // [i][0] is not judge, so it will be --
            // [i][1] gain one person's trust, so ++
            isJudge[trust[i][0]]--;
            isJudge[trust[i][1]]++;
        }
        
        for(int i = 1; i < isJudge.length; i++){
            // if the person got all people's trust but himselft or herself (n-1), then this is the judge
            if(isJudge[i] == n-1)
                return i;
        }
        return -1;
    }
}