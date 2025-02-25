class Solution {
    private Map<Integer, Integer> bobPath;
    private boolean[] visited;
    private List<List<Integer>> tree;
    private int maxIncome = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        tree = new ArrayList<>();
        bobPath = new HashMap<>();
        visited = new boolean[n];
        for(int i=0; i<n; i++)
        {
            tree.add(new ArrayList<>());
        }

        for(int[] edge : edges)
        {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        bobPath(bob, 0);

        Arrays.fill(visited, false);
        alicePath(0, 0, 0, amount);

        return maxIncome;
    }

    private boolean bobPath(int node, int time)
    {
        bobPath.put(node, time);
        visited[node] = true;

        if(node == 0) return true;

        for(int adjNode : tree.get(node))
        {
            if(!visited[adjNode] && bobPath(adjNode, time+1)) return true;
        }

        bobPath.remove(node);
        return false;
    }

    private void alicePath(int node, int time, int income, int[] amount)
    {
        visited[node] = true;
        if(!bobPath.containsKey(node) || time < bobPath.get(node)) income += amount[node];
        else if(time == bobPath.get(node)) income += amount[node]/2;
        if(tree.get(node).size() == 1 && node != 0) maxIncome = Math.max(maxIncome, income);

        for(int adjNode : tree.get(node))
        {
            if(!visited[adjNode])
            {
                alicePath(adjNode, time+1, income, amount);
            }
        }
    }
}