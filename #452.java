class Solution {
    public int findMinArrowShots(int[][] points) {
        // sorting array by the ending points
        // -> (a[1]-b[1]) when we doing substraction, the sum can greater then the max integer
        // -> Integer.compare(a[1],b[1]) for comparsion to avoid
        Arrays.sort(points, (a,b) -> Integer.compare(a[1],b[1]));
        
        //first arrow will take care of the first ballon and reach to the end of the first ballon
        int arrow = 1;
        int reach = points[0][1];
        
        // checking if the next ballon overlap with the previous one by compare the reach
        // if not, use new arrow
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > reach){
                arrow++;
                reach = points[i][1];
            }else {
                
            }
        }
        return arrow;
    }
}