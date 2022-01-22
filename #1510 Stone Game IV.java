class Solution {
    Boolean[] dp = new Boolean[100000+1];
    public boolean winnerSquareGame(int n) {   
        // base case
        if(dp[n] != null)
            return dp[n];
        
        Boolean aliceWins = false;
        for(int move = 1; n >= move * move; move++){
            //Alice start first, if below move is true, she will do so
            if(n - move * move == 0){
                aliceWins = true;
                break;
            }else
                // since they are play alternate
                // return the statement that Allice wins and make sure Bob not win
                // if (n-move*move) set aliceWins=true -> !true = false, alice will lose
                aliceWins = aliceWins || !winnerSquareGame(n - move * move);
        }
        return dp[n] = aliceWins;
    }
}