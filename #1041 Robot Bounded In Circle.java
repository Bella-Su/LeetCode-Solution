class Solution {
    // An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables)
    private enum Direction{
        NORTH, SOUTH, WEST, EAST;
    }
    
    public boolean isRobotBounded(String instructions) {
        // initial position and direction
        int x = 0, y = 0;
        Direction direction = Direction.NORTH;
        
        for(char instruction: instructions.toCharArray()){
            if(instruction == 'G'){
                switch(direction){
                    case NORTH:
                        y++;
                        break;
                    case SOUTH:
                        y--;
                        break;
                    case WEST:
                        x--;
                        break;
                    case EAST:
                        x++;
                        break;
                }
            }
            if(instruction == 'L'){
                switch(direction){
                    case NORTH:
                        direction = Direction.WEST;
                        break;
                    case SOUTH:
                        direction = Direction.EAST;
                        break;
                    case WEST:
                        direction = Direction.SOUTH;
                        break;
                    case EAST:
                        direction = Direction.NORTH;
                        break;    
                }
            }
            if(instruction == 'R'){
                switch(direction){
                    case NORTH:
                        direction = Direction.EAST;
                        break;
                    case SOUTH:
                        direction = Direction.WEST;
                        break;
                    case WEST:
                        direction = Direction.NORTH;
                        break;
                    case EAST:
                        direction = Direction.SOUTH;
                        break;
                }
            }
        }
        if(x == 0 && y == 0)
            return true;
            
        // if the ending direction is north, then it will never back to origin
        if(direction == Direction.NORTH)
            return false;
        
        // if position is not at the origin and direction is not face north. then return true
        return true;
    }
}