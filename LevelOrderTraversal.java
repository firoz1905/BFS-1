/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Approach : BFS
// Level by Level processing => Add root to the queue initially. 
// Now iterate through the size (level boundary) of the queue and
// poll the nodes and then process. 
// Now check left and right (if they exists) then add those new nodes to the queue. 
// Time : O(n) // each node is processed exactly once.
// Space : O(n) // (O(n/2) nodes only at any given time in the queue)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size(); //1
            List<Integer> levelElements = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                levelElements.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            result.add(levelElements);
        }
        return result;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Approach : DFS - Using Map Level Order Traversal
// Time : O(n) + O(n) // create Map and Iterate through Map 
// Space : O(n) + O(n) // recursive stack space and Map size
class Solution {
    List<List<Integer>> result;
    HashMap<Integer,ArrayList<Integer>> map;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        if(root == null) return result;

        this.map = new HashMap<Integer, ArrayList<Integer>>();
        
        helper(root,0);
        // iterate through the map and get values
        for(int i = 0;i<map.size();i++){
            result.add(map.get(i));
        }
        System.out.println(map);
        return result;
    }

    public void helper(TreeNode root , int depth ){
        // Base case
        if(root == null) return;
        // root = stk.pop()

        // logic
        if(!map.containsKey(depth)){
            map.put(depth,new ArrayList<Integer>());
        } 
        map.get(depth).add(root.val);
        
        // Recursion
        helper(root.left,depth+1);
        helper(root.right,depth+1);
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Approach :
// Time : O(n)
// Space:  O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        if(root == null) return result;

        helper(root,0);
        return result;
    }

    private void helper(TreeNode root , int depth){
        // base case
        if (root == null){
            return;
        }

        // logic
        if(result.size() == depth){
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);

        // recurison - Pre Order
        helper(root.left,depth+1);
        helper(root.right, depth+1);
    }
}