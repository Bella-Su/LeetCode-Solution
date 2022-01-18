class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        for(int i = 0; i < m && n > 0; i++){
            if(flowerbed[i] == 0){
                // check if the previou and the next plots availible
                int prevPlot = (i == 0) ? 0 : flowerbed[i - 1];
                int nextPlot = (i == m-1) ? 0 : flowerbed[i + 1];

                if(prevPlot == 0 && nextPlot == 0){
                    flowerbed[i] = 1; // plant a flower
                    n--; // decrease the number of new flowers
                }
            }
        }
        return n == 0;
    }
}