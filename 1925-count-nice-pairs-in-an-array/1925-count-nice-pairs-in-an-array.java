class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            map.put(i - reverse(i), map.getOrDefault(i - reverse(i), 0) + 1);
        }
      
        long count = 0; 
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            long value = e.getValue();
            count = (count + (value * (value - 1) / 2)) % 1000000007;
        }
        
        return (int) count;
    }
    
    private int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        return Integer.parseInt(sb.reverse().toString());
    }
}