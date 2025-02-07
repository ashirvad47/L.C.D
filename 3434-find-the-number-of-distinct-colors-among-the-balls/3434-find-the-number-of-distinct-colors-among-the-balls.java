class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> colo = new HashMap<>();
        HashMap<Integer, Integer> ball = new HashMap<>(); 
        int[] res = new int[queries.length]; 

        for (int i = 0; i < queries.length; i++) {
            int ballNumber = queries[i][0];
            int newColor = queries[i][1];

            if (ball.containsKey(ballNumber)) {
                int oldColor = ball.get(ballNumber);
                colo.put(oldColor, colo.get(oldColor) - 1);

                if (colo.get(oldColor) == 0) {
                    colo.remove(oldColor);
                }
            }

            ball.put(ballNumber, newColor);
            colo.put(newColor, colo.getOrDefault(newColor, 0) + 1);

            res[i] = colo.size();
        }

        return res;
    }
}
