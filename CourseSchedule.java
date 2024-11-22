// Approach : Graph Problem with edges as pre requisites and vertices as courses. Build an adjacency map (independent & dependent) and in-degrees array
// (incoming edges of graph or dependent courses array)
// Time :
// Space : 
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>(); // {independent : dependent}
        int [] indegrees = new int[numCourses]; // [dependent courses count] [0,0,0,0,0]

        // Build Map & in degrees array
        for(int[] pr: prerequisites){ // O(Edges * Vertices)
            indegrees[pr[0]]++;
            if(!adjacencyList.containsKey(pr[1])){
                adjacencyList.put(pr[1],new ArrayList<>());
            }
            adjacencyList.get(pr[1]).add(pr[0]);
        }

        int count =0;
        Queue<Integer> q = new LinkedList<>();
        // iterate through in degrees array to find intial independent courses
        for(int i =0;i<numCourses;i++){ // O(Vertices)
            if(indegrees[i]==0){
                q.add(i);
                count++;
            }
        }

        if(count == numCourses) return true;
        if(q.isEmpty()) return false;

        // take independent nodes into queue
        while(!q.isEmpty()){ // O(V + E)
            int curr = q.poll();
            List<Integer> dependents = adjacencyList.get(curr); // for each vertex
            for(int dependent : dependents){
                indegrees[dependent]--;
                if(indegrees[dependent] == 0){
                    q.add(dependent);
                    count++;
                    if(count == numCourses){
                        return true;
                    }
                }

            }
        }
        return false;

    }
}