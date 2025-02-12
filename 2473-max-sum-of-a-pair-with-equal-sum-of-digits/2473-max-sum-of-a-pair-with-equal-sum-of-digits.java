class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i : nums) {
            int key = digSum(i);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(i);
        }
        int maxSum=-1;
        for(int i : map.keySet()){
            if(map.get(i).size()==2){
                maxSum = Math.max(maxSum,map.get(i).get(0)+map.get(i).get(1));
            }
            else if(map.get(i).size()>2){
                Collections.sort(map.get(i), Collections.reverseOrder());
                maxSum = Math.max(maxSum,map.get(i).get(0)+map.get(i).get(1));
            }
        }

        return maxSum;
    }

    private int digSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}