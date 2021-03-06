class Solution {
    class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2]; // each child has size of 2, for 0 and 1
        }
    }
    
    private Trie root;
    
    private void buildTrie(int[] nums){
		for(int num: nums) {
			Trie curNode = root;
			for(int i = 31; i >= 0; i --) {
				int curBit = (num >>> i) & 1;
				if(curNode.children[curBit] == null) {
					curNode.children[curBit] = new Trie();
				}
				curNode = curNode.children[curBit];
			}
		}
	}
    
    private int findMaxXorForCurrentEl(int num){
        Trie curNode = root;
        int targetNum = 0;
        for(int i = 31; i >= 0; i --) {
            int curBit = (num >>> i) & 1;
            int targetBit = curBit == 0 ? 1:0;
            if(curNode.children[targetBit] != null) {
                targetNum = targetNum*2 +targetBit;
                curNode = curNode.children[targetBit];
            }else {
                targetNum = targetNum*2 +curBit;
                curNode = curNode.children[curBit];
            }
        }
		return targetNum;
    }
    
    public int findMaximumXOR(int[] nums) {
        // inverse of the number will result the max result
        if(nums == null || nums.length == 0)
            return 0;
        
        // init Trie
        root = new Trie();
        buildTrie(nums);
        
		int max = Integer.MIN_VALUE;
		for(int num: nums) {
			int maxXORForNum = findMaxXorForCurrentEl(num);
			max = Math.max(maxXORForNum ^ num, max);
		}
		return max;  
    }
}