class Solution {
    public int minJumps(int[] arr) {
        // List<Integer> for store indices that with the same value
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            List<Integer> indices = map.getOrDefault(arr[i], new ArrayList<>());
            indices.add(i);
            map.put(arr[i], indices);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // start at the first index of the given array
        boolean[] visited = new boolean[arr.length];
        int level = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Integer head = queue.poll();
                // if reach the end, we return the level
                if(head == arr.length-1)
                    return level;
                
                // if head out of bound, continue the loop
                if(head < 0 || head >= arr.length || visited[head])
                    continue;
                
                // previous index
                if(head-1 > 0 && !visited[head-1])
                    queue.offer(head-1);
                
                // next index
                if(head+1 < arr.length && !visited[head+1])
                    queue.offer(head+1);
                
                // children
                if(map.containsKey(arr[head])){
                    for(int index : map.get(arr[head])){
                        if(index >= 0 && index < arr.length && !visited[index])
                            queue.offer(index);
                    }
                    map.remove(arr[head]);
                }
                visited[head] = true;
            }
            level++;
        }
        return -1;
    }
}
//Time: worse O(n^2) get the element at the last level of the queue