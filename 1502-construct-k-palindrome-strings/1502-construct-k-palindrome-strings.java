class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()==k) return true;
        else if( s.length()<k) return false;
        HashMap <Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        Set<Character> cs = map.keySet();

        int oddCount = 0;
        for (int freq : map.values()) {
            if (freq % 2 != 0) oddCount++;
        }

        return oddCount <= k;

    }
}